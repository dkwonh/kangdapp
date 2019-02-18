package kangwon.cs.kangdapp;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by WH on 2016-06-29.
 */
public class SchoolMeal extends AppCompatActivity {
    int getInt= 0;
    ProgressBar mProgress;
    int position = 5;
    ArrayList<String> day;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private GoogleApiClient client;
    TPAMenu pagerAdapter;
    MenuWebView menuWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("천지관 주간 식단");

        day = new ArrayList<>();
        mProgress = (ProgressBar) findViewById(R.id.progress4);
        tabLayout = (TabLayout) findViewById(R.id.menutab);
        menuWebView = new MenuWebView(day);

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        viewPager = (ViewPager) findViewById(R.id.menupager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Shuttle Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://kangwon.cs.kangdapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Shuttle Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://kangwon.cs.kangdapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    private int doDayOfWeek() {
        Calendar cal = Calendar.getInstance();

        int nWeek = cal.get(Calendar.DAY_OF_WEEK);
        nWeek = nWeek-2;
        if(nWeek == -1)
            nWeek = 0;
        return nWeek;
    }
    public class MenuWebView {
        String TAG = "TAG";
        String url = "http://knucoop.or.kr/weekly_menu_01.asp";
        ArrayList<String> detail;
        soupAsyncTask jsoup = new soupAsyncTask();
        MenuWebView(ArrayList<String> detail){
            this.detail = detail;
            jsoup.execute();
        }


        class soupAsyncTask extends AsyncTask<Void, Void, Void> {
            int i = -1;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                mProgress.setVisibility(View.VISIBLE);
            }

            @Override
            protected Void doInBackground(Void...params){
                try{
                    Document doc = Jsoup.connect(url).maxBodySize(0).timeout(15000).get();
                    //Log.d(TAG,"doc size : " + doc);
                    Elements links = doc.select("html > body > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr > td");
                    for (Element link : links) {
                        if(i<1){
                            i++;
                            continue;
                        }
                        if(link.text().equals(""))
                            detail.add("정보가 없습니다.");
                        else
                            detail.add(link.text());

                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void unused){
                try {
                    tabLayout.addTab(tabLayout.newTab().setText(day.get(0)));
                    tabLayout.addTab(tabLayout.newTab().setText(day.get(1)));
                    tabLayout.addTab(tabLayout.newTab().setText(day.get(2)));
                    tabLayout.addTab(tabLayout.newTab().setText(day.get(3)));
                    tabLayout.addTab(tabLayout.newTab().setText(day.get(4)));
                    tabLayout.addTab(tabLayout.newTab().setText(day.get(5)));
                } catch (Exception e){
                    Log.d("Exception : ", ""+e);
                    Toast.makeText(getApplication(),"메뉴를 불러올 수 없습니다. 잠시후 다시 시도해주세요.",Toast.LENGTH_SHORT).show();
                }finally {
                    pagerAdapter = new TPAMenu(getSupportFragmentManager(), tabLayout.getTabCount(), day);
                    viewPager.setAdapter(pagerAdapter);
                    mProgress.setVisibility(View.INVISIBLE);
                    viewPager.setCurrentItem(doDayOfWeek());
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();

        switch(id){
            case R.id.action_button:
                Intent intentHome = new Intent(this, MainActivity.class);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intentHome);
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
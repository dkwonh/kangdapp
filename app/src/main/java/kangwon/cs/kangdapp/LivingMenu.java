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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by WH on 2016-10-31.
 */
public class LivingMenu extends AppCompatActivity {
    int getInt, i;
    int position=5;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private GoogleApiClient client;
    ArrayList<String> child, child2;
    TPALivingMenu pagerAdapter;
    MenuParser menuParser;
    ProgressBar mProgress;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.living_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        child = new ArrayList<>();
        child2 = new ArrayList<>();
        mProgress = (ProgressBar)findViewById(R.id.progress);
        i = intent.getIntExtra("set",1);
        menuParser = new MenuParser(child, child2);

        if(i==1)
            setTitle("일반 기숙사 식단표");
        else
            setTitle("BTL 기숙사 식단표");
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutSN);

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = (ViewPager) findViewById(R.id.pagerliving);

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


    public class MenuParser {
        ArrayList<String> child, child2;
        String url = "http://knudorm.kangwon.ac.kr/home/sub02/sub02_05_bj.jsp";
        MenuSyncTask menuSyncTask = new MenuSyncTask();
        MenuParser(ArrayList<String> child, ArrayList<String> child2){
            this.child = child;
            this.child2 = child2;
            menuSyncTask.execute();
        }

        class MenuSyncTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mProgress.setVisibility(View.VISIBLE);
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Document doc = Jsoup.connect(url).maxBodySize(0).timeout(15000).get();
                    Elements links, links2;
                    links = doc.select("div#foodtab1 table.table_type01 > tbody > tr > td");
                    links2 = doc.select("div#foodtab2 table.table_type01 > tbody > tr > td");
                    for (Element e : links){
                        child.add(e.text());
                    }
                    for(Element s : links2){
                        child2.add(s.text());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void unused) {
                try {
                    String s = child.get(0);
                    tabLayout.addTab(tabLayout.newTab().setText("월"));
                    tabLayout.addTab(tabLayout.newTab().setText("화"));
                    tabLayout.addTab(tabLayout.newTab().setText("수"));
                    tabLayout.addTab(tabLayout.newTab().setText("목"));
                    tabLayout.addTab(tabLayout.newTab().setText("금"));
                    tabLayout.addTab(tabLayout.newTab().setText("토"));
                    tabLayout.addTab(tabLayout.newTab().setText("일"));
                } catch (Exception e){
                    Log.d("Exception : ", ""+e);
                    Toast.makeText(getApplication(),"메뉴를 불러올 수 없습니다. 잠시후 다시 시도해주세요.",Toast.LENGTH_SHORT).show();
                }finally {
                    if (i == 1)
                        pagerAdapter = new TPALivingMenu(getSupportFragmentManager(), tabLayout.getTabCount(), child);
                    else if(i == 2)
                        pagerAdapter = new TPALivingMenu(getSupportFragmentManager(), tabLayout.getTabCount(), child2);
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

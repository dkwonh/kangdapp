package kangwon.cs.kangdapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class SchoolCalendar extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private GoogleApiClient client;
    private ArrayList<String> day;
    private GridView gridView;
    private GridAdapter gridAdapter;

    int getInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_calendar);
        setTitle("학사 일정");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        //tvDate = (TextView)findViewById(R.id.tv_date);
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutA);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = (ViewPager) findViewById(R.id.pagerA);
        gridView = (GridView)findViewById(R.id.gridView);
        long now = System.currentTimeMillis();
        final Date date = new Date(now);

        final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
        final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);

        getInt = intent.getIntExtra("index", 0);

        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 02"));
        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 03"));
        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 04"));
        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 05"));
        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 06"));
        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 07"));
        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 08"));
        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 09"));
        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 10"));
        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 11"));
        tabLayout.addTab(tabLayout.newTab().setText(curYearFormat.format(date).substring(2) + ". 12"));
        tabLayout.addTab(tabLayout.newTab().setText(String.valueOf(Integer.parseInt(curYearFormat.format(date)) + 1).substring(2) + ". 01"));
        tabLayout.addTab(tabLayout.newTab().setText(String.valueOf(Integer.parseInt(curYearFormat.format(date)) + 1).substring(2) + ". 02"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = (ViewPager) findViewById(R.id.pagerA);

        day = new ArrayList<String>();
        day.add("일");
        day.add("월");
        day.add("화");
        day.add("수");
        day.add("목");
        day.add("금");
        day.add("토");
        gridAdapter = new GridAdapter(getApplicationContext(), day);
        gridView.setAdapter(gridAdapter);
        TPAC pagerAdapter = new TPAC(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(getInt);

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
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

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
    /**
     *
     *
     *
     */

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
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
import android.widget.ProgressBar;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by WH on 2016-09-22.
 */
public class SubWayMain extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private GoogleApiClient client;
    static ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subway);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = (ProgressBar)findViewById(R.id.SubProgress1);
        setTitle("지하철 시간표");


        tabLayout = (TabLayout) findViewById(R.id.tabLayoutSubway);
        tabLayout.addTab(tabLayout.newTab().setText("경춘선"));
        tabLayout.addTab(tabLayout.newTab().setText("ITX-청춘"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pagerSubway);

        TPASub pagerAdapter = new TPASub(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

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




//토요일
    /*<style type="text/css">
            .tg  {border-collapse:collapse;border-spacing:0;border-color:#999;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#999;color:#444;background-color:#F7FDFA;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#999;color:#fff;background-color:#26ADE4;}
    .tg .tg-6vl3{background-color:#00bfff;color:#ffffff}
    .tg .tg-iulr{color:#fe0000}
    .tg .tg-i0og{color:#000000}
    .tg .tg-cxhk{background-color:#1834c4}
    .tg .tg-yw4l{vertical-align:top}
    .tg .tg-at8w{color:#444444}
    .tg .tg-mejs{color:#fe0000;vertical-align:top}
    .tg .tg-tucp{color:#6665cd;vertical-align:top}
    </style>
    <table class="tg">
    <tr>
    <th class="tg-cxhk" colspan="2">토요일</th>
    </tr>
    <tr>
    <td class="tg-6vl3">시</td>
    <td class="tg-6vl3">분</td>
    </tr>
    <tr>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
    </tr>
    <tr>
    <td class="tg-031e">05</td>
    <td class="tg-at8w">38 </td>
    </tr>
    <tr>
    <td class="tg-031e">06</td>
    <td class="tg-iulr">16 50</td>
    </tr>
    <tr>
    <td class="tg-031e">07</td>
    <td class="tg-031e">21 44</td>
    </tr>
    <tr>
    <td class="tg-031e">08</td>
    <td class="tg-031e">08 34</td>
    </tr>
    <tr>
    <td class="tg-031e">09</td>
    <td class="tg-iulr">04 22 47</td>
    </tr>
    <tr>
    <td class="tg-031e">10</td>
    <td class="tg-i0og">15 44</td>
    </tr>
    <tr>
    <td class="tg-031e">11</td>
    <td class="tg-031e">10 33 53</td>
    </tr>
    <tr>
    <td class="tg-yw4l">12</td>
    <td class="tg-mejs">11 44</td>
    </tr>
    <tr>
    <td class="tg-yw4l">13</td>
    <td class="tg-yw4l">13 39</td>
    </tr>
    <tr>
    <td class="tg-yw4l">14</td>
    <td class="tg-yw4l">07 29 47</td>
    </tr>
    <tr>
    <td class="tg-yw4l">15</td>
    <td class="tg-mejs">09 39</td>
    </tr>
    <tr>
    <td class="tg-yw4l">16</td>
    <td class="tg-yw4l">10 39</td>
    </tr>
    <tr>
    <td class="tg-yw4l">17</td>
    <td class="tg-mejs">04 22 45</td>
    </tr>
    <tr>
    <td class="tg-yw4l">18</td>
    <td class="tg-mejs">08 41</td>
    </tr>
    <tr>
    <td class="tg-yw4l">19</td>
    <td class="tg-yw4l">06 32 50</td>
    </tr>
    <tr>
    <td class="tg-yw4l">20</td>
    <td class="tg-mejs">13 39</td>
    </tr>
    <tr>
    <td class="tg-yw4l">21</td>
    <td class="tg-mejs"> 08 37 54</td>
    </tr>
    <tr>
    <td class="tg-yw4l">22</td>
    <td class="tg-yw4l">18 48</td>
    </tr>
    <tr>
    <td class="tg-yw4l">23</td>
    <td class="tg-tucp">13</td>
    </tr>
    </table>*/

    //일요일
    /*<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;border-color:#999;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#999;color:#444;background-color:#F7FDFA;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#999;color:#fff;background-color:#26ADE4;}
.tg .tg-6vl3{background-color:#00bfff;color:#ffffff}
.tg .tg-iulr{color:#fe0000}
.tg .tg-i0og{color:#000000}
.tg .tg-cxhk{background-color:#1834c4}
.tg .tg-yw4l{vertical-align:top}
.tg .tg-at8w{color:#444444}
.tg .tg-mejs{color:#fe0000;vertical-align:top}
.tg .tg-tucp{color:#6665cd;vertical-align:top}
</style>
<table class="tg">
  <tr>
    <th class="tg-cxhk" colspan="2">일요일</th>
  </tr>
  <tr>
    <td class="tg-6vl3">시</td>
    <td class="tg-6vl3">분</td>
  </tr>
  <tr>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-031e">05</td>
    <td class="tg-at8w">38 </td>
  </tr>
  <tr>
    <td class="tg-031e">06</td>
    <td class="tg-iulr">16 50</td>
  </tr>
  <tr>
    <td class="tg-031e">07</td>
    <td class="tg-031e">21 44</td>
  </tr>
  <tr>
    <td class="tg-031e">08</td>
    <td class="tg-031e">04 34</td>
  </tr>
  <tr>
    <td class="tg-031e">09</td>
    <td class="tg-iulr">02 22 47</td>
  </tr>
  <tr>
    <td class="tg-031e">10</td>
    <td class="tg-i0og">15 44</td>
  </tr>
  <tr>
    <td class="tg-031e">11</td>
    <td class="tg-031e">10 33 53</td>
  </tr>
  <tr>
    <td class="tg-yw4l">12</td>
    <td class="tg-mejs">11 44</td>
  </tr>
  <tr>
    <td class="tg-yw4l">13</td>
    <td class="tg-yw4l">13 40</td>
  </tr>
  <tr>
    <td class="tg-yw4l">14</td>
    <td class="tg-yw4l">07 29 47</td>
  </tr>
  <tr>
    <td class="tg-yw4l">15</td>
    <td class="tg-mejs">09 39</td>
  </tr>
  <tr>
    <td class="tg-yw4l">16</td>
    <td class="tg-yw4l">10 35</td>
  </tr>
  <tr>
    <td class="tg-yw4l">17</td>
    <td class="tg-mejs">04 16 45</td>
  </tr>
  <tr>
    <td class="tg-yw4l">18</td>
    <td class="tg-mejs">08 43</td>
  </tr>
  <tr>
    <td class="tg-yw4l">19</td>
    <td class="tg-yw4l">06 32 50</td>
  </tr>
  <tr>
    <td class="tg-yw4l">20</td>
    <td class="tg-mejs">13 39</td>
  </tr>
  <tr>
    <td class="tg-yw4l">21</td>
    <td class="tg-mejs"> 08 37 54</td>
  </tr>
  <tr>
    <td class="tg-yw4l">22</td>
    <td class="tg-yw4l">18 48</td>
  </tr>
  <tr>
    <td class="tg-yw4l">23</td>
    <td class="tg-tucp">13</td>
  </tr>
</table>*/

    //평일
    /*<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;border-color:#999;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#999;color:#444;background-color:#F7FDFA;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#999;color:#fff;background-color:#26ADE4;}
.tg .tg-6vl3{background-color:#00bfff;color:#ffffff}
.tg .tg-iulr{color:#fe0000}
.tg .tg-i0og{color:#000000}
.tg .tg-cxhk{background-color:#1834c4}
.tg .tg-yw4l{vertical-align:top}
.tg .tg-mejs{color:#fe0000;vertical-align:top}
.tg .tg-tucp{color:#6665cd;vertical-align:top}
</style>
<table class="tg">
  <tr>
    <th class="tg-cxhk" colspan="2">일요일</th>
  </tr>
  <tr>
    <td class="tg-6vl3">시</td>
    <td class="tg-6vl3">분</td>
  </tr>
  <tr>
    <td class="tg-yw4l"></td>
    <td class="tg-yw4l"></td>
  </tr>
  <tr>
    <td class="tg-031e">05</td>
    <td class="tg-iulr">03 32 58</td>
  </tr>
  <tr>
    <td class="tg-031e">06</td>
    <td class="tg-i0og">27 47</td>
  </tr>
  <tr>
    <td class="tg-031e">07</td>
    <td class="tg-031e">04 16 45</td>
  </tr>
  <tr>
    <td class="tg-031e">08</td>
    <td class="tg-iulr">18 35 53</td>
  </tr>
  <tr>
    <td class="tg-031e">09</td>
    <td class="tg-iulr">17 33 58</td>
  </tr>
  <tr>
    <td class="tg-031e">10</td>
    <td class="tg-i0og">31 53</td>
  </tr>
  <tr>
    <td class="tg-031e">11</td>
    <td class="tg-031e">18 39</td>
  </tr>
  <tr>
    <td class="tg-yw4l">12</td>
    <td class="tg-mejs">00 24 53</td>
  </tr>
  <tr>
    <td class="tg-yw4l">13</td>
    <td class="tg-yw4l">17 39</td>
  </tr>
  <tr>
    <td class="tg-yw4l">14</td>
    <td class="tg-yw4l">07 33 56</td>
  </tr>
  <tr>
    <td class="tg-yw4l">15</td>
    <td class="tg-mejs">24 46</td>
  </tr>
  <tr>
    <td class="tg-yw4l">16</td>
    <td class="tg-yw4l">06 31 54</td>
  </tr>
  <tr>
    <td class="tg-yw4l">17</td>
    <td class="tg-mejs">23 33 53</td>
  </tr>
  <tr>
    <td class="tg-yw4l">18</td>
    <td class="tg-mejs">16 48</td>
  </tr>
  <tr>
    <td class="tg-yw4l">19</td>
    <td class="tg-yw4l">19 44</td>
  </tr>
  <tr>
    <td class="tg-yw4l">20</td>
    <td class="tg-mejs">06 25 45</td>
  </tr>
  <tr>
    <td class="tg-yw4l">21</td>
    <td class="tg-mejs">07 28 46</td>
  </tr>
  <tr>
    <td class="tg-yw4l">22</td>
    <td class="tg-yw4l">06 27 48</td>
  </tr>
  <tr>
    <td class="tg-yw4l">23</td>
    <td class="tg-tucp">08 28</td>
  </tr>
</table>*/
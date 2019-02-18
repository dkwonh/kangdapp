package kangwon.cs.kangdapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

/**
 * Created by WH on 2016-09-19.
 */
public class BusStation extends AppCompatActivity {
    private String title = "";
    public static String busUp;
    public static String busDown;
    public static String numUp;
    public static String numDown;
    static ProgressBar progressBar;
    BusStationParser busStationParser;
    String url;
    BusAdapter busAdapter1;
    BusAdapter busAdapter2;
    ListView busList1;
    ListView busList2;
    BusData busData;
    BusData busData2;
    BusNumParser busNumParser;
    ArrayList<NumData> mList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_station);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = (ProgressBar) findViewById(R.id.busProgress3);
        Intent intent = getIntent();
        title = intent.getStringExtra("busTitle");
        busUp = intent.getStringExtra("busUP");
        numUp = intent.getStringExtra("numUP");
        setTitle(title);

        busAdapter1 = new BusAdapter(this);
        busAdapter2 = new BusAdapter(this);
        busStationParser = new BusStationParser(busAdapter1,busAdapter2,BusStation.busUp);

        busList1 = (ListView)findViewById(R.id.busView);
        busList2 = (ListView)findViewById(R.id.busView2);

        busList1.setAdapter(busAdapter1);

        busList1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                busData = busStationParser.allBusList.get(((TextView)v.findViewById(R.id.bus_number)).getText().toString());
                String busNum = busData.number;
                String id1="";
                for(NumData n : mList){
                    String temp = n.number;
                    if(busNum.equals(temp)){
                        id1 = n.ID;
                        break;
                    }
                }

                Intent intent = new Intent(BusStation.this,BusWebView.class);
                intent.putExtra("number",busNum);
                intent.putExtra("id",id1);
                startActivity(intent);
            }
        });

        busStationParser.jsoupAsyncTask.execute();
        busNumParser = new BusNumParser(BusStation.numUp,mList);
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

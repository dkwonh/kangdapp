package kangwon.cs.kangdapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String[] navItems = {"공지사항", "대중교통", "캠퍼스 정보", "도서관" ,"학사정보", "주간 식단"};
    private RelativeLayout flContainer;
    private DrawerLayout dlDrawer;
    private RelativeLayout rContainer, noticeBtn, snsBtn, infoBtn, shuttleBtn, schedulBtn, readbusBtn, libBtn, menuBtn, campusBtn, btnContainer;
    private ActionBarDrawerToggle dtToggle;
    private ImageView img;
    ArrayAdapter<String> arrayAdapter;
    protected int index;
    BtnOnClickListener listener = new BtnOnClickListener();
    List<String> mGroupList;
    HashMap<String,List<String>> mChildList;
    ExpandableListView exList;
    DrawerEx dEx;
    private long now = System.currentTimeMillis();
    final Date date = new Date(now);
    final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
    final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exList = (ExpandableListView)findViewById(R.id.exlist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setSubtitle("Kangwon National University");
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list, navItems);

        mGroupList = new ArrayList<>();
        mChildList = new HashMap<>();

        dEx = new DrawerEx(mGroupList,mChildList);

        dEx.setChild();

        exList.setAdapter(new ExpandableAdapter(this, mGroupList, mChildList));

        exList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });

        // 차일드 클릭 했을 경우 이벤트
        exList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent;
                switch (groupPosition) {
                    case 0:
                        switch (childPosition){
                            case 0:
                                index = 0;
                                intent = new Intent(MainActivity.this, SchoolNotice.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 1:
                                index = 1;
                                intent = new Intent(MainActivity.this, SchoolNotice.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 2:
                                index = 2;
                                intent = new Intent(MainActivity.this, SchoolNotice.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 3:
                                index = 3;
                                intent = new Intent(MainActivity.this, SchoolNotice.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition){
                            case 0:
                                intent = new Intent(MainActivity.this, RealTimeBus.class);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 1:
                                intent = new Intent(MainActivity.this, SubWayMain.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(MainActivity.this, Shuttle.class);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                        }
                        break;
                    case 2:
                        switch (childPosition){
                            case 0:
                                intent = new Intent(MainActivity.this, LivingMenu.class);
                                intent.putExtra("set",1);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 1:
                                intent = new Intent(MainActivity.this, LivingMenu.class);
                                intent.putExtra("set",2);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(MainActivity.this, SchoolMeal.class);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 3:
                                intent = new Intent(MainActivity.this, BackrocMenu.class);
                                startActivity(intent);
                        }
                        break;

                    case 3:
                        switch (childPosition){
                            case 0:
                                index = 0;
                                intent = new Intent(MainActivity.this, Library.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                break;
                            case 1:
                                index = 1;
                                intent = new Intent(MainActivity.this, Library.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 2:
                                index = 2;
                                intent = new Intent(MainActivity.this, Library.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                break;
                        }
                        break;
                    case 4:
                        switch (childPosition){
                            case 0:
                                intent = new Intent(MainActivity.this, NumberList.class);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(MainActivity.this, Professor.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(MainActivity.this, MapList.class);
                                startActivity(intent);
                                break;
                            case 3:
                                intent = new Intent(MainActivity.this, KnuPlus.class);
                                startActivity(intent);
                                break;
                        }
                        break;
                    case 5:
                        switch (childPosition){
                            case 0:
                                index = Integer.parseInt(curMonthFormat.format(date)) - 2;
                                if(index == -1)
                                    index = 12;
                                intent = new Intent(MainActivity.this, SchoolCalendar.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 1:
                                intent = new Intent(MainActivity.this, Scholarship.class);
                                intent.putExtra("index", 0);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(MainActivity.this, SchoolAdministration.class);
                                intent.putExtra("index", 0);
                                startActivity(intent);
                                break;
                        }
                        default:
                            break;
                    }
                    return false;
                }
        });

        // 그룹이 닫힐 경우 이벤트
        exList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });

        // 그룹이 열릴 경우 이벤트
        exList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });

        btnContainer = (RelativeLayout)findViewById(R.id.btncontainer);
        rContainer = (RelativeLayout)findViewById(R.id.container);
        flContainer = (RelativeLayout)findViewById(R.id.fl_activity_main_container);

        //lvNavList.setOnItemClickListener(new DrawerItemClickListener());

        dlDrawer = (DrawerLayout)findViewById(R.id.dl_activity_main_drawer);

        noticeBtn = (RelativeLayout)findViewById(R.id.noticeBtn);
        snsBtn = (RelativeLayout)findViewById(R.id.snsBtn);
        infoBtn = (RelativeLayout)findViewById(R.id.infoBtn);
        shuttleBtn = (RelativeLayout)findViewById(R.id.shuttleBtn);
        schedulBtn = (RelativeLayout)findViewById(R.id.schedulBtn);
        readbusBtn = (RelativeLayout)findViewById(R.id.realbusBtn);
        libBtn = (RelativeLayout)findViewById(R.id.libBtn);
        menuBtn = (RelativeLayout)findViewById(R.id.menuBtn);
        campusBtn = (RelativeLayout)findViewById(R.id.campusBtn);

        noticeBtn.setOnClickListener(listener);
        snsBtn.setOnClickListener(listener);
        infoBtn.setOnClickListener(listener);
        shuttleBtn.setOnClickListener(listener);
        schedulBtn.setOnClickListener(listener);
        readbusBtn.setOnClickListener(listener);
        libBtn.setOnClickListener(listener);
        menuBtn.setOnClickListener(listener);
        campusBtn.setOnClickListener(listener);

        dtToggle = new ActionBarDrawerToggle(this, dlDrawer,
                R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerClosed(View drawerView){super.onDrawerClosed(drawerView);
                //selList.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onDrawerOpened(View drawerView){super.onDrawerOpened(drawerView);
            }
        };
        dlDrawer.setDrawerListener(dtToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_nohome,menu);
        return true;
    }

    private class BtnOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent;
            intent = new Intent(MainActivity.this,BigMenuList.class);
            switch(view.getId()){
                case R.id.noticeBtn:
                    Log.d("TAG"," "+view.getId());
                    //intent = new Intent(MainActivity.this,BigMenuList.class);
                    intent.putExtra("title","공지사항");
                    startActivity(intent);
                    break;
                case R.id.snsBtn:
                    //intent = new Intent(MainActivity.this,BigMenuList.class);
                    intent.putExtra("title","SNS");
                    startActivity(intent);
                    break;
                case R.id.infoBtn:
                    ///intent = new Intent(MainActivity.this,BigMenuList.class);
                    intent.putExtra("title","학사정보");
                    startActivity(intent);
                    break;
                case R.id.libBtn:
                    //intent = new Intent(MainActivity.this,BigMenuList.class);
                    intent.putExtra("title","도서관");
                    startActivity(intent);
                    break;
                case R.id.campusBtn:
                    //intent = new Intent(MainActivity.this,BigMenuList.class);
                    intent.putExtra("title","캠퍼스 정보");
                    startActivity(intent);
                    break;
                case R.id.shuttleBtn:
                    intent = new Intent(MainActivity.this,Shuttle.class);
                    startActivity(intent);
                    break;
                case R.id.realbusBtn:
                    intent = new Intent(MainActivity.this,RealTimeBus.class);
                    startActivity(intent);
                    break;
                case R.id.schedulBtn:
                    index = Integer.parseInt(curMonthFormat.format(date)) - 2;
                    if(index == -1)
                        index = 12;
                    intent = new Intent(MainActivity.this,SchoolCalendar.class);
                    intent.putExtra("index", index);
                    startActivity(intent);
                    break;
                case R.id.menuBtn:
                    //intent = new Intent(MainActivity.this,BigMenuList.class);
                    intent.putExtra("title","주간 식단");
                    startActivity(intent);
                    break;
            }
        }
    }


    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        dtToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        dtToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(dtToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        if(dlDrawer.isDrawerOpen(rContainer)){
            dlDrawer.closeDrawer(rContainer);
            //selList.setVisibility(View.INVISIBLE);
            //dlDrawer.closeDrawer(selList);
        }
        else{
            super.onBackPressed();
        }
    }
}

package kangwon.cs.kangdapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by WH on 2016-10-29.
 */
public class BigMenuList extends AppCompatActivity {
    ListView Big_list;
    BigListAdapter mAdapter = new BigListAdapter(this);
    ArrayList<BigListData> big_list_datas;
    private Intent intent;
    private DrawerLayout dlDrawer;
    private RelativeLayout rContainer, flContainer, btnContainer;
    private ActionBarDrawerToggle dtToggle;
    protected int index, ind;
    String title = "";
    BigListData data, big;
    List<String> mGroupList;
    HashMap<String,List<String>> mChildList;
    ExpandableListView exList;
    DrawerEx dEx;
    private long now = System.currentTimeMillis();
    final Date date = new Date(now);
    final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
    final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();
        title = intent.getStringExtra("title");
        setTitle(title);
        big_list_datas = new ArrayList<>();
        exList = (ExpandableListView)findViewById(R.id.exlist);
        mGroupList = new ArrayList<>();
        mChildList = new HashMap<>();

        dEx = new DrawerEx(mGroupList,mChildList);

        dEx.setChild();

        exList.setAdapter(new ExpandableAdapter(this, mGroupList, mChildList));

        exList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent;
                switch (groupPosition) {
                    case 0:
                        switch (childPosition){
                            case 0:
                                index = 0;
                                intent = new Intent(BigMenuList.this, SchoolNotice.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 1:
                                index = 1;
                                intent = new Intent(BigMenuList.this, SchoolNotice.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 2:
                                index = 2;
                                intent = new Intent(BigMenuList.this, SchoolNotice.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 3:
                                index = 3;
                                intent = new Intent(BigMenuList.this, SchoolNotice.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition){
                            case 0:
                                intent = new Intent(BigMenuList.this, RealTimeBus.class);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 1:
                                intent = new Intent(BigMenuList.this, SubWayMain.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(BigMenuList.this, Shuttle.class);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                        }
                        break;
                    case 2:
                        switch (childPosition){
                            case 0:
                                intent = new Intent(BigMenuList.this, LivingMenu.class);

                                intent.putExtra("set",1);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 1:
                                intent = new Intent(BigMenuList.this, LivingMenu.class);
                                intent.putExtra("set",2);

                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(BigMenuList.this, SchoolMeal.class);

                                startActivity(intent);
                                break;
                            case 3:
                                intent = new Intent(BigMenuList.this, BackrocMenu.class);

                                startActivity(intent);

                        }
                        break;
                    case 3:
                        switch (childPosition){
                            case 0:
                                ind = 0;
                                intent = new Intent(BigMenuList.this, Library.class);
                                intent.putExtra("index", ind);
                                startActivity(intent);
                                break;
                            case 1:
                                ind = 1;
                                intent = new Intent(BigMenuList.this, Library.class);
                                intent.putExtra("index", ind);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 2:
                                ind = 2;
                                intent = new Intent(BigMenuList.this, Library.class);
                                intent.putExtra("index", ind);
                                startActivity(intent);
                                break;
                        }
                        break;
                    case 4:
                        switch (childPosition){
                            case 0:
                                intent = new Intent(BigMenuList.this, NumberList.class);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(BigMenuList.this, Professor.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(BigMenuList.this, MapList.class);
                                startActivity(intent);
                                break;
                            case 3:
                                intent = new Intent(BigMenuList.this, KnuPlus.class);
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
                                intent = new Intent(BigMenuList.this, SchoolCalendar.class);
                                intent.putExtra("index", index);
                                startActivity(intent);
                                //dlDrawer.closeDrawer(rContainer);
                                break;
                            case 1:
                                intent = new Intent(BigMenuList.this, Scholarship.class);
                                intent.putExtra("index", 0);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(BigMenuList.this, SchoolAdministration.class);
                                intent.putExtra("index", 0);
                                startActivity(intent);
                                break;

                        }
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        switch(title) {
            case "공지사항":
                big_list_datas.add(new BigListData(R.drawable.notice1,"일반 공지","일반 공지사항 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.notice1,"학사 공지","학사 공지사항 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.notice1,"장학 공지","장학 공지사항 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.notice1,"행사 공지","행사 공지사항 입니다",R.drawable.ic_action_next_item));
                for(BigListData b : big_list_datas){
                    mAdapter.addItem(b.img,b.name,b.exp,b.arr);
                }
                break;
            case "도서관":
                big_list_datas.add(new BigListData(R.drawable.lib_notice,"도서관 공지","도서관 공지사항 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.lib_serch,"도서 검색","도서 검색 기능 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.lib_seat,"열람실 현황","현재 열람실 현황 입니다",R.drawable.ic_action_next_item));
                for(BigListData b : big_list_datas){
                    mAdapter.addItem(b.img,b.name,b.exp,b.arr);
                }
                break;
            case "캠퍼스 정보":
                big_list_datas.add(new BigListData(R.drawable.num,"연락처","주요 사무실 및 학과 사무실 연락처 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.pro,"교수진","각 학과별 교수진 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.map,"캠퍼스 맵","캠퍼스 지도 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.knuplus,"강대 플러스+","다양한 팁 입니다",R.drawable.ic_action_next_item));
                for(BigListData b : big_list_datas){
                    mAdapter.addItem(b.img,b.name,b.exp,b.arr);
                }
                break;
            case "학사정보":
                big_list_datas.add(new BigListData(R.drawable.schedule,"학사 일정","학사 일정 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.sc,"장학 제도","장학 제도 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.haksa1,"학사 행정 관련","학사 행정 관련 입니다",R.drawable.ic_action_next_item));
                for(BigListData b : big_list_datas){
                    mAdapter.addItem(b.img,b.name,b.exp,b.arr);
                }
                break;
            case "SNS":
                big_list_datas.add(new BigListData(R.drawable.sns_dcafe,"강대 라이크","다음 카페 강대라이크 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.sns_fbok,"강원대학교 대신 전해드립니다","강원대학교 대신 전해드립니다의 페이스북 페이지 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.sns_fbok,"총 학생회 페이스북","총 학생회 페이스북 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.sns_ch,"총 학생회 홈페이지", "총 학생회 홈페이지 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.sns_twt,"강원대학교 트위터","강원대학교 트위터 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.sns_dvelop,"개발자 정보", "어플 개발진 정보 입니다",R.drawable.ic_action_next_item));
                for(BigListData b : big_list_datas){
                    mAdapter.addItem(b.img,b.name,b.exp,b.arr);
                }
                break;
            case "주간 식단":
                big_list_datas.add(new BigListData(R.drawable.m_domi,"일반 기숙사 식단","일반 기숙사 식단표 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.btl,"BTL 기숙사 식단","BTL 기숙사 식단표 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.m,"천지관 식단","천지관 식단표 입니다",R.drawable.ic_action_next_item));
                big_list_datas.add(new BigListData(R.drawable.m,"백록관 식단","백록관 식단표 입니다",R.drawable.ic_action_next_item));
                for(BigListData b : big_list_datas){
                    mAdapter.addItem(b.img,b.name,b.exp,b.arr);
                }
                break;
            default:
                break;
        }
        Big_list = (ListView)findViewById(R.id.big_list);
        btnContainer = (RelativeLayout)findViewById(R.id.btncontainer);
        rContainer = (RelativeLayout)findViewById(R.id.container);
        flContainer = (RelativeLayout)findViewById(R.id.fl_activity_main_container);
        dlDrawer = (DrawerLayout)findViewById(R.id.navigation_header_container);
        Big_list.setAdapter(mAdapter);

        Big_list.setOnItemClickListener(new ListItemClickListener());

        dtToggle = new ActionBarDrawerToggle(this,
                dlDrawer,R.string.open_drawer, R.string.close_drawer){
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
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    private class ListItemClickListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id){
            data = big_list_datas.get(position);
            String s = data.name;
            Intent intent;
            switch (s) {
                case "셔틀버스 시간표":
                    intent = new Intent(BigMenuList.this, Shuttle.class);
                    startActivity(intent);
                    //dlDrawer.closeDrawer(rContainer);
                    break;
                case "강대 플러스+":
                    intent = new Intent(BigMenuList.this, KnuPlus.class);
                    startActivity(intent);
                    break;
                case "연락처":
                    intent = new Intent(BigMenuList.this, NumberList.class);
                    startActivity(intent);
                    break;
                case "일반 공지":
                    index = 0;
                    intent = new Intent(BigMenuList.this, SchoolNotice.class);
                    intent.putExtra("index",index);
                    startActivity(intent);
                    //dlDrawer.closeDrawer(rContainer);
                    break;
                case "총 학생회":
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.knuch.com/m/"));
                    startActivity(intent);
                    break;
                case "학사 공지":
                    index = 1;
                    intent = new Intent(BigMenuList.this, SchoolNotice.class);
                    intent.putExtra("index",index);
                    startActivity(intent);
                    //dlDrawer.closeDrawer(rContainer);
                    break;
                case "장학 공지":
                    index = 2;
                    intent = new Intent(BigMenuList.this, SchoolNotice.class);
                    intent.putExtra("index",index);
                    startActivity(intent);
                    //dlDrawer.closeDrawer(rContainer);
                    break;
                case "행사 공지":
                    index = 3;
                    intent = new Intent(BigMenuList.this, SchoolNotice.class);
                    intent.putExtra("index",index);
                    startActivity(intent);
                    //dlDrawer.closeDrawer(rContainer);
                    break;

                case "식당 메뉴":
                    intent = new Intent(BigMenuList.this, SchoolMeal.class);
                    startActivity(intent);
                    //dlDrawer.closeDrawer(rContainer);
                    break;

                case "교수진" :
                    intent = new Intent(BigMenuList.this, Professor.class);
                    startActivity(intent);
                    break;

                case "도서관 공지" :
                    ind = 0;
                    intent = new Intent(BigMenuList.this, Library.class);
                    intent.putExtra("index", ind);
                    startActivity(intent);
                    break;
                case "도서 검색":
                    ind = 1;
                    intent = new Intent(BigMenuList.this, Library.class);
                    intent.putExtra("index", ind);
                    startActivity(intent);
                    //dlDrawer.closeDrawer(rContainer);
                    break;
                case "열람실 현황":
                    ind = 2;
                    intent = new Intent(BigMenuList.this, Library.class);
                    intent.putExtra("index", ind);
                    startActivity(intent);
                    break;
                case "학사 일정" :
                    index = Integer.parseInt(curMonthFormat.format(date)) - 2;
                    if(index == -1)
                        index = 12;
                    intent = new Intent(BigMenuList.this, SchoolCalendar.class);
                    intent.putExtra("index", index);
                    startActivity(intent);
                    //dlDrawer.closeDrawer(rContainer);
                    break;
                case "장학 제도" :
                    intent = new Intent(BigMenuList.this, Scholarship.class);
                    intent.putExtra("index", 0);
                    startActivity(intent);
                    break;
                case "학사 행정 관련" :
                    intent = new Intent(BigMenuList.this, SchoolAdministration.class);
                    intent.putExtra("index", 0);
                    startActivity(intent);
                    break;
                case "실시간 버스정보" :
                    intent = new Intent(BigMenuList.this, RealTimeBus.class);
                    startActivity(intent);
                    //dlDrawer.closeDrawer(rContainer);
                    break;
                case "지하철 시간표" :
                    intent = new Intent(BigMenuList.this,SubWayMain.class);
                    startActivity(intent);
                    break;
                case "천지관 식단" :
                    intent = new Intent(BigMenuList.this,SchoolMeal.class);

                    startActivity(intent);
                    break;
                case "일반 기숙사 식단":
                    intent = new Intent(BigMenuList.this,LivingMenu.class);

                    intent.putExtra("set",1);
                    startActivity(intent);
                    break;
                case "BTL 기숙사 식단":
                    intent = new Intent(BigMenuList.this,LivingMenu.class);
                    intent.putExtra("set",2);

                    startActivity(intent);
                    break;
                case "백록관 식단" :
                    intent = new Intent(BigMenuList.this,BackrocMenu.class);

                    startActivity(intent);
                    break;
                case "캠퍼스 맵" :
                    intent = new Intent(BigMenuList.this, MapList.class);
                    startActivity(intent);
                    break;
                case "강대 라이크" :
                    intent = new Intent(Intent.ACTION_VIEW);
                    Uri u = Uri.parse("http://m.cafe.daum.net/kangwonlike");
                    intent.setData(u);
                    startActivity(intent);
                    break;
                case "강원대학교 대신 전해드립니다":
                    intent = new Intent(Intent.ACTION_VIEW);
                    Uri r = Uri.parse("https://m.facebook.com/knutalk2014/");
                    intent.setData(r);
                    startActivity(intent);
                    break;
                case "강원대학교 트위터":
                    intent = new Intent(Intent.ACTION_VIEW);
                    Uri i = Uri.parse("https://mobile.twitter.com/kangwondae");
                    intent.setData(i);
                    startActivity(intent);
                    break;
                case "총 학생회 페이스북":
                    intent = new Intent(Intent.ACTION_VIEW);
                    Uri f = Uri.parse("https://m.facebook.com/knuch49/");
                    intent.setData(f);
                    startActivity(intent);
                    break;
                case "총 학생회 홈페이지":
                    intent = new Intent(Intent.ACTION_VIEW);
                    Uri c = Uri.parse("http://m.knuch.com/");
                    intent.setData(c);
                    startActivity(intent);
                    break;
                case "개발자 정보":
                    intent = new Intent(BigMenuList.this, DevelopInfo.class);
                    startActivity(intent);
                    break;
                default:
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
        int id= item.getItemId();
        if(dtToggle.onOptionsItemSelected(item))
            return true;
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

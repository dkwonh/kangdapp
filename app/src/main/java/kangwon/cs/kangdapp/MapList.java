package kangwon.cs.kangdapp;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by KHJ on 2016-11-07.
 */

public class MapList extends AppCompatActivity {
    ListView mlist;
    EditText txt_search; //검색창
    LocationListAdapter madapter;
    ArrayList<String> mLocationItems;
    boolean a, b;
    public static String[] listspot = {"60주년 기념관", "IT대학(공과대학6호관)", "공과대학1호관",
            "공과대학5호관", "공과대학2호관", "공과대학4호관", "공과대학3호관", "실내체육관",
            "제127학군단", "제2학생회관(백록관)", "스포츠과학부", "한빛관(IT대학)", "보듬관(청정신기술)",
            "실사구시관", "제1학생회관(천지관)", "자연과학대학1호관", "자연과학대학2호관", "자연과학대학3호관",
            "자연과학대학4호관", "자연과학대학5호관", "사범대학4호관", "사범대학3호관", "사범대학1호관", "사범대학2호관",
            "국제어학원", "미래관", "강원대학교병원", "대학본부", "중앙박물관", "나래관(백령종합민원실)", "경영대학1호관",
            "경영대학2호관", "도서관", "농업생명과학대학1호관", "농업생명과학대학2호관", "농업생명과학대학3호관", "영상바이오관",
            "문화예술대학2호관", "문화예술대학1호관", "평생교육원", "제3학생회관(태백관)", "한울관(동아리회관)", "친환경농업연구센터",
            "환경연구소", "정보통신연구소(아산관)", "제2도서관(집현관)", "약학대학", "창강제지기술연구소", "산림환경과학대2호관",
            "산림환경과학대1호관", "의생명과학대학", "동물생명과학대학1호관", "동물생명과학대학2호관", "수의과대학",
            "동물병원(야생동물구조센터)", "의학2호관(의학전문대학원)", "의학1호관", "국제생활관", "국제인재양성관",
            "강대어린이집", "스크립스코리아항체연구원", "백령아트센터", "디지털미디어센터(서암관)", "법학전문대학원",
            "사회과학대학1호관", "학생생활관(율곡관)", "학생생활관(퇴계관)", "향토학사(다산관)", "향토학사(예지원)",
            "학생생활관(BTL)", "인문대학3호관", "인문대학2호관", "인문대학1호관", "석재복합신소재제품연구센터",
            "학생생활관(난지원)", "학생생활관(국지원)", "학생생활관(한서관)", "학생생활관(의암관)", "종합운동장",
            "법학도서관", "사회과학대학2호관", "사범대학부설고교", "연적지", "함인섭광장", "후문", "정문", "동문", "미래광장"};

    int permissionCheck(){
        int permissionCheck = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        b = ActivityCompat.shouldShowRequestPermissionRationale(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION);
        if(permissionCheck== PackageManager.PERMISSION_DENIED) {
            if (b) {
                Log.d("AccessLocation : ","NEED_PERMISSION");
                ActivityCompat.requestPermissions(
                        this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            } else {
                ActivityCompat.requestPermissions(
                        this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            }
        }

        return ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION);
    }

    int permissionCheck2(){
        int permissionCheck = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        a = ActivityCompat.shouldShowRequestPermissionRationale(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION);
        if(permissionCheck== PackageManager.PERMISSION_DENIED) {
            if (a) {
                Log.d("WRITEEXTERNALSTORAGE : ","NEED_PERMISSION");
                ActivityCompat.requestPermissions(
                        this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            } else {
                ActivityCompat.requestPermissions(
                        this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }

        return ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("캠퍼스 맵");
        setContentView(R.layout.map_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mLocationItems = new ArrayList<>(Arrays.asList(listspot)); //문자열을 리스트에 넣어줌
        mlist = (ListView) findViewById(R.id.mlist);
        txt_search = (EditText) findViewById(R.id.txt_search);
        setLocationAdaptor();
        //madapter = new ArrayAdapter<>(this, R.layout.list, listspot);
        //mlist.setAdapter(madapter);

        txt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                madapter.getFilter().filter(cs);
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) { }
            @Override
            public void afterTextChanged(Editable arg0) { }
        });

        AdapterView.OnItemClickListener mlistClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentView, View clickedView, int position, long id) {
                Intent intent;
                double latitude, longitude;
                if(permissionCheck()==PackageManager.PERMISSION_DENIED||permissionCheck2()==PackageManager.PERMISSION_DENIED)
                {
                    if(!b||!a) {
                        Toast.makeText(getApplication(), "캠퍼스 맵은 위치 권한이 필요합니다.\n권한을 설정해주세요.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        i.addCategory(Intent.CATEGORY_DEFAULT);
                        i.setData(Uri.parse("package:" + "kangwon.cs.kangdapp"));
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        startActivity(i);
                    }
                }
                else {
                    switch (((TextView)clickedView.findViewById(R.id.txt_location)).getText().toString()) {
                        case "60주년 기념관" :
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.86932;
                            longitude = 127.7414;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 0);
                            startActivity(intent);
                            break;
                        case "IT대학(공과대학6호관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.86777;
                            longitude = 127.73870;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 1);
                            startActivity(intent);
                            break;
                        case "공과대학1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.86818;
                            longitude = 127.73962;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 2);
                            startActivity(intent);
                            break;
                        case "공과대학5호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.86836;
                            longitude = 127.73883;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 3);
                            startActivity(intent);
                            break;
                        case "공과대학2호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.86872;
                            longitude = 127.739466;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 4);
                            startActivity(intent);
                            break;
                        case "공과대학4호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868957;
                            longitude = 127.738740;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 5);
                            startActivity(intent);
                            break;
                        case "공과대학3호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869294;
                            longitude = 127.739481;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 6);
                            startActivity(intent);
                            break;
                        case "실내체육관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870020;
                            longitude = 127.739638;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 7);
                            startActivity(intent);
                            break;
                        case "제127학군단":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869971;
                            longitude = 127.740553;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 8);
                            startActivity(intent);
                            break;
                        case "제2학생회관(백록관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868606;
                            longitude = 127.740805;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 9);
                            startActivity(intent);
                            break;
                        case "스포츠과학부":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869572;
                            longitude = 127.739721;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 10);
                            startActivity(intent);
                            break;
                        case "한빛관(IT대학)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868720;
                            longitude = 127.738010;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 11);
                            startActivity(intent);
                            break;
                        case "보듬관(청정신기술)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868992;
                            longitude = 127.738233;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 12);
                            startActivity(intent);
                            break;
                        case "실사구시관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.871646;
                            longitude = 127.743910;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 13);
                            startActivity(intent);
                            break;
                        case "제1학생회관(천지관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.871512;
                            longitude = 127.743448;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 14);
                            startActivity(intent);
                            break;
                        case "자연과학대학1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.871729;
                            longitude = 127.742718;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 15);
                            startActivity(intent);
                            break;
                        case "자연과학대학2호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.872389;
                            longitude = 127.743150;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 16);
                            startActivity(intent);
                            break;
                        case "자연과학대학3호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.872101;
                            longitude = 127.742473;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 17);
                            startActivity(intent);
                            break;
                        case "자연과학대학4호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.872452;
                            longitude = 127.742090;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 18);
                            startActivity(intent);
                            break;
                        case "자연과학대학5호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.872010;
                            longitude = 127.741903;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 19);
                            startActivity(intent);
                            break;
                        case "사범대학4호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.871582;
                            longitude = 127.741341;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 20);
                            startActivity(intent);
                            break;
                        case "사범대학3호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.871129;
                            longitude = 127.741947;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 21);
                            startActivity(intent);
                            break;
                        case "사범대학1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870509;
                            longitude = 127.741682;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 22);
                            startActivity(intent);
                            break;
                        case "사범대학2호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869732;
                            longitude = 127.741869;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 23);
                            startActivity(intent);
                            break;
                        case "국제어학원":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870205;
                            longitude = 127.742246;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 24);
                            startActivity(intent);
                            break;
                        case "미래관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870637;
                            longitude = 127.742459;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 25);
                            startActivity(intent);
                            break;
                        case "강원대학교병원":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.874850;
                            longitude = 127.744785;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 26);
                            startActivity(intent);
                            break;
                        case "대학본부":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869524;
                            longitude = 127.744755;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 27);
                            startActivity(intent);
                            break;
                        case "중앙박물관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869533;
                            longitude = 127.743992;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 28);
                            startActivity(intent);
                            break;
                        case "나래관(백령종합민원실)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869938;
                            longitude = 127.744695;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 29);
                            startActivity(intent);
                            break;
                        case "경영대학1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869827;
                            longitude = 127.745822;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 30);
                            startActivity(intent);
                            break;
                        case "경영대학2호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869986;
                            longitude = 127.746287;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 31);
                            startActivity(intent);
                            break;
                        case "도서관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870661;
                            longitude = 127.744783;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 32);
                            startActivity(intent);
                            break;
                        case "농업생명과학대학1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870426;
                            longitude = 127.745941;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 33);
                            startActivity(intent);
                            break;
                        case "농업생명과학대학2호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.871399;
                            longitude = 127.745507;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 34);
                            startActivity(intent);
                            break;
                        case "농업생명과학대학3호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.871319;
                            longitude = 127.746263;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 35);
                            startActivity(intent);
                            break;
                        case "영상바이오관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870805;
                            longitude = 127.746496;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 36);
                            startActivity(intent);
                            break;
                        case "문화예술대학2호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870032;
                            longitude = 127.746930;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 37);
                            startActivity(intent);
                            break;
                        case "문화예술대학1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869766;
                            longitude = 127.747628;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 38);
                            startActivity(intent);
                            break;
                        case "평생교육원":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869148;
                            longitude = 127.745975;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 39);
                            startActivity(intent);
                            break;
                        case "제3학생회관(태백관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868481;
                            longitude = 127.745686;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 40);
                            startActivity(intent);
                            break;
                        case "한울관(동아리회관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867900;
                            longitude = 127.745783;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 41);
                            startActivity(intent);
                            break;
                        case "친환경농업연구센터":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.871399;
                            longitude = 127.746961;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 42);
                            startActivity(intent);
                            break;
                        case "환경연구소":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869123;
                            longitude = 127.748385;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 43);
                            startActivity(intent);
                            break;
                        case "정보통신연구소(아산관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868783;
                            longitude = 127.747565;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 44);
                            startActivity(intent);
                            break;
                        case "제2도서관(집현관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868233;
                            longitude = 127.747458;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 45);
                            startActivity(intent);
                            break;
                        case "약학대학":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867977;
                            longitude = 127.748399;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 46);
                            startActivity(intent);
                            break;
                        case "창강제지기술연구소":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867747;
                            longitude = 127.747606;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 47);
                            startActivity(intent);
                            break;
                        case "산림환경과학대2호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867426;
                            longitude = 127.747727;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 48);
                            startActivity(intent);
                            break;
                        case "산림환경과학대1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.866855;
                            longitude = 127.747497;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 49);
                            startActivity(intent);
                            break;
                        case "의생명과학대학":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867358;
                            longitude = 127.749191;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 50);
                            startActivity(intent);
                            break;
                        case "동물생명과학대학1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868487;
                            longitude = 127.748980;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 51);
                            startActivity(intent);
                            break;
                        case "동물생명과학대학2호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868633;
                            longitude = 127.749820;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 52);
                            startActivity(intent);
                            break;
                        case "수의과대학":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868316;
                            longitude = 127.750787;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 53);
                            startActivity(intent);
                            break;
                        case "동물병원(야생동물구조센터)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868258;
                            longitude = 127.751186;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 54);
                            startActivity(intent);
                            break;
                        case "의학2호관(의학전문대학원)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868963;
                            longitude = 127.751041;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 55);
                            startActivity(intent);
                            break;
                        case "의학1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869216;
                            longitude = 127.751657;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 56);
                            startActivity(intent);
                            break;
                        case "국제생활관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870108;
                            longitude = 127.751625;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 57);
                            startActivity(intent);
                            break;
                        case "국제인재양성관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870151;
                            longitude = 127.751858;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 58);
                            startActivity(intent);
                            break;
                        case "강대어린이집":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.869928;
                            longitude = 127.751033;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 59);
                            startActivity(intent);
                            break;
                        case "스크립스코리아항체연구원":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867359;
                            longitude = 127.749219;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 60);
                            startActivity(intent);
                            break;
                        case "백령아트센터":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.866988;
                            longitude = 127.740094;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 61);
                            startActivity(intent);
                            break;
                        case "디지털미디어센터(서암관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.866604;
                            longitude = 127.739704;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 62);
                            startActivity(intent);
                            break;
                        case "법학전문대학원":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.866821;
                            longitude = 127.741292;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 63);
                            startActivity(intent);
                            break;
                        case "사회과학대학1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.866912;
                            longitude = 127.741308;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 64);
                            startActivity(intent);
                            break;
                        case "학생생활관(율곡관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.866331;
                            longitude = 127.740374;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 65);
                            startActivity(intent);
                            break;
                        case "학생생활관(퇴계관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.866385;
                            longitude = 127.742086;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 66);
                            startActivity(intent);
                            break;
                        case "향토학사(다산관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.865763;
                            longitude = 127.742364;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 67);
                            startActivity(intent);
                            break;
                        case "향토학사(예지원)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.865660;
                            longitude = 127.741992;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 68);
                            startActivity(intent);
                            break;
                        case "학생생활관(BTL)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.865129;
                            longitude = 127.741797;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 69);
                            startActivity(intent);
                            break;
                        case "인문대학3호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.865958;
                            longitude = 127.743646;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 70);
                            startActivity(intent);
                            break;
                        case "인문대학2호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867473;
                            longitude = 127.740715;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 71);
                            startActivity(intent);
                            break;
                        case "인문대학1호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867435;
                            longitude = 127.741127;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 72);
                            startActivity(intent);
                            break;
                        case "석재복합신소재제품연구센터":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867718;
                            longitude = 127.741320;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 73);
                            startActivity(intent);
                            break;
                        case "학생생활관(난지원)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867870;
                            longitude = 127.742055;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 74);
                            startActivity(intent);
                            break;
                        case "학생생활관(국지원)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867368;
                            longitude = 127.742629;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 75);
                            startActivity(intent);
                            break;
                        case "학생생활관(한서관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.867123;
                            longitude = 127.742918;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 76);
                            startActivity(intent);
                            break;
                        case "학생생활관(의암관)":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.873154;
                            longitude = 127.748241;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 77);
                            startActivity(intent);
                            break;
                        case "종합운동장":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.873035;
                            longitude = 127.747457;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 78);
                            startActivity(intent);
                            break;
                        case "법학도서관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868334;
                            longitude = 127.743203;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 79);
                            startActivity(intent);
                            break;
                        case "사회과학대학2호관":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.866954;
                            longitude = 127.741666;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 80);
                            startActivity(intent);
                            break;
                        case "사범대학부설고교":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.866052;
                            longitude = 127.739935;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 81);
                            startActivity(intent);
                            break;
                        case "연적지":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.872507;
                            longitude = 127.743054;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 82);
                            startActivity(intent);
                            break;
                        case "함인섭광장":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.868529;
                            longitude = 127.742471;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 83);
                            startActivity(intent);
                            break;
                        case "후문":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.872563;
                            longitude = 127.744759;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 84);
                            startActivity(intent);
                            break;
                        case "정문":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.866740;
                            longitude = 127.738363;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 85);
                            startActivity(intent);
                            break;
                        case "동문":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.865532;
                            longitude = 127.749620;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 86);
                            startActivity(intent);
                            break;
                        case "미래광장":
                            intent = new Intent(MapList.this, Map.class);
                            latitude = 37.870772;
                            longitude = 127.743509;
                            intent.putExtra("latitude", latitude);
                            intent.putExtra("longitude", longitude);
                            intent.putExtra("index", 87);
                            startActivity(intent);
                            break;

                        default:
                            break;
                    }
                }
            }
        };
        mlist.setOnItemClickListener(mlistClickListener);
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

    private class LocationPop extends AsyncTask<ArrayList<String>, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(ArrayList<String>... params) {
            mLocationItems.clear(); //리스트 초기화
            ArrayList<String> items = params[0];
            if (listspot.length > 0) {

                for (String current_item : items) {
                    mLocationItems.add(current_item); //리스트에 추가
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (!isCancelled()) {
                if (mLocationItems.size() <= 0) {
                    madapter.notifyDataSetChanged();
                } else {
                    setLocationAdaptor(); //어댑터 세팅
                }
            }
            super.onPostExecute(result);
        }
    }


    private void setLocationAdaptor() {
        madapter = new LocationListAdapter(this, mLocationItems);
        mlist.setAdapter(madapter);
    }


    public class LocationFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String constraintStr = constraint.toString();
            FilterResults result = new Filter.FilterResults();

            if (constraint != null && constraint.toString().length() > 0) {
                ArrayList<String> filterItems = new ArrayList<String>();

                synchronized (this) {
                    for (String item : listspot) {
                        if (item.contains(constraintStr)) { //문자열 포함되어있는지 검색
                            filterItems.add(item);
                        }
                    }
                    result.count = filterItems.size();
                    result.values = filterItems;
                }
            } else {
                synchronized (this) {
                    result.count = listspot.length;
                    result.values = new ArrayList<String>(Arrays.asList(listspot));
                }
            }
            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<String> filtered = (ArrayList<String>) results.values;
            new LocationPop().execute(filtered);
        }

    }
}

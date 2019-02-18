package kangwon.cs.kangdapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WH on 2016-10-29.
 */
public class DrawerEx extends AppCompatActivity {
    List<String> mGroupList;
    HashMap<String,List<String>> mChildList;
    public DrawerEx(List<String> g, HashMap<String,List<String>> c){
        this.mGroupList = g;
        this.mChildList = c;
    }


    public void setChild(){
        mGroupList.add("공지 사항");
        mGroupList.add("대중교통");
        mGroupList.add("주간 식단");
        mGroupList.add("도서관");
        mGroupList.add("캠퍼스 정보");
        mGroupList.add("학사 정보");

        List<String> mChildListContent = new ArrayList<>();
        mChildListContent.add("- 일반 공지");
        mChildListContent.add("- 학사 공지");
        mChildListContent.add("- 장학 공지");
        mChildListContent.add("- 행사 공지");
        mChildListContent.add(" ");

        List<String> mChildTraffic = new ArrayList<>();
        mChildTraffic.add("- 실시간 버스정보");
        mChildTraffic.add("- 지하철 시간표");
        mChildTraffic.add("- 셔틀 버스 정보");
        mChildTraffic.add(" ");

        List<String> weekMenu = new ArrayList<>();
        weekMenu.add("- 일반 기숙사 식단");
        weekMenu.add("- BTL 기숙사 식단");
        weekMenu.add("- 천지관 식단");
        weekMenu.add("- 백록관 식단");
        weekMenu.add(" ");

        List<String> mChildLib = new ArrayList<>();
        mChildLib.add("- 도서관 공지");
        mChildLib.add("- 도서 검색");
        mChildLib.add("- 열람실 현황");
        mChildLib.add(" ");

        List<String> mChildCampus = new ArrayList<>();
        mChildCampus.add("- 연락처");
        mChildCampus.add("- 교수진");
        mChildCampus.add("- 캠퍼스 맵");
        mChildCampus.add("- 강대 플러스+");
        mChildCampus.add(" ");

        List<String> mChildInfo = new ArrayList<>();
        mChildInfo.add("- 학사 일정");
        mChildInfo.add("- 장학 제도");
        mChildInfo.add("- 학사 행정 관련");
        mChildInfo.add(" ");

        mChildList.put(mGroupList.get(0),mChildListContent);
        mChildList.put(mGroupList.get(1),mChildTraffic);
        mChildList.put(mGroupList.get(2),weekMenu);
        mChildList.put(mGroupList.get(3),mChildLib);
        mChildList.put(mGroupList.get(4),mChildCampus);
        mChildList.put(mGroupList.get(5),mChildInfo);
    }


}

package kangwon.cs.kangdapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Sunmin on 2016-10-19.
 */
public class Professor extends AppCompatActivity {
    String [] major = {"경영회계학부","경제무역학부","관광경영학과","글로벌비즈니스학과",
            "도시건축학부 건축학전공(5년제)","도시건축학부 건축공학전공","토목공학과","자원에너지시스템공학과","자원에너지시스템공학과","나노응용공학과","생물공학과","시스템경영공학과","환경공학과","화학공학과","기계융합공학부",
            "농업자원경제학과","생물자원과학부","원예시스템공학부","지역건설공학과","환경융합학부","식품생명공학과",
            "동물응용과학부","동물자원과학부",
            "디자인학과","미술학과","음악학과","무용학과","영상문화학과","스토리텔링학과",
            "법학전공",
            "국어교육과","영어교육과","한문교육과","교육학과","윤리교육과","역사교육과","지리교육과","일반사회교육과","수학교육과","과학교육학부","가정교육과","체육교육과",
            "문화인류학과","부동산학과","사회학과","신문방송학과","심리학과","정치외교학과","행정학과",
            "산림과학부","산림응용공학부","생태조경디자인학과",
            "수의학과","수의예과","약학과","간호학과",
            "분자생명과학과","의생명융합학부","생물의소재공학과",
            "국어국문학과","영어영문학과","독어독문학과","불어불문학과","중어중문학과","사학과","철학과","일본학과",
            "물리학과","지질지구물리학부","생명과학과","생화학과","화학과","수학과","정보통계학과",
            "전기전자공학부","컴퓨터과학 전공","컴퓨터정보통신공학 전공",
            "스포츠과학전공","스포츠지도전공" };

    ListView plist;
    //ArrayAdapter<String> pAdapter;
    Intent intent;
    EditText txt_search; //검색창
    LocationListAdapter madapter;
    ArrayList<String> mLocationItems;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.majorlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txt_search = (EditText)findViewById(R.id.txt_search);
        setTitle("교수진");
        mLocationItems = new ArrayList<>(Arrays.asList(major));
        plist = (ListView)findViewById(R.id.m_list);
        setLocationAdaptor();

        txt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                madapter.getFilter_().filter(cs);
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) { }
            @Override
            public void afterTextChanged(Editable arg0) { }
        });

        plist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public  void onItemClick(AdapterView<?>parent, View view, int position, long id){
                switch (((TextView)view.findViewById(R.id.txt_location)).getText().toString()){
                    case "경영회계학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_01_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "경제무역학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_01_04_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "관광경영학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_01_03_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "글로벌비즈니스학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_01_06_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;

                    case "도시건축학부 건축공학전공(5년제)":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_02_03_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "도시건축학부 건축공학전공":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_02_04_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "토목공학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_02_07_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "자원에너지시스템공학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_02_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "나노응용공학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_02_08_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "생물공학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_02_11_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "시스템경영공학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_02_09_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "환경공학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_02_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "화학공학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_02_10_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "기계융합공학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_02_12_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "농업자원경제학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_03_07_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "생물자원과학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_03_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "원예시스템공학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_03_08_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "지역건설공학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_03_03_01.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "환경융합학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_03_09_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "식품생명공학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_17_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "동물응용과학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_04_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "동물자원과학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_04_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "디자인학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_05_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "미술학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_05_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "음악학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_05_03_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "무용학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_05_04_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "영상문화학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_05_05_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "스토리텔링학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_05_06_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "법학전공공":
                       intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_06_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "국어교육과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "영어교육과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "한문교육과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_03_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "교육학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_04_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "윤리교육과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_05_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "역사교육과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_06_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "지리교육과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_07_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "일반사회교육과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_08_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "수학교육과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_09_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "과학교육학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_10_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "가정교육과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_11_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "체육교육과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_07_12_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "문화인류학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_08_07_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "부동산학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_08_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "사회학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_08_06_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "신문방송학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_08_04_01.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "심리학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_08_05_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "정치외교학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_08_03_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "행정학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_08_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "산림과학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_09_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "산림응용공학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_09_05_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "생태조경디자인학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_09_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "수의학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_10_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "수의예과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_10_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "약학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_11_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "간호학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_12_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "분자생명과학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_13_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    /*case "의생명융합학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_12_01_02.jsp");
                        intent.putExtra("title",((TextView)view).getText().toString());
                        startActivity(intent);
                        break;*/
                    case "생물의소재공학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_17_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "국어국문학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_14_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "영어영문학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_14_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "독어독문학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_14_03_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "불어불문학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_14_04_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "중어중문학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_14_05_01.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "사학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_14_07_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "철학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_14_08_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "일본학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_14_06_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "물리학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_15_05_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "지질지구물리학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_15_07_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "생명과학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_15_04_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "생화학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_15_07_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "화학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_15_06_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "수학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_15_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "정보통계학과":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_15_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "전기전자공학부":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_16_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "컴퓨터정보통신공학 전공" :
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_16_03_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "컴퓨터과학 전공":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_16_04_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "스포츠과학전공":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_17_01_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    case "스포츠지도전공":
                        intent = new Intent(Professor.this, ProfessorList.class);
                        intent.putExtra("url","http://home.kangwon.ac.kr/main/html/knu/department_17_02_02.jsp");
                        intent.putExtra("title",((TextView)view.findViewById(R.id.txt_location)).getText().toString());
                        startActivity(intent);
                        break;
                    default:
                        break;
                }

            }
        });

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
            if (major.length > 0) {

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
        plist.setAdapter(madapter);
    }


    public class LocationFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String constraintStr = constraint.toString();
            FilterResults result = new Filter.FilterResults();

            if (constraint != null && constraint.toString().length() > 0) {
                ArrayList<String> filterItems = new ArrayList<String>();

                synchronized (this) {
                    for (String item : major) {
                        if (item.contains(constraintStr)) { //문자열 포함되어있는지 검색
                            filterItems.add(item);
                        }
                    }
                    result.count = filterItems.size();
                    result.values = filterItems;
                }
            } else {
                synchronized (this) {
                    result.count = major.length;
                    result.values = new ArrayList<String>(Arrays.asList(major));
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



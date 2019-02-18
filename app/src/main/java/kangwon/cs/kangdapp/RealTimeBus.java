package kangwon.cs.kangdapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by WH on 2016-09-13.
 */
public class RealTimeBus extends AppCompatActivity {

    String[] station = {" 과학관 입구(1996,강원대 후문 방향)"," 과학관 입구(1997, 팔호광장 방향)", " 강원대 후문(1480,사대부고 방향)"," 강원대 후문(1481,팔호광장 방향)", " 남춘천 역(2285,김유정 방향)"," 남춘천 역(2295,KBS 방향)", " 시외버스 터미널(2057,남춘천역 방향)", " 시외버스 터미널(2058,이마트 방향)"};
    ListView listView;
    String busID_up;
    String num_Up;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.real_bus);

        setTitle("실시간 버스정보");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listView = (ListView)findViewById(R.id.station);

        listView.setAdapter(new ArrayAdapter<>(this,R.layout.items,station));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (((TextView)view).getText().toString()) {
                    case " 과학관 입구(1996,강원대 후문 방향)":
                        intent = new Intent(RealTimeBus.this, BusStation.class);
                        busID_up = "http://www.chbis.kr/stationInfo.do?prmOperation=getStationInfo&prmStationName=%B0%FA%C7%D0%B0%FC%C0%D4%B1%B8&prmStationID=250001677";
                        num_Up = "http://www.chbis.kr/m_stationInfo.do?prmOperation=getMStationInfo&prmStationID=250001677&prmStationName=%B0%FA%C7%D0%B0%FC%C0%D4%B1%B8&prmCoordX=127.74135&prmCoordY=37.87404";
                        intent.putExtra("busUP",busID_up);
                        intent.putExtra("numUP",num_Up);
                        intent.putExtra("busTitle","과학관 입구(1996)");
                        startActivity(intent);
                        //dlDrawer.closeDrawer(rContainer);
                        break;
                    case " 과학관 입구(1997, 팔호광장 방향)":
                        intent = new Intent(RealTimeBus.this, BusStation.class);
                        busID_up = "http://www.chbis.kr/stationInfo.do?prmOperation=getStationInfo&prmStationName=%B0%FA%C7%D0%B0%FC%C0%D4%B1%B8&prmStationID=250001678";
                        num_Up = "http://www.chbis.kr/m_stationInfo.do?prmOperation=getMStationInfo&prmStationID=250001678&prmStationName=%B0%FA%C7%D0%B0%FC%C0%D4%B1%B8&prmCoordX=127.74098&prmCoordY=37.87437";
                        intent.putExtra("busUP",busID_up);
                        intent.putExtra("numUP",num_Up);
                        intent.putExtra("busTitle","과학관 입구(1997)");
                        startActivity(intent);
                        //dlDrawer.closeDrawer(rContainer);
                        break;
                    case " 강원대 후문(1481,팔호광장 방향)":
                        intent = new Intent(RealTimeBus.this, BusStation.class);
                        busID_up = "http://www.chbis.kr/stationInfo.do?prmOperation=getStationInfo&prmStationName=%B0%AD%BF%F8%B4%EB%C8%C4%B9%AE&prmStationID=250001748";
                        num_Up = "http://www.chbis.kr/m_stationInfo.do?prmOperation=getMStationInfo&prmStationID=250001748&prmStationName=%B0%AD%BF%F8%B4%EB%C8%C4%B9%AE&prmCoordX=127.74425&prmCoordY=37.87289";
                        intent.putExtra("busUP",busID_up);
                        intent.putExtra("numUP",num_Up);
                        intent.putExtra("busTitle","강원대 후문(1481)");
                        startActivity(intent);
                        break;
                    case " 강원대 후문(1480,사대부고 방향)":
                        intent = new Intent(RealTimeBus.this, BusStation.class);
                        busID_up = "http://www.chbis.kr/stationInfo.do?prmOperation=getStationInfo&prmStationName=%B0%AD%BF%F8%B4%EB%C8%C4%B9%AE&prmStationID=250001747";
                        num_Up = "http://www.chbis.kr/m_stationInfo.do?prmOperation=getMStationInfo&prmStationID=250001747&prmStationName=%B0%AD%BF%F8%B4%EB%C8%C4%B9%AE&prmCoordX=127.74417&prmCoordY=37.87276";
                        intent.putExtra("busUP",busID_up);
                        intent.putExtra("numUP",num_Up);
                        intent.putExtra("busTitle","강원대 후문(1480)");
                        startActivity(intent);
                        break;
                    case " 남춘천 역(2295,KBS 방향)":
                        intent = new Intent(RealTimeBus.this, BusStation.class);
                        busID_up = "http://www.chbis.kr/stationInfo.do?prmOperation=getStationInfo&prmStationName=%B3%B2%C3%E1%C3%B5%BF%AA&prmStationID=250026559";
                        num_Up = "http://www.chbis.kr/m_stationInfo.do?prmOperation=getMStationInfo&prmStationID=250026559&prmStationName=%B3%B2%C3%E1%C3%B5%BF%AA&prmCoordX=127.72331&prmCoordY=37.86412";
                        intent.putExtra("busUP",busID_up);
                        intent.putExtra("numUP",num_Up);
                        intent.putExtra("busTitle","남춘천 역(2295)");
                        startActivity(intent);
                        break;
                    case " 남춘천 역(2285,김유정 방향)":
                        intent = new Intent(RealTimeBus.this, BusStation.class);
                        busID_up = "http://www.chbis.kr/stationInfo.do?prmOperation=getStationInfo&prmStationName=%B3%B2%C3%E1%C3%B5%BF%AA&prmStationID=250026549";
                        num_Up = "http://www.chbis.kr/m_stationInfo.do?prmOperation=getMStationInfo&prmStationID=250026549&prmStationName=%B3%B2%C3%E1%C3%B5%BF%AA&prmCoordX=127.7231&prmCoordY=37.8639";
                        intent.putExtra("busUP",busID_up);
                        intent.putExtra("numUP",num_Up);
                        intent.putExtra("busTitle","남춘천 역(2285)");
                        startActivity(intent);
                        break;
                    case " 시외버스 터미널(2057,남춘천역 방향)":
                        intent = new Intent(RealTimeBus.this, BusStation.class);
                        busID_up = "http://www.chbis.kr/stationInfo.do?prmOperation=getStationInfo&prmStationName=%BD%C3%BF%DC%B9%F6%BD%BA%C5%CD%B9%CC%B3%CE&prmStationID=250002080";
                        num_Up = "http://www.chbis.kr/m_stationInfo.do?prmOperation=getMStationInfo&prmStationID=250002080&prmStationName=%BD%C3%BF%DC%B9%F6%BD%BA%C5%CD%B9%CC%B3%CE&prmCoordX=127.71993&prmCoordY=37.86377";
                        intent.putExtra("busUP",busID_up);
                        intent.putExtra("numUP",num_Up);
                        intent.putExtra("busTitle","시외버스 터미널(2057)");
                        startActivity(intent);
                        break;
                    case " 시외버스 터미널(2058,이마트 방향)":
                        intent = new Intent(RealTimeBus.this, BusStation.class);
                        busID_up = "http://www.chbis.kr/stationInfo.do?prmOperation=getStationInfo&prmStationName=%BD%C3%BF%DC%B9%F6%BD%BA%C5%CD%B9%CC%B3%CE&prmStationID=250002081";
                        num_Up = "http://www.chbis.kr/m_stationInfo.do?prmOperation=getMStationInfo&prmStationID=250002081&prmStationName=%BD%C3%BF%DC%B9%F6%BD%BA%C5%CD%B9%CC%B3%CE&prmCoordX=127.71976&prmCoordY=37.86411";
                        intent.putExtra("busUP",busID_up);
                        intent.putExtra("numUP",num_Up);
                        intent.putExtra("busTitle","시외버스 터미널(2058)");
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

}

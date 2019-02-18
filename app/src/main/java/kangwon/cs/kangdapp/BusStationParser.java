package kangwon.cs.kangdapp;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WH on 2016-09-13.
 */
public class BusStationParser {
    private final String TAG = "TAG";
    protected ArrayList<BusData> mList = new ArrayList<>();
    protected ArrayList<BusData> list = new ArrayList<>();
    JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
    protected HashMap<String,BusData> allBusList, tempBusList;
    private BusAdapter nAdapter;
    private BusAdapter mAdapter;
    String htmlurl = "http://www.chbis.kr/stationInfo.do?prmOperation=getStationInfo&prmStationName=%B0%FA%C7%D0%B0%FC%C0%D4%B1%B8&prmStationID=250001678";
    BusStationParser(BusAdapter adapter, BusAdapter adapter2, String url){
        this.nAdapter = adapter;
        this.mAdapter = adapter2;
        this.htmlurl = url;
        allBusList = new HashMap<>();
        tempBusList = new HashMap<>();
    }


    protected class JsoupAsyncTask extends AsyncTask<Void, Void, Void>{
        String busNum;
        String waitTime;
        String currentPosition;
        String remainPostion;

        String num;
        String first;
        String last;
        String vector;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            BusStation.progressBar.bringToFront();
            BusStation.progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                Elements links = doc.select("html body table tbody tr td.popup_center_01 table tbody tr td div.popup_table_scroll_02 table tbody tr");
                for (Element link : links) {
                    if(link.getAllElements().get(1).text().equals("")) {
                        continue;
                    }
                    if(link.getAllElements().get(1).text().equals("정보가 없습니다.")) {
                        Log.d("TAGGGGG","No Bus");
                        break;
                    }
                    busNum = link.getAllElements().get(1).text();
                    waitTime = link.getAllElements().get(3).text();
                    currentPosition = link.getAllElements().get(5).text();
                    remainPostion = link.getAllElements().get(7).text();
                    Log.d("TAG",busNum);

                    mList.add(new BusData(busNum, waitTime,"현재 위치 : "+ currentPosition,remainPostion));

                }
                for(Element link : links){
                    try{
                    if(link.getAllElements().get(4)==null || link.getAllElements().get(1).text().equals("정보가 없습니다.") || link.getAllElements().get(1).attr("width").toString().equals("90")) {
                        continue;
                    }
                        num = link.getAllElements().get(4).text();
                        first = link.getAllElements().get(8).text();
                        last = link.getAllElements().get(10).text();
                        vector = link.getAllElements().get(12).text();
                    }catch (Exception e){
                        continue;
                    }
                    list.add(new BusData(num, first, "", vector));


                }
            } catch (IOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            for(BusData s : list){
                allBusList.put(s.number,s);
            }
            for(BusData s : mList){
                allBusList.put(s.number,s);
            }
            for(String s : allBusList.keySet()){
                if(allBusList.get(s).currentPosition.equals("")) {
                    tempBusList.put(s,allBusList.get(s));
                    //mAdapter.addItem(allBusList.get(s).number,allBusList.get(s).remainPosition,allBusList.get(s).currentPosition,allBusList.get(s).waitTime,"");
                }
                else {
                    nAdapter.addItem(allBusList.get(s).number, allBusList.get(s).waitTime, allBusList.get(s).currentPosition, allBusList.get(s).remainPosition);
                }
            }
            for(String s : tempBusList.keySet()){
                nAdapter.addItem(tempBusList.get(s).number,tempBusList.get(s).remainPosition,tempBusList.get(s).currentPosition,tempBusList.get(s).waitTime,"");
            }
            BusStation.progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
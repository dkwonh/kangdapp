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

/**
 * Created by WH on 2016-10-11.
 */
public class BusNumParser{
    String htmlurl;
    ArrayList<NumData> mList;
    NumAsyncTask numAsyncTask = new NumAsyncTask();
    public BusNumParser(String url, ArrayList num){
        this.htmlurl=url;
        this.mList = num;
        numAsyncTask.execute();
    }


    protected class NumAsyncTask extends AsyncTask<Void, Void, Void> {
        String busNum;
        String busID;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                Elements links = doc.select("html a.mb_link_bus1");
                for (Element link : links) {
                    busID = link.toString().substring(30,39);
                    busNum = link.text();
                    mList.add(new NumData(busNum,busID));
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
        }
    }
}

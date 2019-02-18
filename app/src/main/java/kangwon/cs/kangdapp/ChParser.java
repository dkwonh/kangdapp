package kangwon.cs.kangdapp;

/**
 * Created by WH on 2016-10-20.
 */

import android.os.AsyncTask;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ChParser{
    private final String TAG = "TAG";
    protected ArrayList<ListData> mList = new ArrayList<>();
    protected  ArrayList<ListData> newList = new ArrayList<>();
    protected static String page;
    JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
    int index = 1;
    int getInt = 0;
    protected NoticeAdapter nAdapter;
    protected NoticeAdapter sAdapter;
    protected static String search="";
    public ChParser(int index, NoticeAdapter adapter, String page){
        this.getInt = index;
        this.nAdapter = adapter;
        this.sAdapter = adapter;
    }

    protected class NewAsyncTask extends AsyncTask<Void, Void, Void> {
        String nText;
        String nDate;
        String nUrl;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            SchoolNotice.mProgress.setVisibility(View.VISIBLE);
        }
        @Override
        protected Void doInBackground(Void...params){
            try{
                String htmlurl = "http://www.knuch.com/bbs/board.php?bo_table=board1&stx="+search+"&sop=and&page=" + index;
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                Elements links = doc.select("tbody tr td form table.board_list tbody tr[onmouseover]");
                for (Element link : links) {
                    if(link.getAllElements().get(1).text().equals("게시물이 없습니다."))
                        break;
                    if(link.getAllElements().get(2).hasAttr("img")){
                        continue;
                    }
                    Element text = link.getAllElements().get(4);
                    Element date = link.getAllElements().get(8);
                    nUrl = link.getAllElements().get(4).attr("abs:href");

                    nDate = date.text();
                    nText = text.text();
                    if(link.getAllElements().get(6).hasAttr("img"))
                        nDate = link.getAllElements().get(9).text();
                    mList.add(new ListData(nText,nDate,nUrl));
                }

            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            for(ListData s : mList){
                nAdapter.addItem(s.text, s.date );
                newList.add(s);
            }
            SchoolNotice.mProgress.setVisibility(View.INVISIBLE);
        }

    }


    protected class JsoupAsyncTask extends AsyncTask<Void, Void, Void>{
        String mtext;
        String mdate;
        String mURL;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            SchoolNotice.mProgress.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                String htmlurl = "http://www.knuch.com/bbs/board.php?bo_table=board1&sop=and&page=" + index;
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                Elements links = doc.select("tbody tr td form table.board_list tbody tr[onmouseover]");
                Log.d("TAG",doc.toString());
                for (Element link : links) {
                    if(link.getAllElements().get(1).text().equals("게시물이 없습니다."))
                        break;
                    Element text = link.getAllElements().get(4);
                    Element date = link.getAllElements().get(8);
                    mURL = link.getAllElements().get(4).attr("abs:href");
                    if(link.getAllElements().get(2).hasAttr("img")) {
                        text = link.getAllElements().get(6);
                        date = link.getAllElements().get(11);
                        mURL = link.getAllElements().get(5).attr("abs:href");
                    }
                    if(link.getAllElements().get(8).hasClass("name"))
                        date = link.getAllElements().get(10);
                    mdate = date.text();
                    mtext = text.text();
                    if(link.getAllElements().get(6).hasAttr("img"))
                        mdate = link.getAllElements().get(9).text();
                    mList.add(new ListData(mtext,mdate,mURL));
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            for(ListData s : mList){
                nAdapter.addItem(s.text, s.date);
                newList.add(s);
            }
            SchoolNotice.mProgress.setVisibility(View.INVISIBLE);
        }
    }

    protected class SearchAsyncTask extends AsyncTask<Void, Void, Void>{
        String mtext;
        String mdate;
        String mURL;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            SchoolNotice.mProgress.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                String htmlurl = "http://www.knuch.com/bbs/board.php?bo_table=board1&stx="+search+"&sop=and&page=" + index;
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                Elements links = doc.select("tbody tr td form table.board_list tbody tr[onmouseover]");
                for (Element link : links) {
                    if(link.getAllElements().get(1).text().equals("게시물이 없습니다."))
                        break;
                    Element text = link.getAllElements().get(4);
                    mURL = link.getAllElements().get(4).attr("abs:href");
                    mdate = link.getElementsByClass("datetime").text();
                    mtext = text.text();
                    mList.add(new ListData(mtext,mdate,mURL));
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            for(ListData s : mList){
                sAdapter.addItem(s.text, s.date);
                newList.add(s);
            }
            SchoolNotice.mProgress.setVisibility(View.INVISIBLE);
        }
    }

    public synchronized void luncher(int index){
        this.index = index;
        NewAsyncTask jTask = new NewAsyncTask();
        jTask.execute();
    }

    public synchronized void runSearch(int index, String page){
        this.page = page;
        this.index = index;
        SearchAsyncTask sTask = new SearchAsyncTask();
        newList.clear();
        mList.clear();
        nAdapter.clear();
        sTask.execute();
    }
}

package kangwon.cs.kangdapp;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by WH on 2016-09-07.
 */
public class NoticeParser{
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
        public NoticeParser(int index, NoticeAdapter adapter, String page){
            this.getInt = index;
            this.nAdapter = adapter;
            this.sAdapter = adapter;
            this.page = page;
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
                    String htmlurl = "http://home.kangwon.ac.kr/kangwon/boardUser/bbs_list.jsp?mbsId=" + page + "&column=1&search="+search+"&category=100&cng_listRow=&in_category=100&curr_page=" + index;
                    Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                    Elements links = doc.select("html body form table[summary*=일반 게시판] > tbody > tr");

                    for (Element link : links) {
                        if(link.getAllElements().get(1).text().equals("1"))
                            break;
                        if(link.getAllElements().get(1).text().equals("게시물이 없습니다."))
                            break;
                        Element text = link.getAllElements().get(4);
                        Element date = link.getAllElements().get(8);
                        nUrl = link.getAllElements().get(4).attr("abs:href");
                        if(link.getAllElements().get(2).attr("alt").toString().equals("공지")) {
                            continue;
                        }
                        if(link.getAllElements().get(1).attr("colspan").toString().equals("15"))
                            continue;
                        nDate = date.text();
                        nText = text.text();
                        if(link.getAllElements().get(5).attr("alt").toString().equals("NEW"))
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
                    String htmlurl = "http://home.kangwon.ac.kr/kangwon/boardUser/bbs_list.jsp?mbsId=" + page + "&column=1&search=&category=100&cng_listRow=&in_category=100&curr_page=" + index;
                    Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                    Elements links = doc.select("html body form table[summary*=일반 게시판] > tbody > tr");
                    for (Element link : links) {
                        if(link.getAllElements().get(1).text().equals("게시물이 없습니다."))
                            break;
                        Element text = link.getAllElements().get(4);
                        Element date = link.getAllElements().get(8);
                        mURL = link.getAllElements().get(4).attr("abs:href");
                        if(link.getAllElements().get(2).attr("alt").toString().equals("공지")) {
                            text = link.getAllElements().get(5);
                            date = link.getAllElements().get(9);
                            mURL = link.getAllElements().get(5).attr("abs:href");
                        }
                        if(link.getAllElements().get(1).attr("colspan").toString().equals("15"))
                            continue;
                        mdate = date.text();
                        mtext = text.text();
                        if(link.getAllElements().get(5).attr("alt").toString().equals("NEW"))
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
                String htmlurl = "http://home.kangwon.ac.kr/kangwon/boardUser/bbs_list.jsp?mbsId=" + page + "&column=1&search=" + search + "&category=100&cng_listRow=&in_category=100&curr_page=" + index;
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                Elements links = doc.select("html body form table[summary*=일반 게시판] > tbody > tr");
                for (Element link : links) {
                    if(link.getAllElements().get(1).text().equals("게시물이 없습니다."))
                        break;
                    Element text = link.getAllElements().get(4);
                    Element date = link.getAllElements().get(8);
                    mURL = link.getAllElements().get(4).attr("abs:href");
                    if(link.getAllElements().get(2).attr("alt").toString().equals("공지")) {
                        text = link.getAllElements().get(5);
                        date = link.getAllElements().get(9);
                        mURL = link.getAllElements().get(5).attr("abs:href");
                    }
                    if(link.getAllElements().get(1).attr("colspan").toString().equals("15"))
                        continue;
                    mdate = date.text();
                    mtext = text.text();
                    if(link.getAllElements().get(5).attr("alt").toString().equals("NEW"))
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

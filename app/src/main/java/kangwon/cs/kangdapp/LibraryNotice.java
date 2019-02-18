package kangwon.cs.kangdapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by KHJ on 2016-09-10.
 */
public class LibraryNotice extends Fragment {
    int index = 1;
    protected ListView LibraryList;
    protected ArrayList<ListData> List;
    protected ArrayList<ListData> newList;
    private EditText editText;
    private Button button;
    String keward = "";
    NoticeAdapter Ladapter;
    protected ProgressBar progressBar;
    String TAG = "TAG";
    String htmlUrl;
    JsoupAsyncTask jsoupAsyncTask;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.library_notice, container, false);
        Ladapter = new NoticeAdapter(v.getContext());
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar13);
        editText = (EditText)v.findViewById(R.id.editText2);
        button = (Button)v.findViewById(R.id.button);
        LibraryList = (ListView)v.findViewById(R.id.lib_list);
        List = new ArrayList<>();
        newList = new ArrayList<>();
        LibraryList.setAdapter(Ladapter);
        LibraryList.setOnScrollListener(new ScrollListener());
        jsoupAsyncTask = new JsoupAsyncTask();
        jsoupAsyncTask.execute();

        LibraryList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                ListData mData = newList.get(position);
                String selURL = mData.URL;
                String selTile = mData.text;
                Intent intent = new Intent(getActivity(), libWebview.class);
                intent.putExtra("url",selURL);
                intent.putExtra("title",selTile);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keward = editText.getText().toString();
                runSearch(1);
            }
        });
        return v;
    }

    boolean lastitemVisibleFlag = false;

    public class ScrollListener implements AbsListView.OnScrollListener{
        @Override
        public void onScroll(AbsListView view, int firstItem, int itemCount, int totalCount){
            lastitemVisibleFlag = (totalCount>0)&&(firstItem + itemCount >=totalCount);
        }

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState){
            if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && lastitemVisibleFlag){
                index++;
                //Log.d(TAG,String.valueOf(index));
                NewAsyncTask jTask = new NewAsyncTask();
                List.clear();
                jTask.execute();
            }
        }
    }

    protected class NewAsyncTask extends AsyncTask<Void, Void, Void> {
        String ntext, tmp, nURL, ndate;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected Void doInBackground(Void...params){
            try{
                String htmlurl = "https://library.kangwon.ac.kr:8443/board/list.jsp?pg=" + index + "&bcs=1&condition=title&keyword=" + keward + "&re=1";
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                //Log.d(TAG,"doc size : " + doc);
                Elements links = doc.select("body > div.wrap > div#container > div.content_wrap > div.content > div.content_inner > div#substance > div#contents1 > div > div#contents > div.thirdContents > div.boardArea > table > tbody > tr");
                //Elements links2 = doc.select("body div#mainContent > div#contents > div#wrapper2 > form > div.advance > div.advance_bibliography");
                //a[href*=http://home.kangwon.ac.kr/kangwon/boardUser/boardView.jsp?mbsId=7&boardSeq]
                //Log.d(TAG,"elements size : " + links.size());
                for (Element link : links) {
                    if(link.getAllElements().get(1).text().equals("번호"))
                        continue;
                    tmp = link.getAllElements().attr("href").toString().substring(19, 25);
                    nURL = "https://library.kangwon.ac.kr:8443/board/view.jsp?bcs=1&mode=m&bcs=1&seq=" + tmp;
                    ntext = link.getElementsByClass("title").text();
                    ndate = link.getAllElements().get(5).text();

                    if(link.getAllElements().get(2).attr("alt").toString().equals("공지"))
                        continue;

                    List.add(new ListData(ntext, ndate, nURL));
                }

            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            try {
                for(ListData s : List){
                    Ladapter.addItem(s.text, s.date );
                    newList.add(s);
                }
            } catch(IndexOutOfBoundsException e) {

            }
            progressBar.setVisibility(View.INVISIBLE);
        }

    }

    protected class JsoupAsyncTask extends AsyncTask<Void, Void, Void>{
        String mtext, tmp, mURL, mdate;
        String string = "";
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                String htmlurl = "https://library.kangwon.ac.kr:8443/board/list.jsp?pg=1&bcs=1";
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                //Log.d(TAG,"doc size : " + doc);
                Elements links = doc.select("body > div.wrap > div#container > div.content_wrap > div.content > div.content_inner > div#substance > div#contents1 > div > div#contents > div.thirdContents > div.boardArea > table > tbody > tr");
                //Elements links2 = doc.select("body div#mainContent > div#contents > div#wrapper2 > form > div.advance > div.advance_bibliography");
                for (Element link : links) {
                    if(link.getAllElements().get(1).text().equals("번호"))
                        continue;
                    tmp = link.getAllElements().attr("href").toString().substring(19, 25);
                    mURL = "https://library.kangwon.ac.kr:8443/board/view.jsp?bcs=1&mode=m&bcs=1&seq=" + tmp;
                    mtext = link.getElementsByClass("title").text();
                    mdate = link.getAllElements().get(5).text();
                    if(link.getAllElements().get(2).attr("alt").toString().equals("공지")) {
                        //Log.d(TAG,link.getAllElements().get(2).attr("alt").toString());
                        mtext = link.getElementsByClass("title").text();
                        mdate = link.getAllElements().get(6).text();
                        tmp = link.getAllElements().attr("href").toString().substring(19, 25);
                        mURL = "https://library.kangwon.ac.kr:8443/board/view.jsp?bcs=1&mode=m&bcs=1&seq=" + tmp;
                        // Log.d(TAG,text.text());
                    }
                    List.add(new ListData(mtext, mdate, mURL));
                    //string += link.toString();
                    //Log.d(TAG,"text : " + mtext);
                    //Log.d(TAG,"URL : " + mURL);
                    //Log.d(TAG,"date : " + mdate);
                }

            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            try {
                for(ListData s : List){
                    Ladapter.addItem(s.text, s.date );
                    newList.add(s);
                }
            } catch(IndexOutOfBoundsException e) {

            }

            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    protected class SearchAsyncTask extends AsyncTask<Void, Void, Void>{
        String mtext, tmp, mURL, mdate;
        String string = "";
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                String htmlurl = "https://library.kangwon.ac.kr:8443/board/list.jsp?pg=" + index + "&bcs=1&condition=title&keyword=" + keward + "&re=1";
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                Elements links = doc.select("body > div.wrap > div#container > div.content_wrap > div.content > div.content_inner > div#substance > div#contents1 > div > div#contents > div.thirdContents > div.boardArea > table > tbody > tr");
                for (Element link : links) {
                    if(link.getAllElements().get(1).text().equals("등록된 데이터가 없습니다."))
                        break;
                    if(link.getAllElements().get(1).text().equals("번호"))
                        continue;
                    tmp = link.getAllElements().attr("href").toString().substring(19, 25);
                    mURL = "https://library.kangwon.ac.kr:8443/board/view.jsp?bcs=1&mode=m&bcs=1&seq=" + tmp;
                    mtext = link.getElementsByClass("title").text();
                    mdate = link.getAllElements().get(5).text();
                    if(link.getAllElements().get(2).attr("alt").toString().equals("공지")) {
                        //Log.d(TAG,link.getAllElements().get(2).attr("alt").toString());
                        mtext = link.getElementsByClass("title").text();
                        mdate = link.getAllElements().get(6).text();
                        tmp = link.getAllElements().attr("href").toString().substring(19, 25);
                        mURL = "https://library.kangwon.ac.kr:8443/board/view.jsp?bcs=1&mode=m&bcs=1&seq=" + tmp;
                        // Log.d(TAG,text.text());
                    }
                    List.add(new ListData(mtext, mdate, mURL));
                    //string += link.toString();
                    //Log.d(TAG,"text : " + mtext);
                    //Log.d(TAG,"URL : " + mURL);
                    //Log.d(TAG,"date : " + mdate);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            for(ListData s : List){
                Ladapter.addItem(s.text, s.date );
                newList.add(s);
            }
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    public synchronized void runSearch(int index){
        this.index = index;
        SearchAsyncTask sTask = new SearchAsyncTask();
        newList.clear();
        List.clear();
        Ladapter.clear();
        sTask.execute();
    }
}

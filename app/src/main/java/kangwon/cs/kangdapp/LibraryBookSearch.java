package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Created by KHJ on 2016-07-25.
 */
public class LibraryBookSearch extends Fragment {
    int index = 1;
    protected ListView LibraryList;
    protected ArrayList<ListData> List;
    protected ArrayList<ListData> ListInfo;
    protected ArrayList<ListData> newList;
    protected ArrayList<ListData> newListInfo;
    ArrayAdapter<String> Ladapter;
    protected static ProgressBar progressBar;
    protected EditText editText;
    protected Button button;
    String TAG = "TAG";
    String htmlUrl;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lib_book_search, container, false);
        SSLConnect ssl = new SSLConnect();
        ssl.postHttps("https://library.kangwon.ac.kr/DLiWeb25/comp/search/Results.aspx?m_var=421&querytype=4&srv=31&method=2&field=TITL&keyword=&operator=0&branch=01&classid=54,46,8,56,24,27,40,45,39,65,66,55,2,21,23,25,32,13,41,38,52,7,22,67,10,12,19,6,29,33,44,5,28,31,63,11,18,53,43,50,30,34,47,9,26,35,64,4,48,49,42,3,20&max=300&cntperpage=30&viewoption=0&sort=PUBY&pagenum=1", 1000, 1000);
        Ladapter = new ArrayAdapter(getActivity(), R.layout.library_item);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar3);
        LibraryList = (ListView)v.findViewById(R.id.libraryList);
        List = new ArrayList<>();
        ListInfo = new ArrayList<>();
        newList = new ArrayList<>();
        newListInfo = new ArrayList<>();
        editText = (EditText)v.findViewById(R.id.editText2);
        button = (Button)v.findViewById(R.id.button);
        LibraryList.setAdapter(Ladapter);
        LibraryList.setOnScrollListener(new ScrollListener());
        LibraryList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                ListData mData = newList.get(position);
                ListData mInfo = newListInfo.get(position);
                String selURL = mData.URL;
                String selTile = mData.text;
                String selInfo = mInfo.Info;
                String selAuthor = mInfo.Author;
                String selPublisher = mInfo.Publisher;
                Intent intent = new Intent(getActivity(), libBook.class);
                intent.putExtra("url",selURL);
                intent.putExtra("title",selTile);
                intent.putExtra("info", selInfo);
                intent.putExtra("author", selAuthor);
                intent.putExtra("publisher", selPublisher);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                String inPutText = editText.getText().toString();
                htmlUrl = inPutText;
                Ladapter.clear();
                List.clear();
                ListInfo.clear();
                newList.clear();
                newListInfo.clear();
                index = 1;
                jsoupAsyncTask.execute();
            }
        });
        progressBar.setVisibility(View.INVISIBLE);
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
                Log.d(TAG,String.valueOf(index));
                NewAsyncTask jTask = new NewAsyncTask();
                List.clear();
                ListInfo.clear();
                jTask.execute();
            }
        }
    }

    protected class NewAsyncTask extends AsyncTask<Void, Void, Void>{
        String ntext, nURL, nInfo, nAuthor, nPublisher;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected Void doInBackground(Void...params){
            try{
                String htmlurl = "https://library.kangwon.ac.kr/DLiWeb25/comp/search/Results.aspx?m_var=421&querytype=4&srv=31&method=2&field=TITL&keyword=" + htmlUrl + "&operator=0&branch=01&classid=54,46,8,56,24,27,40,45,39,65,66,55,2,21,23,25,32,13,41,38,52,7,22,67,10,12,19,6,29,33,44,5,28,31,63,11,18,53,43,50,30,34,47,9,26,35,64,4,48,49,42,3,20&max=300&cntperpage=10&viewoption=0&sort=PUBY&pagenum=" + index;
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                //Log.d(TAG,"doc size : " + doc);
                Elements links1 = doc.select("body div#mainContent > div#contents > div#wrapper2 > form > div.advance > div.advance_title");
                Elements links2 = doc.select("body div#mainContent > div#contents > div#wrapper2 > form > div.advance > div.advance_bibliography");
                //a[href*=http://home.kangwon.ac.kr/kangwon/boardUser/boardView.jsp?mbsId=7&boardSeq]
                //Log.d(TAG,"elements size : " + links.size());
                for (Element link : links1) {
                    Element text = link;
                    nURL = link.getAllElements().attr("abs:href");
                    ntext = text.getElementsByClass("title").text();
                    List.add(new ListData(ntext, nURL));
                }

                for (Element link : links2) {
                    Element text = link;
                    nInfo = text.getElementsByIndexEquals(0).text() + text.getElementsByIndexEquals(1).text();
                    if(nInfo.length() != 0)
                        nInfo = nInfo.substring(0, nInfo.length() - 1);
                    nAuthor = text.getElementsByIndexEquals(0).text();
                    nPublisher = text.getElementsByIndexEquals(1).text();
                    Log.d(TAG,"text : " + nInfo);
                    ListInfo.add(new ListData(nInfo, nAuthor, nPublisher));
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            try {
                for (int i = 0; i < 10; i++) {
                    ListData s = List.get(i);
                    ListData t = ListInfo.get(i);
                    Ladapter.add(s.text + "\n" + t.Info);
                    newList.add(s);
                    newListInfo.add(t);
                }
            } catch(IndexOutOfBoundsException e) {

            }
            progressBar.setVisibility(View.INVISIBLE);
        }

    }

    protected class JsoupAsyncTask extends AsyncTask<Void, Void, Void>{
        String mtext, mURL, mInfo, mAuthor, mPublisher;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                String htmlurl = "https://library.kangwon.ac.kr/DLiWeb25/comp/search/Results.aspx?m_var=421&querytype=4&srv=31&method=2&field=TITL&keyword=" + htmlUrl + "&operator=0&branch=01&classid=54,46,8,56,24,27,40,45,39,65,66,55,2,21,23,25,32,13,41,38,52,7,22,67,10,12,19,6,29,33,44,5,28,31,63,11,18,53,43,50,30,34,47,9,26,35,64,4,48,49,42,3,20&max=300&cntperpage=10&viewoption=0&sort=PUBY&pagenum=1";
                Document doc = Jsoup.connect(htmlurl).maxBodySize(0).timeout(15000).get();
                //Log.d(TAG,"doc size : " + doc);
                //Elements links = doc.select("html body form table[summary*=일반 게시판] > tbody > tr");
                Elements links1 = doc.select("body div#mainContent > div#contents > div#wrapper2 > form > div.advance > div.advance_title");
                Elements links2 = doc.select("body div#mainContent > div#contents > div#wrapper2 > form > div.advance > div.advance_bibliography");
                for (Element link : links1) {
                    Element text = link;
                    mURL = link.getAllElements().attr("abs:href");
                    mtext = text.getElementsByClass("title").text();
                    List.add(new ListData(mtext, mURL));
                    Log.d(TAG,"text : " + mtext);
                    Log.d(TAG,"URL : " + mURL);
                }
                for (Element link : links2) {
                    Element text = link;
                    mInfo = text.getElementsByIndexEquals(0).text() + text.getElementsByIndexEquals(1).text();
                    if(mInfo.length() != 0)
                        mInfo = mInfo.substring(0, mInfo.length() - 1);
                    mAuthor = text.getElementsByIndexEquals(0).text();
                    mPublisher = text.getElementsByIndexEquals(1).text();
                    ListInfo.add(new ListData(mInfo, mAuthor, mPublisher));
                    Log.d(TAG,"text : " + mInfo);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            try {
                for (int i = 0; i < 10; i++) {
                    ListData s = List.get(i);
                    ListData t = ListInfo.get(i);
                    Ladapter.add(s.text + "\n" + t.Info);
                    newList.add(s);
                    newListInfo.add(t);
                }
            } catch(IndexOutOfBoundsException e) {

            }

            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    public class ListData{
        public String text, URL, Info, Author, Publisher;
        public ListData(String text, String URL){
            this.text = text;
            this.URL = URL;
        }

        public ListData(String Info, String Author, String Publisher){
            this.Info = Info;
            this.Author = Author;
            this.Publisher = Publisher;
        }
    }
}

package kangwon.cs.kangdapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.webkit.WebView;


import android.widget.LinearLayout;

import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by KHJ on 2016-09-09.
 */
public class libBook extends AppCompatActivity{
    String TAG = "TAG";
    String url;
    String title;
    String info;
    String author;
    String publisher;
    TableLayout tbInfo, tb;
    LinearLayout linearLayout;
    TextView tv1, tv2, tv3;

    private ProgressBar m_progress;
    WebView webView;
    String htmlFormat;
    JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lib_book);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        tb  = (TableLayout)findViewById(R.id.books);
        tbInfo = (TableLayout)findViewById(R.id.info);
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        m_progress = (ProgressBar)findViewById(R.id.progressBar11);

        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        info = intent.getStringExtra("info");
        author = intent.getStringExtra("author");
        setTitle("서적 정보");
        if(author.length() != 0)
            author = author.substring(0,author.length() - 1);
        publisher = intent.getStringExtra("publisher");
        if(publisher.length() != 0)
            publisher = publisher.substring(0, publisher.length() - 1);

        tbInfo.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.INVISIBLE);
        tb.setVisibility(View.INVISIBLE);

        tv1 = (TextView)findViewById(R.id.name);
        tv2 = (TextView)findViewById(R.id.author);
        tv3 = (TextView)findViewById(R.id.publisher);
        tv1.setText(title);
        tv2.setText(author);
        tv3.setText(publisher);
        SSLConnect ssl = new SSLConnect();
        ssl.postHttps(url, 1000, 1000);
        jsoupAsyncTask.execute();
        /*webView = (WebView)findViewById(R.id.webView);
        m_progress = (ProgressBar)findViewById(R.id.progressBar);
        webView.setWebViewClient(new Mywebview());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        webView.loadUrl(url);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);*/
    }

    public void appendRow(String[] strarray){
        TextView[] tv = new TextView[strarray.length];

        for(int i = 0; i < strarray.length; i++) {
            tv[i] = new TextView(this);
            if(strarray[i] != null)
                tv[i].setText(strarray[i].toString());
            tv[i].setTextSize(15);
            tv[i].setTextColor(Color.parseColor("#000000"));
            tv[i].setGravity(Gravity.CENTER);

            if(i == 0)
                tv[0].setMinWidth(100);

            if(i == 2)
                tv[2].setMinWidth(40);

            if(i == 3)
                tv[3].setTextSize(12);

            if(i == strarray.length - 1) {
                TableRow tr = new TableRow(this);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                tr.setBackgroundResource(R.drawable.image_border);

                for(int j = 0; j < strarray.length; j++)
                    tr.addView(tv[j], new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1));

                View v = new View(this);
                //v.setLayoutParams();
                v.setBackgroundColor(000000);
                tb.addView(tr);
                //tb.addView(v);
            }
        }
    }

    /*public class Mywebview extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon){
            super.onPageStarted(view,url,favicon);
            m_progress.setVisibility(View.VISIBLE);
            webView.setVisibility(View.INVISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url){
            webView.setVisibility(View.VISIBLE);
            m_progress.setVisibility(View.INVISIBLE);
        }
    }*/

    protected class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {
        String[][] str = new String[50][4];
        String tmp1, tmp2, tmp3;
        int cnt = 0;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                Document doc = Jsoup.connect(url).maxBodySize(0).timeout(15000).get();
                Elements links = doc.select("body div#mainContent > div#contents > div#wrapper2 > form > div.bibliographyinfo > div.box > table > tbody > tr");

                for(Element link : links){
                    str[cnt][0] = link.getElementsByClass("center").text();
                    tmp1 = link.getElementsByClass("stock_location").text();

                    if(tmp1.length() != 0)
                        str[cnt][1] = tmp1.substring(0, tmp1.indexOf("관") + 1) + "\n" + tmp1.substring(tmp1.indexOf("관") + 2);

                    tmp2 = link.getElementsByClass("stock_stat").text();

                    if(tmp2.length() != 0) {
                        if (tmp2.charAt(2) == '중')
                            str[cnt][2] = tmp2.substring(0, tmp2.indexOf("중") + 1) + "\n(" + tmp2.substring(tmp2.indexOf("중") + 4);

                        else
                            str[cnt][2] = tmp2;
                    }

                    tmp3 = link.getElementsByClass("stock_callnumber").text();

                    if(tmp3.length() != 0)
                        str[cnt][3] = tmp3.replaceAll(" ", "");//substring(0, tmp3.indexOf(" ") + 1) + tmp3.substring(tmp3.indexOf(" ") + 2);
                    //strurl[cnt][3] = link.getElementsByClass("stock_callnumber").text();
                    Log.d(TAG,"str0 : " + str[cnt][0]);
                    Log.d(TAG,"str1 : " + str[cnt][1]);
                    Log.d(TAG,"str2 : " + str[cnt][2]);
                    Log.d(TAG,"str3 : " + str[cnt][3]);
                    cnt++;
                }

            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            htmlFormat += "</tr>\n";

            for(int i = 0; i < cnt; i++)
                appendRow(str[i]);
            //webView.loadDataWithBaseURL("",htmlFormat,"html/text","utf-8","");
            tbInfo.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
            tb.setVisibility(View.VISIBLE);
            m_progress.setVisibility(View.INVISIBLE);
        }
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

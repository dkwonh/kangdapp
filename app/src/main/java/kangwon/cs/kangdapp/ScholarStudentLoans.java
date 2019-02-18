package kangwon.cs.kangdapp;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by KHJ on 2016-06-29.
 */
public class ScholarStudentLoans extends Fragment {
    protected static ProgressBar progressBar;
    String string = "";
    WebView webview;
    JsoupAsyncTask jsoupAsyncTask;
    String TAG = "";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.scholar_student_loans, container, false);
        webview = (WebView)v.findViewById(R.id.webView6);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar12);
        webview.setBackgroundColor(Color.parseColor("#EDEDED"));
        webview.setWebViewClient(new Mywebview());
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        jsoupAsyncTask = new JsoupAsyncTask();
        jsoupAsyncTask.execute();
        return v;
    }

    public class Mywebview extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon){
            super.onPageStarted(view,url,favicon);
            progressBar.setVisibility(View.VISIBLE);
            webview.setVisibility(View.INVISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url){
            webview.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
    protected class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                Document doc = Jsoup.connect("http://home.kangwon.ac.kr/main/html/campuslife/scholarship_02.jsp").maxBodySize(0).timeout(15000).get();
                //Log.d(TAG,"doc size : " + doc);
                Elements links = doc.select("html > body > div#center_full > div#center > div#content > div");
                for(Element link : links)
                    string += link.toString();

                while(string.indexOf("paddingh20") != -1)
                    string = string.substring(0, string.indexOf("paddingh20") - 11) + string.substring(string.indexOf("paddingh20") + 17 , string.length());

                string = string.substring(0, string.indexOf("border") + 8) + "1" + string.substring(string.indexOf("border") + 9, string.indexOf("cellpadding") + 13) + "1" + string.substring(string.indexOf("cellpadding") + 14, string.length());
                string = string.substring(0, string.indexOf("<ul class=\"knu_ul_01\">")) + string.substring(string.indexOf("<ul class=\"knu_ul_01\">") + 22, string.length());

                Log.d(TAG, "string : " + string);
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            webview.loadDataWithBaseURL("",string,"html/text","utf-8","");
        }
    }
}

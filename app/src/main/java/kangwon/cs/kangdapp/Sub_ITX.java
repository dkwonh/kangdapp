package kangwon.cs.kangdapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by WH on 2016-09-22.
 */
public class Sub_ITX extends Fragment {
    WebView webView;
    String str = "<style type=\"text/css\">\n" +
            ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
            ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
            ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
            ".tg .tg-s6z2{text-align:center}\n" +
            ".tg .tg-bmwh{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center}\n" +
            ".tg .tg-tr94{background-color:#efefef;color:#000000;text-align:center}\n" +
            "</style>\n" +
            "<table class=\"tg\" width = 345>\n" +
            "  <tr>\n" +
            "    <th class=\"tg-bmwh\" colspan=\"2\">평일(남춘천 -&gt; 용산)</th>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-tr94\" width= 80>시</td>\n" +
            "    <td class=\"tg-tr94\">분</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">06</td>\n" +
            "    <td class=\"tg-031e\">11 43</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">07</td>\n" +
            "    <td class=\"tg-031e\">11 43</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">08</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">09</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">10</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">11</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">12</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">13</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">14</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">15</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">16</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">17</td>\n" +
            "    <td class=\"tg-031e\">10</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">18</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">19</td>\n" +
            "    <td class=\"tg-031e\">13 41</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">20</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">21</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">22</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "</table>" +
            "<br>" +
            "<style type=\"text/css\">\n" +
            ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
            ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
            ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
            ".tg .tg-s6z2{text-align:center}\n" +
            ".tg .tg-bmwh{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center}\n" +
            ".tg .tg-tr94{background-color:#efefef;color:#000000;text-align:center}\n" +
            "</style>\n" +
            "<table class=\"tg\" width = 345>\n" +
            "  <tr>\n" +
            "    <th class=\"tg-bmwh\" colspan=\"2\">토요일(남춘천 -&gt; 용산)</th>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-tr94\" width = 80>시</td>\n" +
            "    <td class=\"tg-tr94\">분</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">06</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">07</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">08</td>\n" +
            "    <td class=\"tg-031e\">03 29 58</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">09</td>\n" +
            "    <td class=\"tg-031e\">29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">10</td>\n" +
            "    <td class=\"tg-031e\">03 31</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">11</td>\n" +
            "    <td class=\"tg-031e\">03 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">12</td>\n" +
            "    <td class=\"tg-031e\">03 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">13</td>\n" +
            "    <td class=\"tg-031e\">03 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">14</td>\n" +
            "    <td class=\"tg-031e\">03</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">15</td>\n" +
            "    <td class=\"tg-031e\">03 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">16</td>\n" +
            "    <td class=\"tg-031e\">03 29 55</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">17</td>\n" +
            "    <td class=\"tg-031e\">29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">18</td>\n" +
            "    <td class=\"tg-031e\">03 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">19</td>\n" +
            "    <td class=\"tg-031e\">00 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">20</td>\n" +
            "    <td class=\"tg-031e\">03 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">21</td>\n" +
            "    <td class=\"tg-031e\">03 33</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">22</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "</table>" +
            "<br>" +
            "<style type=\"text/css\">\n" +
            ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
            ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
            ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
            ".tg .tg-s6z2{text-align:center}\n" +
            ".tg .tg-bmwh{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center}\n" +
            ".tg .tg-tr94{background-color:#efefef;color:#000000;text-align:center}\n" +
            "</style>\n" +
            "<table class=\"tg\" width = 345>\n" +
            "  <tr>\n" +
            "    <th class=\"tg-bmwh\" colspan=\"2\">일요일(남춘천 -&gt; 용산)</th>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-tr94\" width = 80>시</td>\n" +
            "    <td class=\"tg-tr94\">분</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">06</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">07</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">08</td>\n" +
            "    <td class=\"tg-031e\">29 58</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">09</td>\n" +
            "    <td class=\"tg-031e\">29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">10</td>\n" +
            "    <td class=\"tg-031e\">03 31</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">11</td>\n" +
            "    <td class=\"tg-031e\">29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">12</td>\n" +
            "    <td class=\"tg-031e\">29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">13</td>\n" +
            "    <td class=\"tg-031e\">03 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">14</td>\n" +
            "    <td class=\"tg-031e\">03</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">15</td>\n" +
            "    <td class=\"tg-031e\">03 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">16</td>\n" +
            "    <td class=\"tg-031e\">03 29 56</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">17</td>\n" +
            "    <td class=\"tg-031e\">29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">18</td>\n" +
            "    <td class=\"tg-031e\">03 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">19</td>\n" +
            "    <td class=\"tg-031e\">00 29</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">20</td>\n" +
            "    <td class=\"tg-031e\">03 26</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">21</td>\n" +
            "    <td class=\"tg-031e\">03 33</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-s6z2\">22</td>\n" +
            "    <td class=\"tg-031e\">13</td>\n" +
            "  </tr>\n" +
            "</table>" +
            "업데이트 : 16.09.01";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.subway_itx, container, false);
        webView = (WebView)v.findViewById(R.id.webView8);
        webView.setWebViewClient(new Mywebview());

        webView.loadDataWithBaseURL(null,str,"html/txt","utf-8",null);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setDisplayZoomControls(false);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        return v;
    }

    public class Mywebview extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon){
            super.onPageStarted(view,url,favicon);
            SubWayMain.progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url){
            SubWayMain.progressBar.setVisibility(View.INVISIBLE);
        }
    }


}

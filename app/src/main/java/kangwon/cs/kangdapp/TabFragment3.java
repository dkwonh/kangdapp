package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by WH on 2016-09-06.
 */
public class TabFragment3 extends Fragment{
    String table_str="";
    ProgressBar progressBar;
    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.shuttle3, container, false);

        webView = (WebView)v.findViewById(R.id.webView5);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar10);
        webView.setWebViewClient(new Mywebview());
        WebSettings settings = webView.getSettings();
        table_str = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-wr85{font-weight:bold;background-color:#efefef;text-align:center}\n" +
                ".tg .tg-uqo3{background-color:#efefef;text-align:center;vertical-align:top}\n" +
                ".tg .tg-7fle{font-weight:bold;background-color:#efefef;text-align:center;vertical-align:top}\n" +
                ".tg .tg-s6z2{text-align:center}\n" +
                ".tg .tg-baqh{text-align:center;vertical-align:top}\n" +
                ".tg .tg-xhez{font-size:16px;background-color:#6b7dff;color:#ffffff;text-align:center}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-xhez\" colspan=\"5\">본교 &lt;-&gt; 퇴계동</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-wr85\" colspan=\"2\">퇴계동 -&gt; 본교</td>\n" +
                "    <td class=\"tg-uqo3\"></td>\n" +
                "    <td class=\"tg-7fle\" colspan=\"2\">본교 -&gt; 퇴계동</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-s6z2\">08:05</td>\n" +
                "    <td class=\"tg-s6z2\">09:05</td>\n" +
                "    <td class=\"tg-7fle\">금호 아파트</td>\n" +
                "    <td class=\"tg-baqh\">17:57</td>\n" +
                "    <td class=\"tg-baqh\">18:57</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-s6z2\">08:07</td>\n" +
                "    <td class=\"tg-s6z2\">09:12</td>\n" +
                "    <td class=\"tg-7fle\">주공 6단지</td>\n" +
                "    <td class=\"tg-baqh\">17:55</td>\n" +
                "    <td class=\"tg-baqh\">18:55</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-s6z2\">08:10</td>\n" +
                "    <td class=\"tg-s6z2\">09:15</td>\n" +
                "    <td class=\"tg-7fle\">극동 아파트</td>\n" +
                "    <td class=\"tg-baqh\">17:52</td>\n" +
                "    <td class=\"tg-baqh\">18:52</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-baqh\">08:13</td>\n" +
                "    <td class=\"tg-baqh\">09:18</td>\n" +
                "    <td class=\"tg-7fle\">투탑시티</td>\n" +
                "    <td class=\"tg-baqh\">17:49</td>\n" +
                "    <td class=\"tg-baqh\">18:49</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-baqh\">08:15</td>\n" +
                "    <td class=\"tg-baqh\">09:20</td>\n" +
                "    <td class=\"tg-7fle\">농협 하나로마트</td>\n" +
                "    <td class=\"tg-baqh\">17:47</td>\n" +
                "    <td class=\"tg-baqh\">18:47</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-baqh\">08:17</td>\n" +
                "    <td class=\"tg-baqh\">09:22</td>\n" +
                "    <td class=\"tg-7fle\">교대</td>\n" +
                "    <td class=\"tg-baqh\">17:39</td>\n" +
                "    <td class=\"tg-baqh\">18:39</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-baqh\">08:25</td>\n" +
                "    <td class=\"tg-baqh\">09:30</td>\n" +
                "    <td class=\"tg-7fle\">본교</td>\n" +
                "    <td class=\"tg-baqh\">17:30</td>\n" +
                "    <td class=\"tg-baqh\">18:30</td>\n" +
                "  </tr>\n" +
                "</table>";
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.loadDataWithBaseURL("",table_str,"html/text","utf-8","");
        return v;
    }

    public class Mywebview extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon){
            super.onPageStarted(view,url,favicon);
            progressBar.setVisibility(View.VISIBLE);
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
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
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
public class TabFragment2 extends Fragment {
    String table_str;
    ProgressBar progressBar;
    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.shuttle2, container, false);

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
                "    <th class=\"tg-xhez\" colspan=\"5\">본교 &lt;-&gt; 후평동</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-wr85\" colspan=\"2\">후평동 -&gt; 본교</td>\n" +
                "    <td class=\"tg-uqo3\"></td>\n" +
                "    <td class=\"tg-7fle\" colspan=\"2\">본교 -&gt; 후평동</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-s6z2\">07:40</td>\n" +
                "    <td class=\"tg-s6z2\">09:10</td>\n" +
                "    <td class=\"tg-7fle\">소양학사</td>\n" +
                "    <td class=\"tg-baqh\">17:56</td>\n" +
                "    <td class=\"tg-baqh\">18:56</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-s6z2\">07:42</td>\n" +
                "    <td class=\"tg-s6z2\">09:12</td>\n" +
                "    <td class=\"tg-7fle\">롯데 인벤스</td>\n" +
                "    <td class=\"tg-baqh\">17:53</td>\n" +
                "    <td class=\"tg-baqh\">18:53</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-s6z2\">07:48</td>\n" +
                "    <td class=\"tg-s6z2\">09:15</td>\n" +
                "    <td class=\"tg-7fle\">사농동 소양로 우체국</td>\n" +
                "    <td class=\"tg-baqh\">17:50</td>\n" +
                "    <td class=\"tg-baqh\">18:50</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-baqh\">07:53</td>\n" +
                "    <td class=\"tg-baqh\">09:18</td>\n" +
                "    <td class=\"tg-7fle\">동산 아파트(소방서)</td>\n" +
                "    <td class=\"tg-baqh\">17:47</td>\n" +
                "    <td class=\"tg-baqh\">18:47</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-baqh\">08:17</td>\n" +
                "    <td class=\"tg-baqh\">09:33</td>\n" +
                "    <td class=\"tg-7fle\">대운동장</td>\n" +
                "    <td class=\"tg-baqh\"></td>\n" +
                "    <td class=\"tg-baqh\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-baqh\"></td>\n" +
                "    <td class=\"tg-baqh\"></td>\n" +
                "    <td class=\"tg-7fle\">중앙도서관 앞</td>\n" +
                "    <td class=\"tg-baqh\">17:32</td>\n" +
                "    <td class=\"tg-baqh\">18:32</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-baqh\"></td>\n" +
                "    <td class=\"tg-baqh\"></td>\n" +
                "    <td class=\"tg-7fle\">60주년기념관 앞</td>\n" +
                "    <td class=\"tg-baqh\">17:30</td>\n" +
                "    <td class=\"tg-baqh\">18:30</td>\n" +
                "  </tr>\n" +
                "</table>";

        webView = (WebView)v.findViewById(R.id.webView4);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar9);
        webView.setWebViewClient(new Mywebview());
        WebSettings settings = webView.getSettings();
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

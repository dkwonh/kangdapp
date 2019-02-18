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
 * Created by Sunmin on 2016-09-25.
 */
public class TAdapter2 extends  Fragment{
    String table_str;
    ProgressBar progressBar;
    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.knuplus2, container,false);

        table_str = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-om3m{background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-om3m\" colspan=\"2\">신한은행</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">천지관 1층</td>\n" +
                "    <td class=\"tg-yw4l\">07:00 - 23:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">백록관 1층</td>\n" +
                "    <td class=\"tg-yw4l\">07:00 - 23:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">중앙도서관(농대쪽)</td>\n" +
                "    <td class=\"tg-yw4l\">07:00 - 23:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">BTL기숙사 1층</td>\n" +
                "    <td class=\"tg-yw4l\">07:00 - 23:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">보듬관(공대쪽문방면)</td>\n" +
                "    <td class=\"tg-yw4l\">07:00 - 23:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">의학관 1층</td>\n" +
                "    <td class=\"tg-yw4l\">07:30 - 19:30</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">공대 3호관 1층</td>\n" +
                "    <td class=\"tg-yw4l\">07:30 - 19:30</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-om3m{background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-om3m\" colspan=\"2\">농협은행</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">천지관 2층</td>\n" +
                "    <td class=\"tg-yw4l\">07:00 - 23:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">백록관 1층</td>\n" +
                "    <td class=\"tg-yw4l\">07:00 - 23:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">나래관 1층</td>\n" +
                "    <td class=\"tg-yw4l\">07:30 - 19:30</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-om3m{background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-om3m\" colspan=\"2\">우체국</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">천지관 1층</td>\n" +
                "    <td class=\"tg-yw4l\">07:00 - 23:00</td>\n" +
                "  </tr>\n" +
                "</table>";


        webView = (WebView)v.findViewById(R.id.kpluse2);
        progressBar = (ProgressBar)v.findViewById(R.id.kp2);
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

package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by WH on 2016-09-22.
 */
public class Sub_kuyngchun extends Fragment {
    WebView webView;
    String str =
            "<style type=\"text/css\">\n" +
                    ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                    ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                    ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                    ".tg .tg-baqh{text-align:center;vertical-align:top}\n" +
                    ".tg .tg-vhpo{background-color:#efefef;color:#000000;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-quxf{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-i81m{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                    ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                    ".tg .tg-yw4l{vertical-align:top}\n" +
                    "</style>\n" +
                    "<table class=\"tg\" width=345>\n" +
                    "  <tr>\n" +
                    "    <th class=\"tg-rcp4\" colspan=\"2\">평일(남춘천-&gt; 평내호평, 상봉, 광운대, 청량리)</th>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-vhpo\" width = 100>시</td>\n" +
                    "    <td class=\"tg-vhpo\">분</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">05</td>\n" +
                    "    <td class=\"tg-3we0\">  06(청)   32(청)   58</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">06</td>\n" +
                    "    <td class=\"tg-oskr\">  27   47 </td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">07</td>\n" +
                    "    <td class=\"tg-3we0\">  04(광)   16   45</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">08</td>\n" +
                    "    <td class=\"tg-oskr\">  18(청)   35(청)   53</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">09</td>\n" +
                    "    <td class=\"tg-3we0\">  17   33(청)   58</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">10</td>\n" +
                    "    <td class=\"tg-oskr\">  31   53</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">11</td>\n" +
                    "    <td class=\"tg-3we0\">  18   39</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">12</td>\n" +
                    "    <td class=\"tg-oskr\">  00   24(청)   53</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">13</td>\n" +
                    "    <td class=\"tg-3we0\">  17   39</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">14</td>\n" +
                    "    <td class=\"tg-oskr\">  07   33   56</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">15</td>\n" +
                    "    <td class=\"tg-3we0\">  24   46</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">16</td>\n" +
                    "    <td class=\"tg-oskr\">  06   31   54</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">17</td>\n" +
                    "    <td class=\"tg-3we0\">  23   33   53</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">18</td>\n" +
                    "    <td class=\"tg-oskr\">  16   48(광)</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">19</td>\n" +
                    "    <td class=\"tg-3we0\">  19   44</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">20</td>\n" +
                    "    <td class=\"tg-oskr\">  06  25(청)   45</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">21</td>\n" +
                    "    <td class=\"tg-3we0\">  07  28   46</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">22</td>\n" +
                    "    <td class=\"tg-oskr\">  06(청)   27   48</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-baqh\">23</td>\n" +
                    "    <td class=\"tg-yw4l\">  08(평)   28(평)</td>\n" +
                    "  </tr>\n" +
                    "</table><br>" +
                    "<style type=\"text/css\">\n" +
                    ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                    ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                    ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                    ".tg .tg-baqh{text-align:center;vertical-align:top}\n" +
                    ".tg .tg-vhpo{background-color:#efefef;color:#000000;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-quxf{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-i81m{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                    ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                    ".tg .tg-yw4l{vertical-align:top}\n" +
                    "</style>\n" +
                    "<table class=\"tg\" width=345>\n" +
                    "  <tr>\n" +
                    "    <th class=\"tg-rcp4\" colspan=\"2\">토요일(남춘천-&gt; 평내호평, 상봉, 광운대, 청량리)</th>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-vhpo\" width = 100>시</td>\n" +
                    "    <td class=\"tg-vhpo\">분</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">05</td>\n" +
                    "    <td class=\"tg-3we0\">  38(청)</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">06</td>\n" +
                    "    <td class=\"tg-oskr\">  16(청)   50</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">07</td>\n" +
                    "    <td class=\"tg-3we0\">  21   44</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">08</td>\n" +
                    "    <td class=\"tg-oskr\">  08(청)   34</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">09</td>\n" +
                    "    <td class=\"tg-3we0\">  04   22   47(청)</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">10</td>\n" +
                    "    <td class=\"tg-oskr\">  15   44</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">11</td>\n" +
                    "    <td class=\"tg-3we0\">  10   33   53</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">12</td>\n" +
                    "    <td class=\"tg-oskr\">  11(청)   44</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">13</td>\n" +
                    "    <td class=\"tg-3we0\">  13   39</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">14</td>\n" +
                    "    <td class=\"tg-oskr\">  07   29   47 </td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">15</td>\n" +
                    "    <td class=\"tg-3we0\">  09(청)   39</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">16</td>\n" +
                    "    <td class=\"tg-oskr\">  10   39</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">17</td>\n" +
                    "    <td class=\"tg-3we0\">  04   22   45(청)</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">18</td>\n" +
                    "    <td class=\"tg-oskr\">  08(청)   45</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">19</td>\n" +
                    "    <td class=\"tg-3we0\">  06   32   50</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">20</td>\n" +
                    "    <td class=\"tg-oskr\">  13(청)   39</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">21</td>\n" +
                    "    <td class=\"tg-3we0\">  08   37   54(청)</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">22</td>\n" +
                    "    <td class=\"tg-oskr\">  18   48</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-baqh\">23</td>\n" +
                    "    <td class=\"tg-yw4l\">  13(평)</td>\n" +
                    "  </tr>\n" +
                    "</table><br>"+
                    "<style type=\"text/css\">\n" +
                    ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                    ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                    ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                    ".tg .tg-baqh{text-align:center;vertical-align:top}\n" +
                    ".tg .tg-vhpo{background-color:#efefef;color:#000000;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-quxf{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-i81m{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                    ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                    ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                    ".tg .tg-yw4l{vertical-align:top}\n" +
                    "</style>\n" +
                    "<table class=\"tg\" width=345>\n" +
                    "  <tr>\n" +
                    "    <th class=\"tg-rcp4\" colspan=\"2\">일요일(남춘천-&gt; 평내호평, 상봉, 광운대, 청량리)</th>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-vhpo\" width = 100>시</td>\n" +
                    "    <td class=\"tg-vhpo\">분</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">05</td>\n" +
                    "    <td class=\"tg-3we0\">  38(청)</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">06</td>\n" +
                    "    <td class=\"tg-oskr\">  16(청)   50</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">07</td>\n" +
                    "    <td class=\"tg-3we0\">  21   44</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">08</td>\n" +
                    "    <td class=\"tg-oskr\">  04(청)   34</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">09</td>\n" +
                    "    <td class=\"tg-3we0\">  02   22   47(청)</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">10</td>\n" +
                    "    <td class=\"tg-oskr\">  15   44</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">11</td>\n" +
                    "    <td class=\"tg-3we0\">  10   33   53</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">12</td>\n" +
                    "    <td class=\"tg-oskr\">  11(청)   44</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">13</td>\n" +
                    "    <td class=\"tg-3we0\">  13   40</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">14</td>\n" +
                    "    <td class=\"tg-oskr\">  07   29   47 </td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">15</td>\n" +
                    "    <td class=\"tg-3we0\">  09(청)   39</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">16</td>\n" +
                    "    <td class=\"tg-oskr\">  10   35</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">17</td>\n" +
                    "    <td class=\"tg-3we0\">  04   16   45(청)</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">18</td>\n" +
                    "    <td class=\"tg-oskr\">  08(청)   43</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">19</td>\n" +
                    "    <td class=\"tg-3we0\">  06   32   50</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">20</td>\n" +
                    "    <td class=\"tg-oskr\">  13(청)   39</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-i81m\">21</td>\n" +
                    "    <td class=\"tg-3we0\">  08   37   54(청)</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-quxf\">22</td>\n" +
                    "    <td class=\"tg-oskr\">  18   48</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-baqh\">23</td>\n" +
                    "    <td class=\"tg-yw4l\">  13(평)</td>\n" +
                    "  </tr>\n" +
                    "</table>"+
                    "업데이트 : 16.09.26";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.subway_kuyngchun, container, false);
        webView = (WebView)v.findViewById(R.id.webView7);
        webView.setWebViewClient(new Mywebview());
        WebSettings settings = webView.getSettings();

        webView.loadDataWithBaseURL(null,str,"html/txt","utf-8",null);

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

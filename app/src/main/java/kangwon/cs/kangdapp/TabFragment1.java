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
public class TabFragment1 extends Fragment{
    String table_str;
    String table_str2;
    ProgressBar progressBar;
    WebView webView;
    String align = "center";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.shuttle1, container, false);

        table_str = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-r7hx{font-size:14px;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-quxf{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-jd1p{background-color:#efefef;font-weight:bold;text-align:center;vertical-align:top}\n" +
                ".tg .tg-i81m{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\"width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-r7hx\" colspan=\"3\">등교버스<br>운행방향: 남춘천역 -&gt;본교</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-jd1p\">월</td>\n" +
                "    <td class=\"tg-jd1p\">화-목</td>\n" +
                "    <td class=\"tg-jd1p\">금</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">08:00</td>\n" +
                "    <td class=\"tg-i81m\">08:00</td>\n" +
                "    <td class=\"tg-i81m\">08:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">08:20</td>\n" +
                "    <td class=\"tg-quxf\">08:20</td>\n" +
                "    <td class=\"tg-quxf\">08:20</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">08:22</td>\n" +
                "    <td class=\"tg-i81m\">08:22</td>\n" +
                "    <td class=\"tg-i81m\">08:22</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">08:40</td>\n" +
                "    <td class=\"tg-quxf\">08:40</td>\n" +
                "    <td class=\"tg-quxf\">08:40</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">08:45</td>\n" +
                "    <td class=\"tg-i81m\">08:45</td>\n" +
                "    <td class=\"tg-i81m\">08:45</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">08:50</td>\n" +
                "    <td class=\"tg-quxf\">08:50</td>\n" +
                "    <td class=\"tg-quxf\">08:57</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">08:57</td>\n" +
                "    <td class=\"tg-i81m\">08:57</td>\n" +
                "    <td class=\"tg-i81m\">09:10</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">09:10</td>\n" +
                "    <td class=\"tg-quxf\">09:10</td>\n" +
                "    <td class=\"tg-quxf\">09:20</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">09:20</td>\n" +
                "    <td class=\"tg-i81m\">09:20</td>\n" +
                "    <td class=\"tg-i81m\">09:39</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">09:45</td>\n" +
                "    <td class=\"tg-quxf\">09:45</td>\n" +
                "    <td class=\"tg-quxf\">09:45</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">09:50</td>\n" +
                "    <td class=\"tg-i81m\">09:50</td>\n" +
                "    <td class=\"tg-i81m\">09:55</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">09:51</td>\n" +
                "    <td class=\"tg-quxf\">09:51</td>\n" +
                "    <td class=\"tg-quxf\">10:20</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">09:55</td>\n" +
                "    <td class=\"tg-i81m\">09:55</td>\n" +
                "    <td class=\"tg-i81m\">10:23</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">10:20</td>\n" +
                "    <td class=\"tg-quxf\">10:20</td>\n" +
                "    <td class=\"tg-quxf\" rowspan=\"2\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">10:23</td>\n" +
                "    <td class=\"tg-i81m\">10:23</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>";
        table_str2 = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-r7hx{font-size:14px;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-quxf{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-jd1p{background-color:#efefef;font-weight:bold;text-align:center;vertical-align:top}\n" +
                ".tg .tg-i81m{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-r7hx\" colspan=\"3\">하교버스<br>운행방향: 본교 -&gt; 남춘천역</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-jd1p\" colspan=\"3\">월-금</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">16:00</td>\n" +
                "    <td class=\"tg-i81m\">16:30</td>\n" +
                "    <td class=\"tg-i81m\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">17:00</td>\n" +
                "    <td class=\"tg-quxf\">17:20</td>\n" +
                "    <td class=\"tg-quxf\">17:40</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">18:00</td>\n" +
                "    <td class=\"tg-i81m\">18:20</td>\n" +
                "    <td class=\"tg-i81m\">18:40</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">19:00</td>\n" +
                "    <td class=\"tg-quxf\">19:20</td>\n" +
                "    <td class=\"tg-quxf\"></td>\n" +
                "  </tr>\n" +
                "</table>";

        webView = (WebView)v.findViewById(R.id.webView3);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar8);
        webView.setWebViewClient(new Mywebview());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.loadDataWithBaseURL("",table_str+table_str2,"html/text","utf-8","");
/*
        "<table> \n<tr> \n<th colspan="+3+">등교 버스<br>운행 방향 : 남춘천 역 -&gt; 본교</th> \n</tr> \n<tr> \n<td>월요일</td> \n<td>화~목요일</td> \n<td>금요일</td> \n</tr> \n<tr> \n<td>08:00</td> \n<td>08:00</td> \n<td>08:00</td> \n</tr> \n<tr> \n<td>08:20</td>\n<td>08:20</td>\n<td>08:20</td>\n</tr>\n<tr>\n<td>08:22</td>\n<td>08:22</td>\n<td>08:22</td>\n</tr>\n<tr>\n<td>08:40</td>\n<td>08:40</td>\n<td>08:40</td>\n</tr>\n<tr>\n<td>08:45</td>\n<td>08:45</td>\n<td>08:45</td>\n</tr>\n<tr>\n<td>08:50</td>\n<td>08:50</td>\n<td>08:57</td>\n</tr>\n<tr>\n<td>08:57</td>\n<td>08:57</td>\n<td>09:10</td>\n</tr>\n<tr>\n<td>09:10</td>\n<td>09:10</td>\n<td>09:20</td>\n</tr>\n<tr>\n<td>09:20</td>\n<td>09:20</td>\n<td>09:39</td>\n</tr>\n<tr>\n<td>09:45</td>\n<td>09:45</td>\n<td>09:45</td>\n</tr>\n<tr>\n<td>09:50</td>\n<td>09:50</td>\n<td>09:55</td>\n</tr>\n<tr>\n<td>09:51</td>\n<td>09:51</td>\n<td>10:20</td>\n</tr>\n<tr>\n<td>09:55</td>\n<td>09:55</td>\n<td>10:23</td>\n</tr>\n<tr>\n<td>10:20</td>\n<td>10:20</td>\n<td rowspan="+2+"></td>\n</tr>\n<tr>\n<td>10:23</td>\n<td>10:23</td>\n</tr>\n</table>";
*/
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
   /* "<table align=\"+align+\" Width = 400 cellpadding = 0 cellspacing = 1>
    <tr>
    <th bgcolor = #1834c4><font color = #ffffff >하교 버스<br>운행 경로 : 본교 -&gt; 남춘천 역</font><br></th>
    </tr>
    <tr align="+align+" bgcolor = #00bfff>
    <td align="+align+"><font color = #ffffff>월 ~ 금요일</font></td>
    </tr>
    <tr>
    <td align="+align+">16:00</td>
    </tr>
    <tr>
    <td align="+align+">16:30</td>
    </tr>
    <tr>
    <td align="+align+">17:00</td>
    </tr>
    <tr>
    <td align="+align+">17:20</td>
    </tr>
    <tr>
    <td align="+align+">17:40</td>
    </tr>
    <tr>
    <td align="+align+">18:00</td>
    </tr>
    <tr>
    <td align="+align+">18:20</td>
    </tr>
    <tr>
    <td align="+align+">18:40</td>
    </tr>
    <tr>
    <td align="+align+">19:00</td>
    </tr>
    <tr>
    <td align="+align+">19:20</td>
    </tr>
    </table>";*/
}
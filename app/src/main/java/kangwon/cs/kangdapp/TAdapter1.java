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
 * Created by Sunmin on 2016-09-23.
 */
public class TAdapter1 extends Fragment {
    String table_str;
    String table_str2;
    String table_str3;
    ProgressBar progressBar;
    WebView webview;
    String align = "center";
    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.knuplus1, container,false);
        table_str = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-cwv5{background-color:#ffffff;text-align:right;vertical-align:top}\n" +
                ".tg .tg-5qb8{background-color:#ffffff;text-align:right;vertical-align:top}\n" +
                ".tg .tg-r59z{background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-r59z\">매점</th>\n" +
                "    <th class=\"tg-r59z\">위치</th>\n" +
                "    <th class=\"tg-r59z\">운영시간</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">천지관 매점</td>\n" +
                "    <td class=\"tg-oskr\">천지관 1층</td>\n" +
                "    <td class=\"tg-oskr\">08:00 - 18:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">백록관 매점</td>\n" +
                "    <td class=\"tg-3we0\">백록관 1층</td>\n" +
                "    <td class=\"tg-cwv5\">08:00 - 18:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">60주년 매점</td>\n" +
                "    <td class=\"tg-oskr\">60주년 기념관 1층</td>\n" +
                "    <td class=\"tg-5qb8\">08:00 - 18:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">석재 매점</td>\n" +
                "    <td class=\"tg-3we0\">석재 신소재센터 4층</td>\n" +
                "    <td class=\"tg-cwv5\">08:00 - 18:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">백령마트</td>\n" +
                "    <td class=\"tg-oskr\">친환경 연구센터1층</td>\n" +
                "    <td class=\"tg-oskr\">08:00 - 18:00</td>\n" +
                "  </tr>\n" +
                "</table>" +
                "<br>";

        table_str2 = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-cwv5{background-color:#ffffff;text-align:right;vertical-align:top}\n" +
                ".tg .tg-5qb8{background-color:#ffffff;text-align:right;vertical-align:top}\n" +
                ".tg .tg-r59z{background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\"width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-r59z\">휴게시설</th>\n" +
                "    <th class=\"tg-r59z\">위치</th>\n" +
                "    <th class=\"tg-r59z\">운영시간</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">맘스터치</td>\n" +
                "    <td class=\"tg-oskr\">천지관 2층</td>\n" +
                "    <td class=\"tg-oskr\">09:00 - 19:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">cafe 마운틴</td>\n" +
                "    <td class=\"tg-3we0\">60주년 기념관 앞</td>\n" +
                "    <td class=\"tg-cwv5\">08:30 - 20:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">뚜레주르</td>\n" +
                "    <td class=\"tg-oskr\">60주년 기념관 앞</td>\n" +
                "    <td class=\"tg-5qb8\">08:30 - 20:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">석재 까페</td>\n" +
                "    <td class=\"tg-3we0\">석재 신소재센터 5층</td>\n" +
                "    <td class=\"tg-cwv5\">09:00 - 19:00</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">cafe 마운틴</td>\n" +
                "    <td class=\"tg-oskr\">농생대 1호관 앞</td>\n" +
                "    <td class=\"tg-oskr\">08:30 - 20:00</td>\n" +
                "  </tr>\n" +
                "</table>" +
                "<br>";
        table_str3 = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-cwv5{background-color:#ffffff;text-align:right;vertical-align:top}\n" +
                ".tg .tg-5qb8{background-color:#ffffff;text-align:right;vertical-align:top}\n" +
                ".tg .tg-r59z{background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-1d4l{background-color:#6b7dff;color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-b7b8{background-color:#f9f9f9;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\"width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-r59z\">휴게시설</th>\n" +
                "    <th class=\"tg-r59z\">위치</th>\n" +
                "    <th class=\"tg-r59z\">운영시간</th>\n" +
                "    <th class=\"tg-1d4l\">연락처</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">서점</td>\n" +
                "    <td class=\"tg-oskr\">천지관 1층</td>\n" +
                "    <td class=\"tg-oskr\">08:30 - 19:00</td>\n" +
                "    <td class=\"tg-b7b8\">250-7356</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">문구점</td>\n" +
                "    <td class=\"tg-3we0\">천지관 1층</td>\n" +
                "    <td class=\"tg-cwv5\">08:30 - 19:00</td>\n" +
                "    <td class=\"tg-yw4l\">250-7358</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">안경점</td>\n" +
                "    <td class=\"tg-oskr\">천지관 1층</td>\n" +
                "    <td class=\"tg-5qb8\">09:30 - 19:00</td>\n" +
                "    <td class=\"tg-b7b8\">257-3282</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">우체국</td>\n" +
                "    <td class=\"tg-3we0\">천지관 1층</td>\n" +
                "    <td class=\"tg-cwv5\">09:00 - 18:00</td>\n" +
                "    <td class=\"tg-yw4l\">250-7355</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">복사실</td>\n" +
                "    <td class=\"tg-oskr\">천지관 2층</td>\n" +
                "    <td class=\"tg-oskr\">08:20 -18:30<br>10:00-17:00土</td>\n" +
                "    <td class=\"tg-b7b8\">250-7337</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">사진관</td>\n" +
                "    <td class=\"tg-3we0\">천지관 2층</td>\n" +
                "    <td class=\"tg-3we0\">09:00-19:00</td>\n" +
                "    <td class=\"tg-3we0\">250-0993</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">만물사(철물점)</td>\n" +
                "    <td class=\"tg-oskr\">천지관 2층</td>\n" +
                "    <td class=\"tg-oskr\">09:00-16:00</td>\n" +
                "    <td class=\"tg-oskr\">255-0993</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">구내스포츠</td>\n" +
                "    <td class=\"tg-3we0\">천지관 2층</td>\n" +
                "    <td class=\"tg-3we0\">09:00-18:00</td>\n" +
                "    <td class=\"tg-3we0\">244-8536</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">미용실</td>\n" +
                "    <td class=\"tg-oskr\">천지관 2층</td>\n" +
                "    <td class=\"tg-oskr\">09:00-19:00</td>\n" +
                "    <td class=\"tg-oskr\">256-5760</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">정육점</td>\n" +
                "    <td class=\"tg-3we0\">천지관 2층</td>\n" +
                "    <td class=\"tg-3we0\">09:30-19:00</td>\n" +
                "    <td class=\"tg-3we0\">255-8292</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">시사영어사</td>\n" +
                "    <td class=\"tg-oskr\">천지관 2층</td>\n" +
                "    <td class=\"tg-oskr\">09:30-19:00</td>\n" +
                "    <td class=\"tg-oskr\">243-0555</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">복사실</td>\n" +
                "    <td class=\"tg-3we0\">60주년 기념관 2층</td>\n" +
                "    <td class=\"tg-3we0\">08:20-17:00</td>\n" +
                "    <td class=\"tg-3we0\"></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">복사실</td>\n" +
                "    <td class=\"tg-oskr\">도서관 2층</td>\n" +
                "    <td class=\"tg-oskr\">08:20-19:00</td>\n" +
                "    <td class=\"tg-oskr\"></td>\n" +
                "  </tr>\n" +
                "</table>";
        webview = (WebView)v.findViewById(R.id.kpluse1);
        progressBar = (ProgressBar) v.findViewById(R.id.kp1);
        webview.setWebViewClient(new Mywebview());
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        webview.loadDataWithBaseURL("", table_str+ table_str2+table_str3, "html/text", "utf-8", "");

        return v;
    }

    public class Mywebview extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
            webview.setVisibility(View.INVISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            webview.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}


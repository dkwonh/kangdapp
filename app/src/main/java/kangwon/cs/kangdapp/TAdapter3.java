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
public class TAdapter3 extends  Fragment {
    String table_str;
    ProgressBar progressBar;
    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.knuplus3, container, false);

        webView = (WebView)v.findViewById(R.id.kpluse3);
        progressBar = (ProgressBar)v.findViewById(R.id.kp3);
        webView.setWebViewClient(new Mywebview());
        WebSettings settings = webView.getSettings();
        table_str = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-ugrf{background-color:#6b7dff ;color:#ffffff;text-align:center}\n" +
                ".tg .tg-yw4l{vertical-align:top}" +
                "</style>\n" +
                "<table class=\"tg\" width = 345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-ugrf\" colspan=\"2\">봉사분과</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">늘푸른젊은이웃(청소년교육)</td>\n" +
                "    <td class=\"tg-031e\">나래(양로원)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">높낮이없는세상(노인말벗)</td>\n" +
                "    <td class=\"tg-031e\">로타랙트</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">아이와(유아교육)</td>\n" +
                "    <td class=\"tg-yw4l\">질그릇자활회</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">밝은소리(사회봉사)</td>\n" +
                "    <td class=\"tg-yw4l\">해비타트(집짓기봉사)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">한울회</td>\n" +
                "    <td class=\"tg-yw4l\">흑곰로버스카우트</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">호우회(호국보훈)</td>\n" +
                "    <td class=\"tg-yw4l\">KNU119(농활)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">DJ Kang (재난구호)</td>\n" +
                "    <td class=\"tg-yw4l\">KUSA</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">백율회</td>\n" +
                "    <td class=\"tg-yw4l\"></td>\n" +
                "  </tr>\n" +
                "</table>"+ "</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg .tg-ugrf{background-color:#6b7dff;color:#ffffff;text-align:center}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width = 345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-ugrf\" colspan=\"2\">종교분과</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">IVF(기독교)</td>\n" +
                "    <td class=\"tg-031e\">가톨릭학생회(가톨릭)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">네비게이토선교회(기독교)</td>\n" +
                "    <td class=\"tg-031e\">대불연(불교)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">예수전도단(기독교)</td>\n" +
                "    <td class=\"tg-yw4l\">한마음선교회(기독교)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">CARP(통일교)</td>\n" +
                "    <td class=\"tg-yw4l\">CCC(기독교)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">ESF(기독교)</td>\n" +
                "    <td class=\"tg-yw4l\">JDM(기독교)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">SFC(기독교)</td>\n" +
                "    <td class=\"tg-yw4l\">UBF(기독교)</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg .tg-ugrf{background-color:#6b7dff;color:#ffffff;text-align:center}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width = 345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-ugrf\" colspan=\"2\">공연예술분과</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">놀이패한마당(풍물패)</td>\n" +
                "    <td class=\"tg-031e\">강클연(클래식기타)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">기타치노(핑거스타일기타)</td>\n" +
                "    <td class=\"tg-031e\">꾼(민중가요)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">루더(마술)</td>\n" +
                "    <td class=\"tg-yw4l\">루덴시스(행사기획)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">브로커(힙합)</td>\n" +
                "    <td class=\"tg-yw4l\">영그리(연극)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">울음큰새(어쿠스틱밴드)</td>\n" +
                "    <td class=\"tg-yw4l\">C&amp;J(클래식/재즈)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">MIC(밴드)</td>\n" +
                "    <td class=\"tg-yw4l\">RMPC(락/밴드)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">TONE(성우)</td>\n" +
                "    <td class=\"tg-yw4l\">TYS(댄스)</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg .tg-ugrf{background-color:#6b7dff;color:#ffffff;text-align:center}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width = 345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-ugrf\" colspan=\"2\">취미전시분과</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">HOM(모형제작)</td>\n" +
                "    <td class=\"tg-031e\">기우회(바둑)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">나침반(여행)</td>\n" +
                "    <td class=\"tg-031e\">백령낚시회(낚시)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">북한강(문학창작)</td>\n" +
                "    <td class=\"tg-yw4l\">판화사랑(그림/판화)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">CON(영화감상/비평)</td>\n" +
                "    <td class=\"tg-yw4l\">P&amp;C(반려동물)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">봄내사진예술연구회(촬영/전시)</td>\n" +
                "    <td class=\"tg-yw4l\">작은영화연구회(영화제작/비평)</td>\n" +
                "  </tr>\n" +
                "</table>" +"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg .tg-ugrf{background-color:#6b7dff;color:#ffffff;text-align:center}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width = 345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-ugrf\" colspan=\"2\">체육분과</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">검동회(검도)</td>\n" +
                "    <td class=\"tg-031e\">덕무회(합기도)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">레드파워스(야구)</td>\n" +
                "    <td class=\"tg-031e\">마귀(승마)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">백령테니스(테니스)</td>\n" +
                "    <td class=\"tg-yw4l\">산악회(등산)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">스플래쉬(볼링)</td>\n" +
                "    <td class=\"tg-yw4l\">오버드라이브(자전거)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">요트부(요트)</td>\n" +
                "    <td class=\"tg-yw4l\">청도회(해동검도)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">탁우회(탁구)</td>\n" +
                "    <td class=\"tg-yw4l\">투혼(복싱)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">레드버팔로(플로어볼)</td>\n" +
                "    <td class=\"tg-yw4l\">CAPRA(미식축구)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">FREE STYLE(익스트림스포츠)</td>\n" +
                "    <td class=\"tg-yw4l\">KNUFC(축구)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">JULIUS(농구)</td>\n" +
                "    <td class=\"tg-yw4l\">FPB(배드민턴)</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                ".tg .tg-ugrf{background-color:#6b7dff;color:#ffffff;text-align:center}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width = 345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-ugrf\" colspan=\"2\">교양학술분과</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">동굴연구회(동굴탐사)</td>\n" +
                "    <td class=\"tg-031e\">맞불(토론)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-031e\">문방구(문화탐방)</td>\n" +
                "    <td class=\"tg-031e\">봄시내(영어)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">소리스케치(수화)</td>\n" +
                "    <td class=\"tg-yw4l\">스파크(영어)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">컴퓨터연구회(컴퓨터)</td>\n" +
                "    <td class=\"tg-yw4l\">CAB(컴퓨터프로그래밍)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">ENACTUS(사회공헌활동)</td>\n" +
                "    <td class=\"tg-yw4l\">KEY(영어)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">PASION(대외활동)</td>\n" +
                "    <td class=\"tg-yw4l\">STOCK(주식)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">TIME(영어)</td>\n" +
                "    <td class=\"tg-yw4l\">REDER'S DIGEST(영어)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">그란투리스모(자동차/메카닉)</td>\n" +
                "    <td class=\"tg-yw4l\">셈틀과그림터(컴퓨터그래픽)</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\" colspan=\"2\">백령우주천문과학연구회(천문)</td>\n" +
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

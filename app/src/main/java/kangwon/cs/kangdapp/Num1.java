package kangwon.cs.kangdapp;

import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by Sunmin on 2016-10-10.
 */
public class Num1 extends Fragment{
    String table_str;
    ProgressBar progressBar;
    WebView webview;
    String align ="center";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.num1, container, false);
        table_str = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-baqh{text-align:center;vertical-align:top}\n" +
                ".tg .tg-vhpo{background-color:#efefef;color:#000000;text-align:center;vertical-align:top}\n" +
                ".tg .tg-quxf{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-08c0{background-color:#efefef;text-align:center;vertical-align:top}\n" +
                ".tg .tg-i81m{background-color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-o4ll{font-weight:bold;background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"3\">학사지원과</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-vhpo\">성명</td>\n" +
                "    <td class=\"tg-vhpo\">담당업무</td>\n" +
                "    <td class=\"tg-08c0\">전화번호</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">정재진</td>\n" +
                "    <td class=\"tg-3we0\">학사지원과 업무 총괄</td>\n" +
                "    <td class=\"tg-baqh\">033-255-6010</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">김주환</td>\n" +
                "    <td class=\"tg-oskr\">편입생 오리엔테이션<br>수업관련 정보공시<br>규정개정, 제도개선 업무</td>\n" +
                "    <td class=\"tg-quxf\">033-255-6995</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-i81m\">김영신</td>\n" +
                "    <td class=\"tg-3we0\">학적관련<br>입학식, 졸업식행사<br>명예박사학위 수여업무<br>학적관련 정보공시 총괄</td>\n" +
                "    <td class=\"tg-o4ll\">033-255-6011</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-quxf\">여상호</td>\n" +
                "    <td class=\"tg-oskr\">학부 수강신청 관리<br>출석부, 휴/보강 관리<br>교류학생 수강, 학점관리</td>\n" +
                "    <td class=\"tg-oskr\">033-255-6017</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">용화중</td>\n" +
                "    <td class=\"tg-3we0\">졸업사정 업무<br>졸업시험(논문)관리<br>졸업 인증제 관리<br>모집단위이동(전과) 업무</td>\n" +
                "    <td class=\"tg-i81m\">033-255-6012</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">권현화</td>\n" +
                "    <td class=\"tg-oskr\">수업운영, 통계관리<br>강사료운영 관리<br>교육/연구 학생지도 비용업무</td>\n" +
                "    <td class=\"tg-quxf\">033-255-6015</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">최신정</td>\n" +
                "    <td class=\"tg-3we0\">예산, 결산업무<br>일반서무 / 물품관리</td>\n" +
                "    <td class=\"tg-i81m\">033-255-6994</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">함지연</td>\n" +
                "    <td class=\"tg-oskr\">민원업무(수수료 세입관리)<br>학력조회 및 회신업무<br>교원자격증 증명서 발급</td>\n" +
                "    <td class=\"tg-quxf\">033-255-8272</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">차화영</td>\n" +
                "    <td class=\"tg-3we0\">학부성적관리(계절학기 포함)<br>원어강의, 계절수업 관리<br>전과, 편입학 학점인정 관리<br>수업평가</td>\n" +
                "    <td class=\"tg-i81m\">033-255-6016</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">권용진</td>\n" +
                "    <td class=\"tg-oskr\">학적관리 업무<br>학번부여, 전공배정 관리<br>학점은행제, 시간제 등록생 관리<br>재입학, 학위복 관리</td>\n" +
                "    <td class=\"tg-quxf\">033-255-6013</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">장은수</td>\n" +
                "    <td class=\"tg-3we0\">교육과정 위원회 운영<br>교육과정, 교직이수 운영<br>편입생 오리엔테이션<br>복수/부/연계 전공 관리<br>교원자격증 대장 관리</td>\n" +
                "    <td class=\"tg-i81m\">033-255-6014</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">유석균<br>안광현</td>\n" +
                "    <td class=\"tg-oskr\">60주년 기념관, 교양강의실 관리<br>공관관리 업무</td>\n" +
                "    <td class=\"tg-quxf\">033-255-7777</td>\n" +
                "  </tr>\n" +
                "</table>";

        webview = (WebView) v.findViewById(R.id.numberlist1);
        progressBar = (ProgressBar) v.findViewById(R.id.nl1);
        webview.setWebViewClient(new Mywebview());
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        webview.loadDataWithBaseURL("", table_str, "html/text", "utf-8", "");

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




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
 * Created by Sunmin on 2016-10-10.
 */
public class Num2 extends Fragment{
    String table_str;
    ProgressBar progressBar;
    WebView webview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.num2, container,false);

        table_str = "<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">경영대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">경영학전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6140</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">회계학전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6170</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">관광경영학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6160</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">글로벌 비지니스 학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6133</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-b7b8{background-color:#f9f9f9;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">공과대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">건축학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6210</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">건축공학 전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6220</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">토목공학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6230</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">자원공학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6250</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">나노응용공학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6260</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">생물공학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6270</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">시스템경영공학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6280</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">환경공학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6350</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">화학공학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6330</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">기계의용공학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6310</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-b7b8\">메카드로닉스공학과</td>\n" +
                "    <td class=\"tg-b7b8\">033-250-6370</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>" +"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">농업생명과학대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">농업자원경제학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8660</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">식물자원응용과학 전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6410</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">응용생물학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6410</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">바이오시스템공학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6490</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">원예학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6420</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">지역건설공학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6460</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">바이오자원환경학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6440</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">환경학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8570</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">식품생명공학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6450</td>\n" +
                "  </tr>\n" +
                "</table>" +"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">동물생명과학대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">축산식품과학전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8640</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">동물생명공학전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8630</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">응용생물학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6410</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">사료생산과학전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8620</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">축산과학전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8610</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">문화예술대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">디자인학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8710</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">미술학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8710</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">음악학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8730</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">무용학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8740</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">영상문화학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8750</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">스토리텔링학과</td>\n" +
                "    <td class=\"tg-yw4l\">033-250-8760</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">법과대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">법과대학</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6503</td>\n" +
                "  </tr>\n" +
                "</table>" + "</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">사범대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">국어교육과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6602</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">영어교육과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6630</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">한문교육과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6640</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">교육학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6650 </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">윤리교육과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6670</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">역사교육과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6680</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">지리교육과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6690</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">일반사회교육과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6710</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">수학교육과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6720</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">과학교육학부</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6730</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">가정교육과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6740</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">체육교육과</td>\n" +
                "    <td class=\"tg-yw4l\">033-250-6790</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">사회과학대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">문화인류학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6809</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">부동산학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6830</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">사회학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6860</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">신문방송학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6880</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">심리학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6850</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">정치외교학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6840</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">행정학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-66840</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">산림환경과학대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">산림경영학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8330</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">산림자원공학 전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8310</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">산림환경보호학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8360</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">산림바이오소재공학 전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8320</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">제지공학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8350</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">생태조경디자인학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8340</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">수의과대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">수의학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8650</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">수의예과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8450</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">약학대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">약학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6901</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">의과대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">간호학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8802</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-b7b8{background-color:#f9f9f9;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">분자생명공학과</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">분자생명공학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8540</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">생물의소재공학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6560</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">생명건강공학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6470</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">시스템면역과학 전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8380</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-b7b8\">의생명공학 전공</td>\n" +
                "    <td class=\"tg-b7b8\">033-250-6480</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">인문대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">국어국문학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8210</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">영어영문학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8140</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">독어독문학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8160</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">불어불문학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8170</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">중어중문학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8180</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">사학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8210</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">철학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8320</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">일본학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8250</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-yw4l{vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">자연과학대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">물리학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8460</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">지질학 전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8550</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">지구물리학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8580</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">생화학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8510</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">화학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8480</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">수학과</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8410</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">정보통계학과</td>\n" +
                "    <td class=\"tg-oskr\">033-250-8430</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-yw4l\">생명과학과</td>\n" +
                "    <td class=\"tg-yw4l\">033-250-8520</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">IT대학</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">전기전자공학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6290</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">전자공학 전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6320</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">전자통신공학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6340</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">컴퓨터과학 전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-8440</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">컴퓨터정보통신공학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6390</td>\n" +
                "  </tr>\n" +
                "</table>"+"</br>"+"<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}\n" +
                ".tg .tg-rcp4{font-weight:bold;background-color:#6b7dff;color:#ffffff;text-align:center;vertical-align:top}\n" +
                ".tg .tg-oskr{background-color:#ffffff;vertical-align:top}\n" +
                ".tg .tg-3we0{background-color:#ffffff;vertical-align:top}\n" +
                "</style>\n" +
                "<table class=\"tg\" width=345>\n" +
                "  <tr>\n" +
                "    <th class=\"tg-rcp4\" colspan=\"2\">스포츠과학부</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-oskr\">스포츠과학 전공</td>\n" +
                "    <td class=\"tg-oskr\">033-250-6780</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td class=\"tg-3we0\">스포츠지도 전공</td>\n" +
                "    <td class=\"tg-3we0\">033-250-6780</td>\n" +
                "  </tr>\n" +
                "</table>";


        webview = (WebView)v.findViewById(R.id.numberlist2);
        progressBar = (ProgressBar)v.findViewById(R.id.nl2);
        webview.setWebViewClient(new Mywebview());
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webview.loadDataWithBaseURL("",table_str,"html/text","utf-8","");
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
}

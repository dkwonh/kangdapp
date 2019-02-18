package kangwon.cs.kangdapp;

import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by KHJ on 2016-10-30.
 */
public class CalendarParser {
    private final String TAG = "TAG";
    protected ArrayList<ListData> mList = new ArrayList<>();
    protected String string = "";
    protected String tmp = "";
    protected String dup = "";
    protected String temp = "";
    JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
    int getInt;
    WebView webview;

    public CalendarParser(WebView w, int index){
        this.getInt = index;
        this.webview = w;
    }

    protected class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                Document doc;
                if(getInt < 7)
                    doc = Jsoup.connect("http://home.kangwon.ac.kr/main/html/campuslife/academic_01.jsp").maxBodySize(0).timeout(15000).get();
                else
                    doc = Jsoup.connect("http://home.kangwon.ac.kr/main/html/campuslife/academic_02.jsp").maxBodySize(0).timeout(15000).get();

                Elements links = doc.select("html > body > div#center_full > div#center > div#content > div.calendar");

                for(Element link : links)
                    tmp += link.toString();

                //string = string.substring(string.indexOf("<li class=\"calendar_right_con_01\">") + 34, )
                for(int i = 0; i < (getInt >= 7 ? getInt - 6 : getInt); i++) {
                    tmp = "<table border=\"1\" cellspacing=\"0\" cellpadding=\"1\" width=\"100%\">    <tbody>    <tr>    <td width=\"60\" align=\"CENTER\">" +
                            tmp.substring(tmp.indexOf("<li class=\"calendar_right_con_01\">") + 34, tmp.indexOf("<li class=\"calendar_right_con_02\">") - 9) + "</td>    <td>" +
                            tmp.substring(tmp.indexOf("<li class=\"calendar_right_con_02\">") + 34, tmp.indexOf("</div>") - 19) + "</td>    </tr>    </tbody>    </table>" +
                            tmp.substring(tmp.indexOf("</div>") - 11, tmp.length());
                    temp = tmp.substring(0, tmp.indexOf("</div>") - 12);
                    tmp = tmp.substring(tmp.indexOf("</div>") + 6);
                }
                dup = temp.substring(temp.indexOf("align=\"CENTER\">") + 17, temp.indexOf("align=\"CENTER\">") + 18);
                while(dup.equals(temp.substring(temp.indexOf("<br>") - 3, temp.indexOf("<br>") - 2))) {
                    string = string + temp.substring(0, temp.indexOf("<br>") - 5) + temp.substring(temp.indexOf("<br>") - 2, temp.indexOf("<br>") + 4);
                    temp = temp.substring(temp.indexOf("<br>") + 4, temp.length());
                }
                string = string + temp;
                Log.d(TAG, "dup : " + dup + " ind : " + string.substring(string.indexOf("<br>") - 5, string.indexOf("<br>") - 2) + " string : " + string);
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            webview.loadDataWithBaseURL("",string,"html/text","utf-8","");
        }
    }
}

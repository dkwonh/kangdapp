package kangwon.cs.kangdapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Sunmin on 2016-10-19.
 */
public class ProfessorList extends AppCompatActivity{
    String TAG = "TAG";
    String url;
    ProfessorAdapter professorAdapter;
    ListView proList;
    private ProgressBar p_progress;
    private WebView webView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professor_list);

        proList= (ListView)findViewById(R.id.pro_list);
        professorAdapter = new ProfessorAdapter(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        setTitle(intent.getStringExtra("title"));

        p_progress = (ProgressBar) findViewById(R.id.ppgressbar1);
        proList.setAdapter(professorAdapter);
        soupAsyncTask jsoupAsyncTask = new soupAsyncTask();
        jsoupAsyncTask.execute();
    }

    protected class soupAsyncTask extends AsyncTask<Void, Void, Void> {
        String str = "";
        String src = "";
        String s;
        String t;
        String r;
        ArrayList<ProData> professor = new ArrayList<>();
        Bitmap mIcon11 = null;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            p_progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                Document doc = Jsoup.connect(url).maxBodySize(0).timeout(15000).get();
                //Log.d(TAG,"doc size : " + doc);
                Elements links = doc.select("#center_full #center #content div.knu_pro_div");
                for (Element link : links) {
                    src = link.getElementsByAttribute("src").attr("abs:src");
                    InputStream in = new java.net.URL(src).openStream();
                    mIcon11 = BitmapFactory.decodeStream(in);
                    if(link.getAllElements().get(7).text().substring(1).equals("명"))
                        s = "없음";
                    else
                        s = link.getAllElements().get(7).text().substring(3);
                    if(link.getAllElements().get(10).text().substring(3).equals("편"))
                        t = "없음";
                    else
                        t = link.getAllElements().get(10).text().substring(5);
                    if(link.getAllElements().get(13).text().substring(7).equals("호"))
                        r = "없음";
                    else
                        r = link.getAllElements().get(13).text().substring(9);
                    professor.add(new ProData(mIcon11,s,t,r));
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            for(ProData p : professor)
            professorAdapter.addItem(p.img,p.name,p.email,p.number);
            p_progress.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();

        switch(id){
            case R.id.action_button:
                Intent intentHome = new Intent(this, MainActivity.class);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intentHome);
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



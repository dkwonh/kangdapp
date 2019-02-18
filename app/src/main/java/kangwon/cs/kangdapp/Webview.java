package kangwon.cs.kangdapp;

import android.Manifest;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by WH on 2016-06-28.
 */
public class Webview extends AppCompatActivity {
    String TAG = "TAG";
    String url;
    String title="ddw";
    private ProgressBar m_progress;
    WebView webView;
    String htmlFormat = "<tr>\n";
    ListView dwList;
    DrawerLayout drLayout;
    FrameLayout frLayout;
    RelativeLayout reLayout;
    ActionBarDrawerToggle dToggle;
    ArrayList<DownData> downLoad;
    ArrayAdapter<String> dAdapter;
    private DownloadManager downloadManager;
    private DownloadManager.Request request;
    private Uri urlToDownload;
    boolean b;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        frLayout = (FrameLayout)findViewById(R.id.web_container);
        reLayout = (RelativeLayout)findViewById(R.id.web_downcontainer);
        drLayout = (DrawerLayout)findViewById(R.id.dw_drawer);
        dwList = (ListView)findViewById(R.id.dwlist);

        dAdapter = new ArrayAdapter<>(this,R.layout.down_list);

        downLoad = new ArrayList<>();
        dwList.setAdapter(dAdapter);

        downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);

        dwList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                if(permissionCheck()==PackageManager.PERMISSION_DENIED)
                {
                    if(!b) {
                        Toast.makeText(getApplication(), "파일을 다운 받으시려면 권한을 설정해주세요.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent();
                        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        i.addCategory(Intent.CATEGORY_DEFAULT);
                        i.setData(Uri.parse("package:" + "kangwon.cs.kangdapp"));
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        startActivity(i);
                    }
                }else {
                    DownData mData = downLoad.get(position);
                    String selURL = mData.durl;
                    String seltext = mData.dtext;

                    urlToDownload = Uri.parse(selURL);
                    request = new DownloadManager.Request(urlToDownload);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, seltext);
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdirs();
                    downloadManager.enqueue(request);
                    //Toast toast = Toast.makeText(getApplicationContext(),selURL,Toast.LENGTH_SHORT);toast.show();
                }
            }
        });



        dToggle = new ActionBarDrawerToggle(this, drLayout,
                R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerClosed(View drawerView){super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView){super.onDrawerOpened(drawerView);
            }
        };
        drLayout.setDrawerListener(dToggle);
        setTitle(title);


        webView = (WebView)findViewById(R.id.webView);
        m_progress = (ProgressBar)findViewById(R.id.progressBar);
        webView.setWebViewClient(new Mywebview());

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        JJsoupAsyncTask jsoupAsyncTask = new JJsoupAsyncTask();
        jsoupAsyncTask.execute();


    }

    int permissionCheck(){
        int permissionCheck = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        b = ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permissionCheck== PackageManager.PERMISSION_DENIED) {
            if (b) {
                Log.d("WRITEEXTERNALSTORAGE : ","NEED_PERMISSION");
                ActivityCompat.requestPermissions(
                        this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            } else {
                ActivityCompat.requestPermissions(
                        this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }

        return ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private BroadcastReceiver completeReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "다운로드가 완료되었습니다.",Toast.LENGTH_SHORT).show();
        }

    };
    @Override
    public void onPause(){
        super.onPause();
        unregisterReceiver(completeReceiver);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onResume(){
        super.onResume();
        IntentFilter completeFilter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        registerReceiver(completeReceiver, completeFilter);
    }

    public class Mywebview extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon){
            super.onPageStarted(view,url,favicon);
            m_progress.setVisibility(View.VISIBLE);
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
            m_progress.setVisibility(View.INVISIBLE);
        }
    }

    protected class JJsoupAsyncTask extends AsyncTask<Void, Void, Void>{
        String downtext;
        String downurl;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void...params){
            try{
                Document doc = Jsoup.connect(url).maxBodySize(0).timeout(15000).get();
                //Log.d(TAG,"doc size : " + doc);
                Elements links = doc.select("html body form table tbody tr td.board_view_con_line_01 [href]");
                Elements tlinks = doc.select("html body form table#cont_t tbody tr td.board_view_con_line_03");

                for(Element tlink : tlinks)
                    htmlFormat += tlink;
                if(links.text().equals(""))
                    downLoad.add(new DownData("첨부파일이 없습니다.",""));
                for (Element link : links) {
                    downtext = link.text();
                    downurl = link.attr("abs:href");
                    downLoad.add(new DownData(downtext,downurl));
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            htmlFormat += "</tr>\n";
            webView.loadDataWithBaseURL("",htmlFormat,"html/text","utf-8","");
            for(DownData d : downLoad){
                dAdapter.add(d.dtext);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_down_web,menu);
        return true;
    }

    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        dToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        dToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();
        switch(id){
            case R.id.down:
                if(drLayout.isDrawerOpen(reLayout))
                    drLayout.closeDrawer(reLayout);
                else
                    drLayout.openDrawer(reLayout);
                break;
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
    @Override
    public void onBackPressed(){
        if(drLayout.isDrawerOpen(reLayout)){
            drLayout.closeDrawer(reLayout);
        }
        else{
            super.onBackPressed();
        }
    }

    public class DownData {
        String dtext;
        String durl;

        DownData(String text, String url){
            this.dtext = text;
            this.durl = url;
        }
    }

}

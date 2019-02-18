package kangwon.cs.kangdapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by WH on 2016-10-21.
 */
public class ChWebView extends AppCompatActivity {
    WebView webView;
    ProgressBar m_progress;
    String htmlu;
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.ch_home);
        setTitle("총 학생회");
        htmlu = "http://m.knuch.com/m/";
        webView = (WebView)findViewById(R.id.webView10);
        m_progress = (ProgressBar)findViewById(R.id.progressBar16);

        webView.setWebViewClient(new Mywebview());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.setInitialScale(100);

        webView.loadUrl(htmlu);
    }

    /*public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/

    public class Mywebview extends WebViewClient {
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
}

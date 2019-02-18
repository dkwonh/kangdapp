package kangwon.cs.kangdapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WH on 2016-10-31.
 */
public class LivingMenuFragment extends Fragment {
    TextView webViewmorning, webViewlunch, webViewdeener;
    ArrayList<String> detail;
    int position;

    public static LivingMenuFragment newInstance2(int i, ArrayList<String> detail){
        LivingMenuFragment f = new LivingMenuFragment();
        Bundle args = new Bundle();
        args.putInt("position",i);
        args.putStringArrayList("detail",detail);
        f.setArguments(args);
        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("position", 0);
    }
    public ArrayList<String> getDetail(){return getArguments().getStringArrayList("detail");}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.living_fragment, container, false);
        if((position = getShownIndex())!=0)
            position = position*3;

        detail = getDetail();

        webViewmorning = (TextView)v.findViewById(R.id.morning);
        webViewlunch = (TextView)v.findViewById(R.id.lunch);
        webViewdeener = (TextView)v.findViewById(R.id.deener);

        webViewmorning.setText(detail.get(position));
        webViewlunch.setText(detail.get(1+position));
        webViewdeener.setText(detail.get(2+position));

        return v;
}
}

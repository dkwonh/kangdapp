package kangwon.cs.kangdapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WH on 2016-11-05.
 */

public class BackrocMenuFragment extends Fragment {
    protected ProgressBar progressBar;
    TextView fast_nomal, fast_tang, lunch_lunch, lunch_nomal, lunch_special, deener_nomal, deener_special;
    int position;
    ArrayList<String> detail;

    public static BackrocMenuFragment newInstance(int i, ArrayList<String> list){
        BackrocMenuFragment f = new BackrocMenuFragment();
        Bundle args = new Bundle();
        args.putInt("position",i);
        args.putStringArrayList("detail",list);
        f.setArguments(args);
        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("position", 0);
    }
    public ArrayList<String> getDetailList(){return getArguments().getStringArrayList("detail");}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.backroc_fragment, container, false);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar2);
        position = getShownIndex();
        detail = getDetailList();

        fast_nomal = (TextView)v.findViewById(R.id.fast_namal1);
        fast_tang = (TextView)v.findViewById(R.id.fast_tang1);
        lunch_lunch = (TextView)v.findViewById(R.id.lunch_lunch1);
        lunch_nomal = (TextView)v.findViewById(R.id.lunch_nomal1);
        lunch_special = (TextView)v.findViewById(R.id.lunch_special1);
        deener_special = (TextView)v.findViewById(R.id.deener_nomal1);
        deener_nomal = (TextView)v.findViewById(R.id.deener_deener1);

        fast_nomal.setText(detail.get(8+position));
        fast_tang.setText(detail.get(15+position));
        lunch_lunch.setText(detail.get(23+position));
        lunch_nomal.setText(detail.get(30+position));
        lunch_special.setText(detail.get(37+position));
        deener_nomal.setText(detail.get(45+position));
        deener_special.setText(detail.get(52+position));


        return v;
    }
}


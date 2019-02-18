package kangwon.cs.kangdapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebView;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WH on 2016-10-30.
 */
public class MenuFragment extends Fragment {
    protected ProgressBar progressBar;
    TextView fast_nomal, fast_tang, lunch_lunch, lunch_nomal, lunch_special, deener_deener, deener_nomal, deener_special, yang, snack;
    int position;
    ArrayList<String> dayList;
    public static MenuFragment newInstance(int i, ArrayList<String> detail){
        MenuFragment f = new MenuFragment();
        Bundle args = new Bundle();
        args.putStringArrayList("detail",detail);
        args.putInt("position",i);
        f.setArguments(args);
        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("position", 0);
    }
    public ArrayList<String> getDaylList(){return getArguments().getStringArrayList("detail");}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.week_menu, container, false);
        v.setVisibility(View.INVISIBLE);
        position = getShownIndex();
        dayList = getDaylList();
        fast_nomal = (TextView)v.findViewById(R.id.fast_namal);
        fast_tang = (TextView)v.findViewById(R.id.fast_tang);
        lunch_lunch = (TextView)v.findViewById(R.id.lunch_lunch);
        lunch_nomal = (TextView)v.findViewById(R.id.lunch_nomal);
        lunch_special = (TextView)v.findViewById(R.id.lunch_special);
        deener_special = (TextView)v.findViewById(R.id.deener_special);
        deener_deener = (TextView)v.findViewById(R.id.deener_deener);
        deener_nomal = (TextView)v.findViewById(R.id.deener_nomal);
        yang = (TextView)v.findViewById(R.id.yang);
        snack = (TextView)v.findViewById(R.id.snack);
        Log.d("TAGGGGGG","DayList : " + dayList);

        setTEXT();

        v.setVisibility(View.VISIBLE);
        return v;
    }

    public void setTEXT(){
        if(dayList==null) {
            Log.d("NULL_", "DayList is NULL");
        }
        else {
            fast_nomal.setText(dayList.get(8 + position));
            fast_tang.setText(dayList.get(15 + position));
            lunch_lunch.setText(dayList.get(23 + position));
            lunch_nomal.setText(dayList.get(30 + position));
            lunch_special.setText(dayList.get(37 + position));
            deener_deener.setText(dayList.get(45 + position));
            deener_nomal.setText(dayList.get(52 + position));
            deener_special.setText(dayList.get(59 + position));
        }
    }
}

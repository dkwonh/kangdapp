package kangwon.cs.kangdapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by WH on 2016-10-30.
 */
public class TPAMenu extends FragmentStatePagerAdapter {
    private int tabCount;
    private ArrayList<String> day;

    public TPAMenu(FragmentManager fm, int tabCount, ArrayList<String> day) {
        super(fm);
        this.tabCount = tabCount;
        this.day = day;
    }

    public android.support.v4.app.Fragment getItem(int position) {
        Log.d("TAG", "Fragment Change");
        // Returning the current tabs
        switch (position) {
            case 0:
                MenuFragment tabFragment1 = new MenuFragment().newInstance(0,day);
                return tabFragment1;
            case 1:
                MenuFragment tabFragment2 = new MenuFragment().newInstance(1,day);
                return tabFragment2;

            case 2:
                MenuFragment tabFragment3 = new MenuFragment().newInstance(2,day);
                return tabFragment3;
            case 3:
                MenuFragment tabFragment4 = new MenuFragment().newInstance(3,day);
                return tabFragment4;
            case 4:
                MenuFragment tabFragment5 = new MenuFragment().newInstance(4,day);
                return tabFragment5;
            case 5:
                MenuFragment tabFragment6 = new MenuFragment().newInstance(5,day);
                return tabFragment6;
            default:
                return null;
        }
    }

    public int getCount() {
        return tabCount;
    }
}

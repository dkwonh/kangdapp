package kangwon.cs.kangdapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by WH on 2016-11-05.
 */

public class TPABackroc extends FragmentStatePagerAdapter {
    private int tabCount;
    private ArrayList<String> detail;

    public TPABackroc(FragmentManager fm, int tabCount, ArrayList<String> detail) {
        super(fm);
        this.tabCount = tabCount;
        this.detail = detail;
    }

    public android.support.v4.app.Fragment getItem(int position) {
        Log.d("TAG", "Fragment Change");
        // Returning the current tabs
        switch (position) {
            case 0:
                BackrocMenuFragment tabFragment1 = new BackrocMenuFragment().newInstance(0,detail);
                return tabFragment1;
            case 1:
                BackrocMenuFragment tabFragment2 = new BackrocMenuFragment().newInstance(1,detail);
                return tabFragment2;

            case 2:
                BackrocMenuFragment tabFragment3 = new BackrocMenuFragment().newInstance(2,detail);
                return tabFragment3;
            case 3:
                BackrocMenuFragment tabFragment4 = new BackrocMenuFragment().newInstance(3,detail);
                return tabFragment4;
            case 4:
                BackrocMenuFragment tabFragment5 = new BackrocMenuFragment().newInstance(4,detail);
                return tabFragment5;
            case 5:
                BackrocMenuFragment tabFragment6 = new BackrocMenuFragment().newInstance(5,detail);
                return tabFragment6;
            default:
                return null;
        }
    }

    public int getCount() {
        return tabCount;
    }
}
package kangwon.cs.kangdapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by WH on 2016-10-31.
 */
public class TPALivingMenu extends FragmentStatePagerAdapter {
    private int tabCount;
    private ArrayList<String> child;
    public TPALivingMenu(FragmentManager fm, int tabCount, ArrayList<String> child) {
        super(fm);
        this.tabCount = tabCount;
        this.child = child;
    }

    public android.support.v4.app.Fragment getItem(int position) {
        Log.d("TAG", "Fragment Change");
        // Returning the current tabs
        switch (position) {
            case 0:
                LivingMenuFragment tabFragment1 = new LivingMenuFragment().newInstance2(0,child);
                return tabFragment1;
            case 1:
                LivingMenuFragment tabFragment2 = new LivingMenuFragment().newInstance2(1,child);
                return tabFragment2;
            case 2:
                LivingMenuFragment tabFragment3 = new LivingMenuFragment().newInstance2(2,child);
                return tabFragment3;
            case 3:
                LivingMenuFragment tabFragment4 = new LivingMenuFragment().newInstance2(3,child);
                return tabFragment4;
            case 4:
                LivingMenuFragment tabFragment5 = new LivingMenuFragment().newInstance2(4,child);
                return tabFragment5;
            case 5:
                LivingMenuFragment tabFragment6 = new LivingMenuFragment().newInstance2(5,child);
                return tabFragment6;
            case 6:
                LivingMenuFragment tabFragment7 = new LivingMenuFragment().newInstance2(6,child);
                return tabFragment7;
            default:
                return null;
        }
    }

    public int getCount() {
        return tabCount;
    }
}

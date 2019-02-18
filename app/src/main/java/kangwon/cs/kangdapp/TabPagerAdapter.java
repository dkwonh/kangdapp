package kangwon.cs.kangdapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by WH on 2016-09-06.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                Bundle args1 = new Bundle();
                TabFragment1 tabFragment1 = new TabFragment1();
                tabFragment1.setArguments(args1);
                return tabFragment1;
            case 1:
                Bundle args2 = new Bundle();
                TabFragment2 tabFragment2 = new TabFragment2();
                tabFragment2.setArguments(args2);
                return tabFragment2;
            case 2:
                Bundle args3 = new Bundle();
                TabFragment3 tabFragment3 = new TabFragment3();
                tabFragment3.setArguments(args3);
                return tabFragment3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

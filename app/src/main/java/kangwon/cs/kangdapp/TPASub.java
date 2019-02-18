package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by WH on 2016-09-22.
 */
public class TPASub extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TPASub(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("TAG","Fragment Change");
        // Returning the current tabs
        switch (position) {
            case 0:
                Sub_kuyngchun tabFragment1 = new Sub_kuyngchun();
                return tabFragment1;
            case 1:
                Sub_ITX tabFragment2 = new Sub_ITX();
                return tabFragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
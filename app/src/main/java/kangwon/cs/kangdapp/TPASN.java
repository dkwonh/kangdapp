package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;

/**
 * Created by WH on 2016-09-06.
 */
public class TPASN extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TPASN(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        // Returning the current tabs
        switch (position) {
            case 0:
                Notice1 tabFragment1 = new Notice1();
                return tabFragment1;
            case 1:
                Notice2 tabFragment2 = new Notice2();
                return tabFragment2;
            case 2:
                Notice3 tabFragment3 = new Notice3();
                return tabFragment3;
            case 3:
                Notice4 tabFragment4 = new Notice4();
                return tabFragment4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

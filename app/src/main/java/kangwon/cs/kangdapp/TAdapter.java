package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Sunmin on 2016-09-23.
 */
public class TAdapter extends FragmentStatePagerAdapter {

    //Count number of tabs

    private int tabCount;

    public TAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        //Returning the current tabs
        switch (position) {
            case 0:
                TAdapter1 tabFragment1 = new TAdapter1();
                return tabFragment1;
            case 1:
                TAdapter2 tabFragment2 = new TAdapter2();
                return tabFragment2;
            case 2:
                TAdapter3 tabFragment3 = new TAdapter3();
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
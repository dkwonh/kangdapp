package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by KHJ on 2016-10-30.
 */
public class TPAC extends FragmentStatePagerAdapter {
    private int tabCount;
    public TPAC(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    public Fragment getItem(int position) {
        Log.d("TAG", "Fragment Change");
        // Returning the current tabs
        switch (position) {
            case 0:
                SchoolCalendarFragment tabFragment1 = new SchoolCalendarFragment().newInstance(0);
                return tabFragment1;

            case 1:
                SchoolCalendarFragment tabFragment2 = new SchoolCalendarFragment().newInstance(1);
                return tabFragment2;

            case 2:
                SchoolCalendarFragment tabFragment3 = new SchoolCalendarFragment().newInstance(2);
                return tabFragment3;

            case 3:
                SchoolCalendarFragment tabFragment4 = new SchoolCalendarFragment().newInstance(3);
                return tabFragment4;

            case 4:
                SchoolCalendarFragment tabFragment5 = new SchoolCalendarFragment().newInstance(4);
                return tabFragment5;

            case 5:
                SchoolCalendarFragment tabFragment6 = new SchoolCalendarFragment().newInstance(5);
                return tabFragment6;

            case 6:
                SchoolCalendarFragment tabFragment7 = new SchoolCalendarFragment().newInstance(6);
                return tabFragment7;

            case 7:
                SchoolCalendarFragment tabFragment8 = new SchoolCalendarFragment().newInstance(7);
                return tabFragment8;

            case 8:
                SchoolCalendarFragment tabFragment9 = new SchoolCalendarFragment().newInstance(8);
                return tabFragment9;

            case 9:
                SchoolCalendarFragment tabFragment10 = new SchoolCalendarFragment().newInstance(9);
                return tabFragment10;

            case 10:
                SchoolCalendarFragment tabFragment11 = new SchoolCalendarFragment().newInstance(10);
                return tabFragment11;

            case 11:
                SchoolCalendarFragment tabFragment12 = new SchoolCalendarFragment().newInstance(11);
                return tabFragment12;

            case 12:
                SchoolCalendarFragment tabFragment13 = new SchoolCalendarFragment().newInstance(12);
                return tabFragment13;

            default:
                return null;
        }
    }

    public int getCount() {
        return tabCount;
    }
}

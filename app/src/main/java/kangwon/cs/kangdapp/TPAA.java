package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by KHJ on 2016-10-15.
 */
public class TPAA extends FragmentStatePagerAdapter {
    private int tabCount;

    public TPAA(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    public Fragment getItem(int position) {
        Log.d("TAG", "Fragment Change");
        // Returning the current tabs
        switch (position) {
            case 0:
                SchoolAdministration1 tabFragment1 = new SchoolAdministration1();
                return tabFragment1;

            case 1:
                SchoolAdministration2 tabFragment2 = new SchoolAdministration2();
                return tabFragment2;

            case 2:
                SchoolAdministration3 tabFragment3 = new SchoolAdministration3();
                return tabFragment3;

            case 3:
                SchoolAdministration4 tabFragment4 = new SchoolAdministration4();
                return tabFragment4;

            case 4:
                SchoolAdministration5 tabFragment5 = new SchoolAdministration5();
                return tabFragment5;

            default:
                return null;
        }
    }

    public int getCount() {
        return tabCount;
    }
}

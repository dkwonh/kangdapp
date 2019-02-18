package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by KHJ on 2016-09-10.
 */
public class TPAL extends FragmentStatePagerAdapter {
    private int tabCount;

    public TPAL(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    public Fragment getItem(int position) {
        Log.d("TAG", "Fragment Change");
        // Returning the current tabs
        switch (position) {
            case 0:
                LibraryNotice tabFragment1 = new LibraryNotice();
                return tabFragment1;

            case 1:
                LibraryBookSearch tabFragment2 = new LibraryBookSearch();
                return tabFragment2;

            case 2:
                LibraryReadingRoom tabFragment3 = new LibraryReadingRoom();
                return tabFragment3;

            default:
                return null;
        }
    }

    public int getCount() {
        return tabCount;
    }
}

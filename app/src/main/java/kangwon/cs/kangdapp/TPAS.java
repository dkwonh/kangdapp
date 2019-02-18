package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by KHJ on 2016-10-15.
 */
public class TPAS extends FragmentStatePagerAdapter{
    private int tabCount;

    public TPAS(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    public Fragment getItem(int position) {
        Log.d("TAG", "Fragment Change");
        // Returning the current tabs
        switch (position) {
            case 0:
                ScholarIn tabFragment1 = new ScholarIn();
                return tabFragment1;

            case 1:
                ScholarOut tabFragment2 = new ScholarOut();
                return tabFragment2;

            case 2:
                ScholarStudentLoans tabFragment3 = new ScholarStudentLoans();
                return tabFragment3;

            default:
                return null;
        }
    }

    public int getCount() {
        return tabCount;
    }
}

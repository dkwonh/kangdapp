package kangwon.cs.kangdapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Sunmin on 2016-10-10.
 */
public class NumAdapter extends FragmentStatePagerAdapter{
    //Count number of tabs
    private int tabCount;
    public NumAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }
    @Override
    public Fragment getItem(int position){
        //Returning the current tabs
        switch (position) {
            case 0:
                Num1 tab1 = new Num1();
                return tab1;
            case 1:
                Num2 tab2 = new Num2();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public  int getCount() {
        return tabCount;
    }
}
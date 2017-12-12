package iniris.com.numaricalanalysis;

/**
 * Created by AbdulRuhman on 11/20/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import iniris.com.numaricalanalysis.fragments.ModifiedNewton;
import iniris.com.numaricalanalysis.fragments.NewtonMethod;
import iniris.com.numaricalanalysis.fragments.Secant;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MainPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

       switch (position) {
            case 0:
                Fragment tab5 = new NewtonMethod();
                return tab5;
            case 1:
                Fragment tab3 =  new Secant();
                return tab3;
            case 2:
                Fragment tab2 = new ModifiedNewton();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
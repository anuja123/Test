package app.sante.com.sante.view.acitivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by User on 4/29/2015.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {

                case 0 :
                    return new BarsAndPubsFragment();
                case 1 :
                    return new NightClubsFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

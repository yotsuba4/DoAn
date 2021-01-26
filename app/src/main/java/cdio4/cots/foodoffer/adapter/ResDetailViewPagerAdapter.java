package cdio4.cots.foodoffer.adapter;

import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import cdio4.cots.foodoffer.ui.restaurant.DetailFragment;
import cdio4.cots.foodoffer.ui.restaurant.MenuFragment;
import cdio4.cots.foodoffer.ui.restaurant.RateFragment;

public class ResDetailViewPagerAdapter extends FragmentStatePagerAdapter {

    public ResDetailViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MenuFragment();
            case 1:
                return new DetailFragment();
            case 2:
                return new RateFragment();
            default:
                return new MenuFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title="MENU";
                break;
            case 1:
                title="THÔNG TIN";
                break;
            case 2:
                title="BÌNH LUẬN";
                break;
        }
        return title;
    }
}

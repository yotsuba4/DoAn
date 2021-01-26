package cdio4.cots.foodoffer.ui.HomeFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import cdio4.cots.foodoffer.ui.HomeFragment.Fragment.Favorite.FavoriteFragment;
import cdio4.cots.foodoffer.ui.HomeFragment.Fragment.Hot.HotFragment;
import cdio4.cots.foodoffer.ui.HomeFragment.Fragment.Notification.NotificationFragment;
import cdio4.cots.foodoffer.ui.HomeFragment.Fragment.SaleCode.SaleCodeFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HotFragment();
            case 1:
                return new FavoriteFragment();
            case 2:
                return new SaleCodeFragment();
            case 3:
                return new NotificationFragment();
            default:
                return new HotFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
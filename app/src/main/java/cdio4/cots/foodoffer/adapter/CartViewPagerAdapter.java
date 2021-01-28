package cdio4.cots.foodoffer.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import cdio4.cots.foodoffer.ui.cart.CartFragment;
import cdio4.cots.foodoffer.ui.cart.DetailFragment;
import cdio4.cots.foodoffer.ui.cart.HistoryFragment;

public class CartViewPagerAdapter extends FragmentStatePagerAdapter {
    public CartViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CartFragment();

            case 1:
                return new DetailFragment();

            case 2:
                return new HistoryFragment();

            default:
                return new CartFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

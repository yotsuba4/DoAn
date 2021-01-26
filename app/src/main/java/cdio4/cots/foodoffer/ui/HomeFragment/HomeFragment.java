package cdio4.cots.foodoffer.ui.HomeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cdio4.cots.foodoffer.R;

public class HomeFragment extends Fragment {

    //private HomeViewModel mViewModel;
    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private View mView;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.home_fragment, container, false);
        init();
        return mView;
    }

    private void init() {
        mViewPager=mView.findViewById(R.id.vp_home_fragment);
        mBottomNavigationView=mView.findViewById(R.id.bot_nav_home_fragment);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab_hot:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.tab_favorite:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.tab_sale_code:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.tab_notification:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.tab_hot).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.tab_favorite).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.tab_sale_code).setChecked(true);
                        break;
                    case 3:
                        mBottomNavigationView.getMenu().findItem(R.id.tab_notification).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
package cdio4.cots.foodoffer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.palette.graphics.Palette;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import cdio4.cots.foodoffer.adapter.ResDetailViewPagerAdapter;


public class RestaurantDetailActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ResDetailViewPagerAdapter mViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        initToolbar();
        init();
    }

    private void init() {
        mTabLayout=findViewById(R.id.tablayout_res_detail_activity);
        mViewPager=findViewById(R.id.viewpager_res_detail_activity);
        mViewPagerAdapter = new ResDetailViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        setTabLayOutAnimation();
    }

    private void setTabLayOutAnimation() {
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout_res_detail_activity);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image_head);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int myColor=palette.getVibrantColor(getResources().getColor(R.color.teal_700));
                int myDarkColor=palette.getVibrantColor(getResources().getColor(R.color.black_trans));
                collapsingToolbarLayout.setContentScrimColor(myColor);
                collapsingToolbarLayout.setStatusBarScrimColor(myDarkColor);
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_res_detail_activity);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
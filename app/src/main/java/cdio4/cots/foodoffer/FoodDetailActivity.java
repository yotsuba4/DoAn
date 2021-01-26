package cdio4.cots.foodoffer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Timer;
import java.util.TimerTask;

public class FoodDetailActivity extends AppCompatActivity {

    /*    TextView foodName;
        Intent intent;*/
    Intent intent;
    RequestOptions option;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ProgressBar progressBar;
    private ImageView foodImage;
    private TextView foodPrice;
    private TextView foodDesc;
    private Button foodRes;
    private ImageButton cartFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        init();
        setupActionBar();
      /*  foodName=findViewById(R.id.tv_food_detail_activity_food_name);
        intent=getIntent();
        String name = intent.getStringExtra("FoodName");
        foodName.setText(name);*/
    }

    private void init() {
        intent=getIntent();
        progressBar=findViewById(R.id.progressBar);
        toolbar = findViewById(R.id.toolbar_food_detail_activity);
        appBarLayout = findViewById(R.id.appbar);
        foodRes = findViewById(R.id.btn_food_detail_activity_food_res);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        foodImage = findViewById(R.id.imgv_food_detail_activity_food_name);
        foodPrice = findViewById(R.id.tv_food_detail_activity_food_price);
        foodDesc = findViewById(R.id.instructions);
        cartFood=findViewById(R.id.btn_food_detail_activity_add_cart);
        String fName = intent.getStringExtra("FoodName");
        String fPrice = intent.getStringExtra("Price");
        String fDesc = intent.getStringExtra("Describe");
        String fRes = intent.getStringExtra("FoodRes");
        String fURL = intent.getStringExtra("FoodURL");
        collapsingToolbarLayout.setTitle(fName);
        foodPrice.setText(fPrice);
        foodDesc.setText(fDesc);
        foodRes.setText(fRes);
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        Glide.with(this)
                .load(fURL)
                .apply(option)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(foodImage);
        cartFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodDetailActivity.this, CartActivity.class));
            }
        });
        foodRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodDetailActivity.this, RestaurantDetailActivity.class));
            }
        });
        /*foodPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodDetailActivity.this, CartActivity.class));

            }
        });*/
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.teal_700));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void setupColorActionBarIcon(Drawable favoriteItemColor) {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if ((collapsingToolbarLayout.getHeight() + verticalOffset) < (2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout))) {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.teal_700), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.teal_700),
                        PorterDuff.Mode.SRC_ATOP);

            } else {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.white),
                        PorterDuff.Mode.SRC_ATOP);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem favoriteItem = menu.findItem(R.id.favorite);
        Drawable favoriteItemColor = favoriteItem.getIcon();
        setupColorActionBarIcon(favoriteItemColor);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
package cdio4.cots.foodoffer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

import cdio4.cots.foodoffer.constance.JSONKEY;

public class FoodDetailActivity extends AppCompatActivity implements JSONKEY {
    private Intent intent;
    private RequestOptions option;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ProgressBar progressBar;
    private ImageView img_foodImage;
    private TextView tv_foodPrice;
    private TextView tv_foodDesc;
    private Button btn_tranferRestaurant;
    private ImageButton ibtn_foodBuyNow;
    private String id = "";
    private String sl = "0";

    private String restauranID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        initLayout();
        setupActionBar();
    }

    private void initLayout() {
        intent=getIntent();
        progressBar=findViewById(R.id.progressBar);
        toolbar = findViewById(R.id.toolbar_food_detail_activity);
        appBarLayout = findViewById(R.id.appbar);
        btn_tranferRestaurant = findViewById(R.id.btn_food_detail_activity_food_res);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        img_foodImage = findViewById(R.id.imgv_food_detail_activity_food_name);
        tv_foodPrice = findViewById(R.id.tv_food_detail_activity_food_price);
        tv_foodDesc = findViewById(R.id.instructions);
        ibtn_foodBuyNow =findViewById(R.id.btn_food_detail_activity_add_cart);
        String foodName = intent.getStringExtra("FoodName");
        String foodPrice = intent.getStringExtra("Price");
        String foodDescribe = intent.getStringExtra("Describe");
        String restaurantName = intent.getStringExtra("FoodRes_Name");
        restauranID = intent.getStringExtra("FoodRes_ID");
        String foodImage = intent.getStringExtra("FoodURL");
        collapsingToolbarLayout.setTitle(foodName);
        tv_foodPrice.setText(foodPrice);
        tv_foodDesc.setText(foodDescribe);
        btn_tranferRestaurant.setText(restaurantName);

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        Glide.with(this)
                .load(foodImage)
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
                .into(img_foodImage);
        ibtn_foodBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(FoodDetailActivity.this, BillDetailActivity.class);

                startActivity(intent); 
            }
        });
        btn_tranferRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(FoodDetailActivity.this, RestaurantDetailActivity.class);
                intent.putExtra("restaurant_ID", restauranID);
                startActivity(intent);
            }
        });
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
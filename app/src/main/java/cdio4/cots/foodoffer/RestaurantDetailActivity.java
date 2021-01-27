package cdio4.cots.foodoffer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.palette.graphics.Palette;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cdio4.cots.foodoffer.adapter.ResDetailViewPagerAdapter;
import cdio4.cots.foodoffer.constance.JSONKEY;
import cdio4.cots.foodoffer.model.Account;
import cdio4.cots.foodoffer.model.Food;
import cdio4.cots.foodoffer.model.Restaurant;


public class RestaurantDetailActivity extends AppCompatActivity implements JSONKEY {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ResDetailViewPagerAdapter mViewPagerAdapter;
    private Intent intent;
    public String restaurant_ID;
    /*private List<Food> listMenu;*/

   /* private Restaurant restaurant;
    private Food food;


    private String restaurant_ID;
    private String restaurant_Name;
    private String restaurant_Image;
    private String restaurant_X;
    private String restaurant_Y;
    private String restaurant_Phone;
    private String restaurant_Email;
    private String restaurant_Adress;
    private String restaurant_Stype;

    private String food_Name;
    private Double food_Price;
    private String food_Image;

    private RequestQueue requestQueue;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        initToolbar();
        initLayout();
       // getRestaurant();

    }

    private void initLayout() {
        mTabLayout=findViewById(R.id.tablayout_res_detail_activity);
        mViewPager=findViewById(R.id.viewpager_res_detail_activity);
        mViewPagerAdapter = new ResDetailViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        setTabLayOutAnimation();

        intent = getIntent();
        restaurant_ID =  intent.getStringExtra("restaurant_ID");


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

   /* private List<Food> getRestaurant(){
         List<Food> listMenu = new ArrayList<Food>();;
        String url_getRestaurant = getResources().getString(R.string.url_GetFood) + restaurant_ID;
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_getRestaurant, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject rootRestaurant = new JSONObject(response);
                    JSONObject dataRestaurant = rootRestaurant.getJSONObject(JSON_DATA);
                    JSONObject restaurant = dataRestaurant.getJSONObject(RESTAURANT);
                    JSONObject location = restaurant.getJSONObject(LOACTION);
                    JSONObject restaurant_style = restaurant.getJSONObject(RESTAURANT_STYPE);
                    JSONArray menu = dataRestaurant.getJSONArray(MENU);
                    restaurant_X = location.getString(X);
                    restaurant_Y = location.getString(Y);
                    restaurant_Image = restaurant.getString(RESTAURANT_IMAGE);
                    restaurant_Name = restaurant.getString(RESTAURANT_NAME);
                    restaurant_Phone = restaurant.getString(RESTAURANT_PHONE);
                    restaurant_Email = restaurant.getString(RESTAURANT_EMAIL);
                    restaurant_Adress = restaurant.getString(RESTAURANT_ADRESS);
                    restaurant_Stype = restaurant_style.getString(RESTAURANT_STYPE_NAME);

                    for (int i=0; i < menu.length(); i++){
                        JSONObject foodObject = menu.getJSONObject(i);
                          food_Name= foodObject.getString(FOOD_NAME);
                          food_Image= foodObject.getString(FOOD_IMAGE);
                          food_Price= Double.valueOf(foodObject.getString(FOOD_PRICE));

                          food = new Food(food_Name,food_Price,food_Image);
                          listMenu.add(food);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
        return listMenu;
    }*/
}
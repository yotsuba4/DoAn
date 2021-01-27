package cdio4.cots.foodoffer.ui.restaurant;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.RestaurantDetailActivity;
import cdio4.cots.foodoffer.adapter.MenuResAdapter;
import cdio4.cots.foodoffer.constance.JSONKEY;
import cdio4.cots.foodoffer.model.Food;

public class MenuFragment extends Fragment implements JSONKEY {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_menu, container, false);
        list_resMenu = new ArrayList<>();
        initFragment();
        inti_listResMenu();

        return mView;
    }

    private void initFragment() {
        rcvMenu = mView.findViewById(R.id.rcv_res_menu_fragment);
        restaurantDetailActivity=(RestaurantDetailActivity) getActivity();
        intent = getActivity().getIntent();
        restaurant_ID =  intent.getStringExtra("restaurant_ID");
      //  setItemView(taoListTest());
    }

    private List<Food> taoListTest() {
        List<Food> list = new ArrayList<>();
        list.add(new Food("Trà đào cam sả",21000.0,"https://res.cloudinary.com/codersx332456/image/upload/v1611241791/nxjfo93fk8ythwjr9wvj.jpg"));
        list.add(new Food("Trà đào cam sả",21000.0,"https://res.cloudinary.com/codersx332456/image/upload/v1611241791/nxjfo93fk8ythwjr9wvj.jpg"));
        list.add(new Food("Trà đào cam sả",21000.0,"https://res.cloudinary.com/codersx332456/image/upload/v1611241791/nxjfo93fk8ythwjr9wvj.jpg"));
        list.add(new Food("Trà đào cam sả",21000.0,"https://res.cloudinary.com/codersx332456/image/upload/v1611241791/nxjfo93fk8ythwjr9wvj.jpg"));
        return list;
    }

    private void inti_listResMenu(){
        String url_getRestaurant = "https://doan5.herokuapp.com/api/user/restaurant/"+ restaurant_ID ;
        requestQueue = Volley.newRequestQueue(restaurantDetailActivity);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_getRestaurant, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject rootRestaurant = new JSONObject(response);
                    JSONObject dataRestaurant = rootRestaurant.getJSONObject(JSON_DATA);
                    JSONArray menu = dataRestaurant.getJSONArray(MENU);
                    for (int i=0; i <= menu.length(); i++){
                        JSONObject foodObject = menu.getJSONObject(i);

                        food_Name= foodObject.getString(FOOD_NAME);
                        food_Image= foodObject.getString(FOOD_IMAGE);
                        food_Price= Double.valueOf(foodObject.getString(FOOD_PRICE));

                        food = new Food(food_Name,food_Price,convertHttpToHttps(food_Image));
                        list_resMenu.add(food);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                setItemView(list_resMenu);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(restaurantDetailActivity, "Có lỗi xảy ra", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    private String convertHttpToHttps(String url) {
        return url.replace("http://", "https://");
    }

   private void setItemView(List<Food> listFood) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvMenu.setLayoutManager(linearLayoutManager);
        MenuResAdapter adapter = new MenuResAdapter(listFood, getActivity());
        rcvMenu.setAdapter(adapter);
    }

    private RecyclerView rcvMenu;
    private Intent intent;
    private View mView;
    private RestaurantDetailActivity restaurantDetailActivity;
    private RequestQueue requestQueue;


    private List<Food> list_resMenu;
    private Food food;
    private String restaurant_ID;
    private String food_Name;
    private Double food_Price;
    private String food_Image;


    public MenuFragment() {
        // Required empty public constructor
    }

}
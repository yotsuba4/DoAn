package cdio4.cots.foodoffer.ui.restaurant;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.constance.JSONKEY;
import cdio4.cots.foodoffer.model.Food;

public class DetailFragment extends Fragment  implements JSONKEY {

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_res_detail, container, false);
        InitFragment(view);
        intent = getActivity().getIntent();
        restaurant_ID = intent.getStringExtra("restaurant_ID");
        InitData();
        return view;
    }

    private void InitData() {
        String url_getRestaurant = "https://doan5.herokuapp.com/api/user/restaurant/"+ restaurant_ID ;
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                tv_restaurantName.setText(restaurant_Name);
                tv_restaurantDescribe.setText("Mô tả: "+ restaurant_Stype);
                tv_restaurantAdress.setText("Địa chỉ: "+ restaurant_Adress);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Có lỗi xảy ra", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    private void InitFragment(View view) {
        tv_restaurantName = view.findViewById(R.id.tv_fragment_res_detail_name);
        tv_restaurantDescribe = view.findViewById(R.id.tv_fragment_res_detail_describe);
        tv_restaurantAdress = view.findViewById(R.id.tv_fragment_res_detail_adress);
    }

    private View view;
    private Intent intent;
    private TextView tv_restaurantName;
    private TextView tv_restaurantDescribe;
    private TextView tv_restaurantAdress;

    private String restaurant_ID;
    private String restaurant_Name;
    private String restaurant_Image;
    private String restaurant_X;
    private String restaurant_Y;
    private String restaurant_Phone;
    private String restaurant_Email;
    private String restaurant_Adress;
    private String restaurant_Stype;
}
package cdio4.cots.foodoffer.ui.HomeFragment.Fragment.SearchBar;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cdio4.cots.foodoffer.LoginActivity;
import cdio4.cots.foodoffer.MainActivity;
import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.constance.JSONKEY;
import cdio4.cots.foodoffer.model.Food;

public class SearchBarFragment extends Fragment implements JSONKEY {

    private RequestQueue requestQueue;
    private SearchBarViewModel mViewModel;

    private View view;
    private RecyclerView lvSearch;
    private List<Food> listSearch;
    private Food food;

    private String keySearch;

    public static SearchBarFragment newInstance() {
        return new SearchBarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_bar_fragment, container, false);
        initLayout();
        return view;
    }

    private void initLayout() {

        lvSearch = view.findViewById(R.id.rcv_food_name_search_bar_fragment);
    }

    /*    @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            mViewModel = new ViewModelProvider(this).get(SearchBarViewModel.class);
            // TODO: Use the ViewModel
        }*/
    private void searchFood() {
        String urlLogin = getResources().getString(R.string.url_Login);
        requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlLogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject rootSearch = new JSONObject(response);
                    if (rootSearch.getString(JSON_STATUS).equals(JSON_SUCCESS)) {
                        JSONObject dataObject = rootSearch.getJSONObject(JSON_DATA);
                        JSONArray foodArray = dataObject.getJSONArray(FOOD_ARR);
                        for (int i = 0; i <= foodArray.length(); i++) {
                            JSONObject foodObject = foodArray.getJSONObject(i);
                            JSONObject kindObject = foodObject.getJSONObject("loai");
                            JSONObject restaurant = foodObject.getJSONObject("nhaHang");

                            String foodID = foodObject.getString("_id");
                            String foodName = foodObject.getString("tenMon");
                            String foodImage = foodObject.getString("hinhAnh");
                            String foodCaption = foodObject.getString("moTa");
                            String foodPrice = foodObject.getString("gia");
                            String kindOfFoodName = kindObject.getString("tenLoai");

                            String res_ID = restaurant.getString("_id");
                            String res_name = restaurant.getString("name");

                            food = new Food(foodID, kindOfFoodName, res_ID, res_name, foodName,
                                    Double.valueOf(foodPrice), foodCaption, convertHttpToHttps(foodImage));
                            listSearch.add(food);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_SEARCH_TYPE1, keySearch);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private String convertHttpToHttps(String url){
        return url.replace("http://", "https://");
    }
}
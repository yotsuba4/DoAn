package cdio4.cots.foodoffer.ui.HomeFragment.Fragment.Hot;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import cdio4.cots.foodoffer.MainActivity;
import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.adapter.HotFoodAdapter;
import cdio4.cots.foodoffer.adapter.PhotoAdapter;
import cdio4.cots.foodoffer.constance.JSONKEY;
import cdio4.cots.foodoffer.database.RequestAPI;
import cdio4.cots.foodoffer.model.Food;
import cdio4.cots.foodoffer.model.Photo;
import me.relex.circleindicator.CircleIndicator;

public class HotFragment extends Fragment implements JSONKEY {
    public static HotFragment newInstance() {
        return new HotFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        listFood = new ArrayList<>();
        mView= inflater.inflate(R.layout.hot_fragment, container, false);
        init();
        getFood();
       //getFood1.execute(getResources().getString(R.string.url_GetFood));
        return mView;
    }

    private void init() {

      //  listRestayrant = new ArrayList<>();
        mainActivity=(MainActivity) getActivity(); //getActivity trả về Activity chứa Fragment đang gọi, không cần thông qua home, ép kiểu về MainActivity. Cái này có thể dùng để gởi dữ liệu từ Fragment về Activity mà không cần xài interface
        rcvFood= mView.findViewById(R.id.rcv_fragment_hot_food);
        viewPager = mView.findViewById(R.id.viewpager_hot_fragment_banner);
        circleIndicator = mView.findViewById(R.id.circle_idicator_hot_fragment_banner);
        setUpBanner(getListPhoto());
    }

    private void autoSlideImage() {
        if(getListPhoto()==null||getListPhoto().isEmpty()||viewPager==null){
            return;
        }
        //Init timer
        if(mTimer==null){
            mTimer=new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = getListPhoto().size()-1;
                        if(currentItem<totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else{
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        },500,3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        super.onDestroy();
        if(mTimer!=null){
            mTimer.cancel();
            mTimer=null;
        }
    }

    private void getFood(){
        String url_getFood = getResources().getString(R.string.url_GetFood);
        requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_getFood, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonRoot = new JSONObject(response);
                    JSONObject data = jsonRoot.getJSONObject("data");
                    JSONArray foods = data.getJSONArray("foods");

                    for(int i=0; i < foods.length(); i++){
                        JSONObject foodObject = foods.getJSONObject(i);
                        JSONObject kindObject  = foodObject.getJSONObject("loai");
                        JSONObject restaurant = foodObject.getJSONObject("nhaHang");

                        String foodID = foodObject.getString("_id");
                        String foodName = foodObject.getString("tenMon");
                        String foodImage = foodObject.getString("hinhAnh");
                        String foodCaption = foodObject.getString("moTa");
                        String foodPrice = foodObject.getString("gia");
                        String kindOfFoodName = kindObject.getString("tenLoai");

                        String res_ID = restaurant.getString("_id");
                        String res_name = restaurant.getString("name");
                        String res_phone = restaurant.getString("SDT");
                        String res_email= restaurant.getString("email");
                        String res_adress= restaurant.getString("diaChi");


                        //food = new Food("","","","","","","","");


                        food = new Food(foodID,kindOfFoodName,res_ID,res_name,foodName,Double.valueOf(foodPrice),foodCaption,xulyFoodImageUrl(foodImage));

                        listFood.add(food);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                setUpRecycleView(listFood);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Lỗi kết nối Intenet", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    private void setUpBanner(List<Photo> mListPhoto) {
        mListPhoto=getListPhoto();
        photoAdapter = new PhotoAdapter(mainActivity,mListPhoto);
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSlideImage();
    }
    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo("https://images.foody.vn/res/g17/161321/prof/s576x330/foody-upload-api-foody-mobile-aroi-jpg-181108144129.jpg"));
        list.add(new Photo("https://images.foody.vn/res/g17/161321/prof/s576x330/foody-upload-api-foody-mobile-aroi-jpg-181108144129.jpg"));
        list.add(new Photo("https://images.foody.vn/res/g17/161321/prof/s576x330/foody-upload-api-foody-mobile-aroi-jpg-181108144129.jpg"));
        list.add(new Photo("https://images.foody.vn/res/g17/161321/prof/s576x330/foody-upload-api-foody-mobile-aroi-jpg-181108144129.jpg"));
        return list;
    }
    private String xulyFoodImageUrl(String foodImage) {
        String[] mangchuoi=foodImage.split(":");
        String chuoi_https=mangchuoi[0]+"s";
        String chuoi_conlai=":"+mangchuoi[1];
        String chuoimoi=chuoi_https.concat(chuoi_conlai);
        return chuoimoi;
    }

    private void setUpRecycleView(List<Food> listFood) {
        HotFoodAdapter adapter = new HotFoodAdapter(listFood,mainActivity);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(mainActivity,2);//định dạng layout cho RecycleView là Grid, 2 cột
        rcvFood.setLayoutManager(gridLayoutManager);
        rcvFood.setAdapter(adapter);
    }

    private RecyclerView rcvFood;
    private MainActivity mainActivity;
    private View mView;
    private RequestQueue requestQueue;

    private List<Food> listFood;
    private Food food;

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private Timer mTimer;

}
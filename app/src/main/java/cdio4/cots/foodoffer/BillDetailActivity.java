
package cdio4.cots.foodoffer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cdio4.cots.foodoffer.adapter.BillDetailAdapter;
import cdio4.cots.foodoffer.constance.JSONKEY;
import cdio4.cots.foodoffer.model.Food;

public class BillDetailActivity extends AppCompatActivity implements JSONKEY {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);
        InitLayout();
        setListBill(list_Bill);
        token = sharedPreferences.getString(JSON_TOKEN, "");
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(token !="" || token != null || token != " ")
                   buyNow();
               else
                   Toast.makeText(getApplicationContext(),"Thất bại",Toast.LENGTH_LONG).show();

            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(getApplicationContext(),"Hủy bỏ đơn hàng", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void buyNow() {
        try {
            if(foodAmount ==0){
                finish();
                Toast.makeText(getApplicationContext(),"Hủy bỏ đơn hàng", Toast.LENGTH_LONG).show();
            }
            else
                if(foodAmount < 0)
                    Toast.makeText(getApplicationContext(),"Số lượng không hợp lệ", Toast.LENGTH_LONG).show();
                else {
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    String url_BuyOneFood = getResources().getString(R.string.url_BuyOneFood)+foodID+"?soLuong="+foodAmount;
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url_BuyOneFood, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject rootBuyNow = new JSONObject(response);
                                if (rootBuyNow.getString(JSON_STATUS).equals(JSON_SUCCESS)) {
                                    JSONObject dataObject = rootBuyNow.getJSONObject(JSON_DATA);
                                    JSONObject billObject = dataObject.getJSONObject(BILL);
                                    bill_id = billObject.getString(BILL_ID);
                                    bill_status = billObject.getString(BILL_STATUS);
                                    bill_dateTime = billObject.getString(BILL_DATE_TIME);
                                    bill_total = billObject.getString(BILL_TOTAL);
                                    cus_id = billObject.getString(CUS_ID);
                                    res_id = billObject.getString(RES_ID);

                                    Toast.makeText(getApplicationContext(), "Đặt hàng thành công", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Có lỗi xảy ra, vui lòng thử lại", Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Có lỗi xảy ra, vui lòng thử lại", Toast.LENGTH_LONG).show();
                        }
                    }){
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String, String>();
                            params.put(TOKEN, HOST_TOKEN + token);
                            return params;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Số lượng không hợp lệ", Toast.LENGTH_LONG).show();
        }
    }

    private void setListBill(List<Food> list_bill) {
        BillDetailAdapter adapter = new BillDetailAdapter(list_bill,getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcv_billDetail.setLayoutManager(linearLayoutManager);
        rcv_billDetail.setAdapter(adapter);
    }

    private void InitLayout() {
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preferences_login), MODE_PRIVATE);
        rcv_billDetail = findViewById(R.id.rcv_bill_detail__food_item);
        tv_billID = findViewById(R.id.tv_bill_detail_activity_bill_id);
        tv_billStatus = findViewById(R.id.tv_bill_detail_activity_bill_status);
        tv_billDatime = findViewById(R.id.tv_bill_detail_activity_bill_time);
        tv_restaurantName = findViewById(R.id.tv_bill_detail_activity_restaurant_name);
        tv_billTotal = findViewById(R.id.tv_bill_detail_activity_bill_price);
        btn_confirm = findViewById(R.id.btn_bill_detail_confirm);
        btn_cancle = findViewById(R.id.btn_bill_detail_cancle);

        intent = getIntent();
        foodID = intent.getStringExtra("food_ID");
        foodName = intent.getStringExtra("food_Name");
        foodPrice = intent.getStringExtra("food_Price");
        foodImage = intent.getStringExtra("food_Image");
        food = new Food(foodID,foodName,Double.valueOf((foodPrice)),foodImage,foodAmount);
        list_Bill = new ArrayList<>();
        list_Bill.add(food);

        Double cost = new Double(0);
        for (int i =0; i < list_Bill.size(); i++)
            cost += list_Bill.get(i).getFood_Price();
        tv_billTotal.setText(cost + " đ");
        // Chưa set số lượng

    }

    private Intent intent;
    private SharedPreferences sharedPreferences;

    private RecyclerView rcv_billDetail;
    private TextView tv_billID;
    private TextView tv_billStatus;
    private TextView tv_billDatime;
    private TextView tv_restaurantName;
    private TextView tv_billTotal;
    private Button btn_confirm;
    private Button btn_cancle;

    private String token = "";
    private List<Food> list_Bill;
    private Food food;
    private String foodID = "";
    private String foodName = "";
    private String foodPrice = "";
    private String foodImage = "";
    private int foodAmount = 1;

    private String bill_status = "đang xử lý";
    private String bill_id = "";
    private String bill_dateTime = "";
    private String cus_id = "";
    private String res_id = "";
    private String bill_total = "";
}
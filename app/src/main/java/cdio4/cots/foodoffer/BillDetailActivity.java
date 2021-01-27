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

import java.util.ArrayList;
import java.util.List;

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
}
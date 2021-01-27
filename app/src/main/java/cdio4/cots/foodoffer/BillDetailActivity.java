package cdio4.cots.foodoffer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cdio4.cots.foodoffer.model.Food;

public class BillDetailActivity extends AppCompatActivity {
//trang giỏ hàng
// thuộc navgationview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);
        InitLayout();

    }

    private void InitLayout() {
        tv_billID = findViewById(R.id.tv_bill_detail_activity_bill_id);
        tv_billStatus = findViewById(R.id.tv_bill_detail_activity_bill_status);
        tv_billDatime = findViewById(R.id.tv_bill_detail_activity_bill_time);
        tv_restaurantName = findViewById(R.id.tv_bill_detail_activity_restaurant_name);
        tv_billTotal = findViewById(R.id.tv_bill_detail_activity_bill_price);
        list_Bill = new ArrayList<>();
    }

    private TextView tv_billID;
    private TextView tv_billStatus;
    private TextView tv_billDatime;
    private TextView tv_restaurantName;
    private TextView tv_billTotal;
    private List<Food> list_Bill;
}
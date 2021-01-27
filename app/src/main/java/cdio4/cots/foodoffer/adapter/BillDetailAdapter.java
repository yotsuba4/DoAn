package cdio4.cots.foodoffer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.model.Food;

public class BillDetailAdapter extends RecyclerView.Adapter<BillDetailAdapter.BillDetailViewHolder>  {
private List<Food> listBillFood;
private Context context;

    public BillDetailAdapter(List<Food> listBillFood, Context context) {
        this.listBillFood = listBillFood;
        this.context = context;
    }

    @NonNull
    @Override
    public BillDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_detail_food_item,parent,false);

        return new BillDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillDetailViewHolder holder, int position) {
        Food food = listBillFood.get(position);
        if (food == null)
            return;
        Glide.with(context).load(food.getFood_urlImage()).into(holder.img_foodIcon);
        holder.tv_foodName.setText(food.getFood_Name());
        holder.tv_foodPrice.setText("Giá: " + food.getFood_Price()+" đ");
        holder.edt_food_Amount.setText("1");
    }

    @Override
    public int getItemCount() {
        if(listBillFood != null)
            return listBillFood.size();
        return 0;
    }

    public class BillDetailViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_foodIcon;
        private TextView tv_foodName;
        private TextView tv_foodPrice;
        private EditText edt_food_Amount;
        public BillDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            initHolder(itemView);
        }

        private void initHolder(View view) {
            img_foodIcon = view.findViewById(R.id.img_bill_detail_food_item_icon);
            tv_foodName = view.findViewById(R.id.tv_bill_detail_food_item_food_name);
            tv_foodPrice = view.findViewById(R.id.tv_bill_detail_food_item_food_price);
            edt_food_Amount = view.findViewById(R.id.edt_bill_detail_food_item_food_amount);
        }
    }

}

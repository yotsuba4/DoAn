package cdio4.cots.foodoffer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import cdio4.cots.foodoffer.FoodDetailActivity;
import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.model.Food;

public class HotFoodAdapter extends RecyclerView.Adapter<HotFoodAdapter.HotFoodViewHolder> {
    private List<Food> mListFood;
    private Context context;
    private RequestOptions option;

    public HotFoodAdapter(List<Food> mListFood,Context context){
        this.mListFood=mListFood;
        this.context = context;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public HotFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_food_item,parent,false);
        return new HotFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotFoodViewHolder holder, int position) {
        Food food = mListFood.get(position);
        if(food==null){
            return;
        }

        Glide.with(context)
                .load(food.getFood_urlImage())
                .apply(option)
                .into(holder.img_food);

        holder.tv_foodName.setText(food.getFood_Name());
        holder.tv_foodPrice.setText(food.getFood_Price()+" đ");
    }

    @Override
    public int getItemCount() {
        if(mListFood!=null){
            return mListFood.size();
        }
        return 0;
    }

    public class HotFoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_food;
        private TextView tv_foodName;
        private TextView tv_foodPrice;

        public HotFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            img_food =itemView.findViewById(R.id.img_food);
            tv_foodName =itemView.findViewById(R.id.tv_name_food);
            tv_foodPrice =itemView.findViewById(R.id.tv_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(context, FoodDetailActivity.class);
                    intent.putExtra("food_ID", mListFood.get(position).getFood_ID());
                    intent.putExtra("FoodName", mListFood.get(position).getFood_Name());
                    intent.putExtra("FoodURL", mListFood.get(position).getFood_urlImage());
                    String foodprice = mListFood.get(position).getFood_Price()+"";
                    intent.putExtra("Price",foodprice);
                    intent.putExtra("Describe",mListFood.get(position).getFood_Captions());
                    intent.putExtra("FoodRes_ID",mListFood.get(position).getRestaurant_ID());
                    intent.putExtra("FoodRes_Name",mListFood.get(position).getRestaurant_Name());
                    context.startActivity(intent);
                }
            });
        }
    }
}

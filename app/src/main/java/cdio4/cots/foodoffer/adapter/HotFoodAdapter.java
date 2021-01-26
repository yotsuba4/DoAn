package cdio4.cots.foodoffer.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import cdio4.cots.foodoffer.FoodDetailActivity;
import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.model.Food;

public class HotFoodAdapter extends RecyclerView.Adapter<HotFoodAdapter.HotFoodViewHolder> {
    //Lớp HotFoodViewHolder ta làm bên trong lớp này dùng để tham chiếu giao diện cho từng item trong list
    private List<Food> mListFood;
    private Context mContext;
    RequestOptions option;


    public HotFoodAdapter(List<Food> mListFood,Context mContext){
        this.mListFood=mListFood;
        this.mContext=mContext;
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

      // holder.imgFood.setImageResource(food.getImage());
        Glide.with(mContext)
                .load(food.getFood_urlImage())
                .apply(option)
                .into(holder.imgFood);

        holder.tvNameFood.setText(food.getFood_Name());
        holder.tvPrice.setText(food.getFood_Price()+" đ");
    }

    @Override
    public int getItemCount() {
        if(mListFood!=null){
            return mListFood.size();
        }
        return 0;
    }

    public class HotFoodViewHolder extends RecyclerView.ViewHolder{
         private ImageView imgFood;
        private TextView tvNameFood;
        private TextView tvPrice;
        public HotFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood=itemView.findViewById(R.id.img_food);
            tvNameFood=itemView.findViewById(R.id.tv_name_food);
            tvPrice=itemView.findViewById(R.id.tv_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(mContext, FoodDetailActivity.class);
                    intent.putExtra("FoodName", mListFood.get(position).getFood_Name());
                    intent.putExtra("FoodURL", mListFood.get(position).getFood_urlImage());
                    String foodprice = mListFood.get(position).getFood_Price()+"";
                    intent.putExtra("Price",foodprice);
                    intent.putExtra("Describe",mListFood.get(position).getFood_Captions());
                    intent.putExtra("FoodRes_ID",mListFood.get(position).getRestaurant_ID());
                    intent.putExtra("FoodRes_Name",mListFood.get(position).getRestaurant_Name());
                    mContext.startActivity(intent);
                }
            });
        }
    }

}

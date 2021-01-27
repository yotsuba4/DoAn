package cdio4.cots.foodoffer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.model.Food;

public class MenuResAdapter extends RecyclerView.Adapter<MenuResAdapter.MenuResViewHolder> {
    private List<Food> mListMenuRes;
    private Context context;
    private RequestOptions option;

    public MenuResAdapter(List<Food> mListMenuRes, Context context) {
        this.mListMenuRes = mListMenuRes;
        this.context = context;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MenuResViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_res_menu, parent, false);
        return new MenuResViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuResViewHolder holder, int position) {
        Food food = mListMenuRes.get(position);
        if (food == null) {
            return;
        }
        Glide.with(context).load(food.getFood_urlImage()).apply(option).into(holder.img_food);
        holder.tv_foodName.setText(food.getFood_Name());
        holder.tv_foodPrice.setText(food.getFood_Price() + " đ");
    }

    @Override
    public int getItemCount() {
        if (mListMenuRes != null) {
            return mListMenuRes.size();
        }
        return 0;
    }

    //

    public class MenuResViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_food;
        private TextView tv_foodName;
        private TextView tv_foodPrice;
        private Button btn_addCart;

        public MenuResViewHolder(@NonNull View itemView) {
            super(itemView);
            img_food = itemView.findViewById(R.id.img_res_menu_item_food_icon);
            tv_foodName = itemView.findViewById(R.id.tv_res_menu_item_food_name);
            tv_foodPrice = itemView.findViewById(R.id.tv_res_menu_item_food_price);
            btn_addCart = itemView.findViewById(R.id.btn_res_menu_item_cart);
            btn_addCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Chưa code chức năng này", Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}

package cdio4.cots.foodoffer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cdio4.cots.foodoffer.R;

public class MenuResAdapter extends RecyclerView.Adapter<MenuResAdapter.MenuResViewHolder> {
    private List<MenuRestaurant> mListMenuRes;
    public void setData(List<MenuRestaurant> list){
        this.mListMenuRes=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MenuResViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu,parent,false);
        return new MenuResViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuResViewHolder holder, int position) {
        MenuRestaurant menuRestaurant = mListMenuRes.get(position);
        if(menuRestaurant==null){
            return;
        }
        holder.tvName.setText(menuRestaurant.getFoodName());
        holder.tvPrice.setText(menuRestaurant.getFoodPrice());
    }

    @Override
    public int getItemCount() {
        if(mListMenuRes!=null){
            return mListMenuRes.size();
        }
        return 0;
    }

    public class MenuResViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgAvatar;
        private TextView tvName;
        private TextView tvPrice;
        public MenuResViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar=itemView.findViewById(R.id.img_menu_food_avatar);
            tvName=itemView.findViewById(R.id.tv_menu_food_name);
            tvPrice=itemView.findViewById(R.id.tv_menu_food_price);
        }
    }
}

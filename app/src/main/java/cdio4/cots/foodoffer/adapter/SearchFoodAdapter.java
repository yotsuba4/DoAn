package cdio4.cots.foodoffer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.model.Food;

public class SearchFoodAdapter extends RecyclerView.Adapter<SearchFoodAdapter.SearchFoodViewHoler> {
    private List<Food> foodSearchList;
    private Context context;

    public SearchFoodAdapter(List<Food> foodSearchList, Context context) {
        this.foodSearchList = foodSearchList;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchFoodViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_food_item,parent,false);
        return new SearchFoodAdapter.SearchFoodViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchFoodViewHoler holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(foodSearchList!=null){
            return foodSearchList.size();
        }
        return 0;
    }

    public class SearchFoodViewHoler extends RecyclerView.ViewHolder{

        private TextView tvNameFood;
        public SearchFoodViewHoler(@NonNull View itemView) {
            super(itemView);
            tvNameFood=itemView.findViewById(R.id.tv_food_name_search_bar_item);
        }
    }
}

package cdio4.cots.foodoffer.ui.restaurant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cdio4.cots.foodoffer.MainActivity;
import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.RestaurantDetailActivity;
import cdio4.cots.foodoffer.adapter.MenuResAdapter;
import cdio4.cots.foodoffer.adapter.MenuRestaurant;


public class MenuFragment extends Fragment {
    private RecyclerView rcvMenu;
    private View mView;
    RestaurantDetailActivity restaurantDetailActivity;
    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_menu, container, false);
        init();
        return mView;
    }

    private void init() {
        rcvMenu=mView.findViewById(R.id.rcv_res_menu_fragment);
        restaurantDetailActivity=(RestaurantDetailActivity) getActivity();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(restaurantDetailActivity);
        rcvMenu.setLayoutManager(linearLayoutManager);
        MenuResAdapter menuAdapter=new MenuResAdapter();
        menuAdapter.setData(getMenu());
        rcvMenu.setAdapter(menuAdapter);
    }

    private List<MenuRestaurant> getMenu() {
        List<MenuRestaurant> list = new ArrayList<>();
        list.add(new MenuRestaurant("Gà rán","30000"));
        list.add(new MenuRestaurant("Gà rán","30000"));
        list.add(new MenuRestaurant("Gà rán","30000"));
        list.add(new MenuRestaurant("Gà rán","30000"));
        list.add(new MenuRestaurant("Gà rán","30000"));
        list.add(new MenuRestaurant("Gà rán","30000"));
        return list;
    }
}
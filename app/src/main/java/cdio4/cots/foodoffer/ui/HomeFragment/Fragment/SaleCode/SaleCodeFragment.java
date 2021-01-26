package cdio4.cots.foodoffer.ui.HomeFragment.Fragment.SaleCode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cdio4.cots.foodoffer.R;

public class SaleCodeFragment extends Fragment {

    private SaleCodeViewModel mViewModel;

    public static SaleCodeFragment newInstance() {
        return new SaleCodeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sale_code_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SaleCodeViewModel.class);
        // TODO: Use the ViewModel
    }

}
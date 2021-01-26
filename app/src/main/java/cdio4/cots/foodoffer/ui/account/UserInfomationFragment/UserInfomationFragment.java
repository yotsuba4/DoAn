package cdio4.cots.foodoffer.ui.account.UserInfomationFragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.model.Account;

public class UserInfomationFragment extends Fragment {
    //bất sự kiện giống signin

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root =  inflater.inflate(R.layout.user_infomation_fragment, container, false);
        InitFragment();

/*        edt_fullName.addTextChangedListener(edt_fullName_Event);
        edt_bDate.addTextChangedListener(edt_bDate_Event);
        edt_userID.addTextChangedListener(edt_userID_Event);
        edt_phone.addTextChangedListener(edt_phone_Event);
        edt_email.addTextChangedListener(edt_email_Event);
        edt_adress.addTextChangedListener(edt_adress_Event);*/


       /* rbtGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rbt_male.isChecked())
                    accountViewModel.setGender(true);
                else
                if (rbt_female.isChecked())
                    accountViewModel.setGender(false);
            }
        });*/


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = new ViewModelProvider(this).get(ChangePasswordViewModel.class);
        // TODO: Use the ViewModel
    }

    private void InitFragment(){
        imgv_avatar = root.findViewById(R.id.imgv_us_info_avatar);

        edt_fullNameLayout = root.findViewById(R.id.ip_layout_us_info_fullname);
        edt_bDateLayout = root.findViewById(R.id.ip_layout_us_info_bdate);
        edt_userIDLayout = root.findViewById(R.id.ip_layout_us_info_id);
        edt_phoneLayout = root.findViewById(R.id.ip_layout_us_info_phone);
        edt_emailLayout = root.findViewById(R.id.ip_layout_us_info_email);
        edt_adressLayout = root.findViewById(R.id.ip_layout_us_info_adress);

        edt_fullName = root.findViewById(R.id.ip_edt_us_info_fullname);
        edt_bDate = root.findViewById(R.id.ip_edt_us_info_bdate);
        edt_userID = root.findViewById(R.id.ip_edt_us_info_id);
        edt_phone = root.findViewById(R.id.ip_edt_us_info_phone);
        edt_email = root.findViewById(R.id.ip_edt_us_info_email);
        edt_adress = root.findViewById(R.id.ip_edt_us_info_adress);

        rbtGroupGender = root.findViewById(R.id.rbt_group_us_info_gender);
        rbt_male = rbtGroupGender.findViewById(R.id.rbt_us_info_male);
        rbt_female = rbtGroupGender.findViewById(R.id.rbt_us_info_female);
    }


    private View root;
    private Account account;

    private ImageView imgv_avatar;
    private TextInputLayout edt_fullNameLayout;
    private TextInputLayout edt_bDateLayout;
    private TextInputLayout edt_userIDLayout;
    private TextInputLayout edt_phoneLayout;
    private TextInputLayout edt_emailLayout;
    private TextInputLayout edt_adressLayout;
    private TextInputEditText edt_fullName;
    private TextInputEditText edt_bDate;
    private TextInputEditText edt_userID;
    private TextInputEditText edt_phone;
    private TextInputEditText edt_email;
    private TextInputEditText edt_adress;
    private RadioGroup rbtGroupGender;
    private RadioButton rbt_male;
    private RadioButton rbt_female;

/*    private TextWatcher edt_fullName_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            accountViewModel.setFullname(edt_fullName.getText().toString());
        }
    };
    private TextWatcher edt_bDate_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            accountViewModel.setbDate(edt_bDate.getText().toString());
        }
    };
    private TextWatcher edt_userID_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            accountViewModel.setUsID(edt_userID.getText().toString());
        }
    };
    private TextWatcher edt_phone_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            accountViewModel.setPhone(edt_phone.getText().toString());
        }
    };
    private TextWatcher edt_email_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            accountViewModel.setEmail(edt_email.getText().toString());
        }
    };
    private TextWatcher edt_adress_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            accountViewModel.setAdress(edt_adress.getText().toString());
        }
    };*/

    public static UserInfomationFragment newInstance() {
        return new UserInfomationFragment();
    }
}
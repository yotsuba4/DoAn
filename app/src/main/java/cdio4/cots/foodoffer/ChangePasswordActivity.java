package cdio4.cots.foodoffer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

import cdio4.cots.foodoffer.constance.JSONKEY;
import cdio4.cots.foodoffer.tools.RegularExpression;

public class ChangePasswordActivity extends AppCompatActivity implements JSONKEY {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        InitLayout();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.confirm_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_confirm:
                changePass();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void InitLayout() {
        edt_newPasswordLayout = findViewById(R.id.ip_layout_change_password_password);
        edt_newPasswordLayout = findViewById(R.id.ip_layout_change_password_new_password);
        edt_newPasswordLayout = findViewById(R.id.ip_layout__change_password_password_confirm);

        edt_password = findViewById(R.id.ip_edt_change_password_password);
        edt_password = findViewById(R.id.ip_edt_change_password_new_password);
        edt_password = findViewById(R.id.ip_edt_change_password_password_confirm);

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preferences_login), MODE_PRIVATE);
    }


    private void changePass(){
        String url_changePass = getResources().getString(R.string.url_ChangePassword);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_changePass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put(TOKEN, HOST_TOKEN + sharedPreferences.getString(JSON_TOKEN,null));
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put(PASSWORD, password);
                params.put(NEW_PASSWORD, newPassword);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


    private RequestQueue requestQueue;
    private SharedPreferences sharedPreferences;

    private TextInputLayout edt_passwordLayout;
    private TextInputLayout edt_newPasswordLayout;
    private TextInputLayout edt_passwordConfirmLayout;

    private TextInputEditText edt_password;
    private TextInputEditText edt_newPassword;
    private TextInputEditText edt_passwordConfirm;

    private String password = "";
    private String newPassword = "";
    private RegularExpression regx;

    private TextWatcher edt_password_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            regx.checkNull(edt_passwordLayout, charSequence, "Vui lòng nhập mật khẩu");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            password = edt_password.getText().toString();
        }
    };
    private TextWatcher edt_newPassword_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            regx.checkNull(edt_passwordLayout, charSequence, "Vui lòng nhập mật khẩu mới");
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (password.equals(edt_newPassword.getText().toString()))
                edt_newPasswordLayout.setError("Mật khẩu mới không được trùng mật khẩu cũ");
            else
                edt_newPasswordLayout.setError(null);
        }

        @Override
        public void afterTextChanged(Editable editable) {
            newPassword = edt_newPassword.getText().toString();
        }
    };
    private TextWatcher edt_passwordConfirm_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            regx.checkNull(edt_passwordLayout, charSequence, "Vui lòng nhập lại mật khẩu mới");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(edt_passwordConfirm.getText().toString().equals(newPassword))
                edt_passwordConfirmLayout.setError(null);
            else
                edt_passwordConfirmLayout.setError("Không khớp");
        }
    };
}
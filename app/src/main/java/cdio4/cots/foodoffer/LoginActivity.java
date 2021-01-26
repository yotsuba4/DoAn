package cdio4.cots.foodoffer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cdio4.cots.foodoffer.constance.JSONKEY;
import cdio4.cots.foodoffer.database.RequestAPI;
import cdio4.cots.foodoffer.tools.RegularExpression;

public class LoginActivity extends AppCompatActivity implements JSONKEY {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitLayout();

        edt_username.addTextChangedListener(edt_userName_event);
        edt_password.addTextChangedListener(edt_password_event);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
           
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }

    private void InitLayout() {
        edt_usernameLayout = findViewById(R.id.ip_layout_activity_login_username);
        edt_passwordLayout = findViewById(R.id.ip_layout_activity_login_password);
        edt_username = findViewById(R.id.ip_edt_activity_login_username);
        edt_password = findViewById(R.id.ip_edt_activity_login_password);
        btn_login = findViewById(R.id.btn_activity_login_login);
        btn_signin = findViewById(R.id.btn_activity_login_sign_in);

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preferences_login), MODE_PRIVATE);
    }


    protected void SharedPreferencesSaveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(JSON_TOKEN, token);

        editor.commit();
    }

    private void Login(){
        String urlLogin = getResources().getString(R.string.url_Login);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlLogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject rootLogin = new JSONObject(response);
                    if (rootLogin.getString(JSON_STATUS).equals(JSON_SUCCESS)) {
                        Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                        JSONObject dataObject = rootLogin.getJSONObject(JSON_DATA);
                        token = dataObject.getString(JSON_TOKEN);
                        SharedPreferencesSaveData();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Đăng nhập thất bại, sai tên đăng nhập hoặc mật khẩu.", Toast.LENGTH_LONG).show();
                        token = "";
                        SharedPreferencesSaveData();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Có lỗi xảy ra trong lúc đăng nhập", Toast.LENGTH_LONG).show();
                    token = "";
                    SharedPreferencesSaveData();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Vui lòng kiểm tra kết nối internet",Toast.LENGTH_LONG).show();
                token = "";
                SharedPreferencesSaveData();
            }
        }){

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put(USERNAME, username);
                params.put(PASSWORD, password);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private RequestQueue requestQueue;
    private SharedPreferences sharedPreferences;
    private RegularExpression regx = new RegularExpression();

    private TextInputLayout edt_usernameLayout;
    private TextInputLayout edt_passwordLayout;
    private TextInputEditText edt_username;
    private TextInputEditText edt_password;
    private Button btn_login;
    private Button btn_signin;

    private String username;
    private String password;
    private Boolean loginStatus = false;
    private String token = "";


    private TextWatcher edt_userName_event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            regx.checkNull(edt_usernameLayout, charSequence, "Vui lòng nhập tài khoản");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            username = edt_username.getText().toString();
        }
    };
    private TextWatcher edt_password_event = new TextWatcher() {
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
}
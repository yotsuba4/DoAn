package cdio4.cots.foodoffer.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.database.RequestAPI;

public class AccountMethod {
    private Context context;
    private SharedPreferences sharedPreferences;

    private String username;
    private String password;
    private Boolean loginStatus;
    private String token;
    private String errorMessage;
    private String fullName;
    private Boolean gender;
    private String bDate;
    private String usID;
    private String phone;
    private String email;
    private String adress;

    public AccountMethod(Context context, String username, String password) {
        this.context = context;
        this.username = username;
        this.password = password;
    }

    public AccountMethod(Context context, String fullName, Boolean gender, String bDate, String usID, String phone, String email, String adress) {
        this.context = context;
        this.fullName = fullName;
        this.gender = gender;
        this.bDate = bDate;
        this.usID = usID;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    public AsyncTask<String, Void, String> Login = new AsyncTask<String, Void, String>() {
        @Override
        protected String doInBackground(String... urlRequest) {
            String message = "{" +
                    "\"username\":" + "\"" + username + "\"," +
                    "\"password\":" + "\"" + password + "\"" +
                    "}";
            return new RequestAPI(message, null).PostRequest(urlRequest);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject loginObject = new JSONObject(s);
                if (loginObject.getString("status").equals("success")) {
                    loginStatus = true;
                    token = loginObject.getJSONObject("data").getString("token");
                    errorMessage = "";
                } else {
                    loginStatus = false;
                    token = "";
                    errorMessage = loginObject.getJSONObject("error").getString("message");
                }

                Toast.makeText(context, loginObject.getString("status"), Toast.LENGTH_SHORT).show();

            } catch (JSONException e) {
                e.printStackTrace();
            }

            SharedPreferencesSaveData(context.getResources().getString(R.string.shared_preferences_login));
        }
    };

    public AsyncTask<String, Void,String> Signin = new AsyncTask<String, Void, String>() {
        @Override
        protected String doInBackground(String... urlRequest) {
            String message = "{" +
                    "\"username\":" + "\"" + username + "\"," +
                    "\"email\":" + "\"" + email + "\"" +
                    "\"password\":" + "\"" + password + "\"" +
                    "\"SDT\":" + "\"" + phone + "\"" +
                    "\"diaChi\":" + "\"" + adress + "\"" +
                    "\"fullName\":" + "\"" + fullName + "\"" +
                    "\"gioiTinh\":" + "\"" + String.valueOf(gender) + "\"" +
                    "\"ngaySinh\":" + "\"" + bDate + "\"" +
                    "\"CMND\":" + "\"" + usID + "\"" +
                    "}";
            return new RequestAPI(message, null).GetRequest(urlRequest);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //////
        }
    };

    protected void SharedPreferencesSaveData(String fileName){
        sharedPreferences= context.getSharedPreferences(context.getResources().getString(R.string.shared_preferences_login), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putBoolean("logintatus",loginStatus);
        editor.putString("token",token);
        editor.putString("message",errorMessage);

        editor.commit();
    }

}

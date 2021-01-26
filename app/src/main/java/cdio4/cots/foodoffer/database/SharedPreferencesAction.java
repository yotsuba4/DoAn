package cdio4.cots.foodoffer.database;

import android.content.Context;
import android.content.SharedPreferences;

import cdio4.cots.foodoffer.R;

public class SharedPreferencesAction {
    private Context context;
    private SharedPreferences sharedPreferences;
    public final int READ = 1;
    public final int WRITE = 2;

    private String fileName = "";

    public SharedPreferencesAction(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    public void SharedPreferencesSaveData(String fileName){
        sharedPreferences= context.getSharedPreferences(context.getResources().getString(R.string.shared_preferences_login), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
       /* editor.putString("username", username);
        editor.putString("password", password);
        editor.putBoolean("status",status);
        editor.putString("token",token);
        editor.putString("message",errorMessage);*/

        editor.commit();
    }

   /* protected void SharedPreferencesGetData(String fileName){
        sharedPreferences.getBoolean("status",false); // false is default value
    }*/
}

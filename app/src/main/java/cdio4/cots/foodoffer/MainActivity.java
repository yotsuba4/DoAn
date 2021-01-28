package cdio4.cots.foodoffer;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import cdio4.cots.foodoffer.constance.JSONKEY;
import cdio4.cots.foodoffer.ui.HomeFragment.Fragment.SearchBar.SearchBarFragment;
import cdio4.cots.foodoffer.ui.HomeFragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements JSONKEY {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitLayout();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_userInfomation:
                        if (sharedPreferences.getString(JSON_TOKEN, "") != null &&
                                sharedPreferences.getString(JSON_TOKEN, "") != "" &&
                                sharedPreferences.getString(JSON_TOKEN, "") != " " ){
                            intent = new Intent(MainActivity.this, UserInfomationActivity.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Vui lòng đăng nhập", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_discountCode:
                        // intent = new Intent(MainActivity.this, DiscountCodeActivity.class);
                        break;
                    case R.id.nav_cart:
                      intent = new Intent(MainActivity.this, CartActivity.class);
                       startActivity(intent);
                       // Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_historyTransaction:
                        // intent = new Intent(MainActivity.this, HistoryTransactionActivity.class);
                        break;
                    case R.id.nav_userChangePass:
                        if (sharedPreferences.getString(JSON_TOKEN, "") != null &&
                                sharedPreferences.getString(JSON_TOKEN, "") != "" &&
                                sharedPreferences.getString(JSON_TOKEN, "") != " " ){
                            intent = new Intent(MainActivity.this, ChangePasswordActivity.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Vui lòng đăng nhập", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_aboutUs:
                        intent = new Intent(MainActivity.this, AboutUsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_logout:
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(JSON_TOKEN, "");
                        editor.commit();
                        Toast.makeText(getApplicationContext(),"Đẵ đăng xuất", Toast.LENGTH_LONG).show();
                        break;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
       // DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.toolbar_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty()){
                    replaceFragment(new HomeFragment());
                }else{
                    replaceFragment(new SearchBarFragment());
                }
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.toolbar_search:
                AppBAr_Search();
                return true;
            case R.id.toolbar_avatar:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void InitLayout(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        replaceFragment(new HomeFragment()); // default home fragment
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preferences_login), MODE_PRIVATE);
    }

    protected  void AppBAr_Search(){
        // post api
        //phân tích json
        //hiển thị
        // đề xuất: live data
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_layout, fragment);
        transaction.commit();
    }

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private NavigationView navigationView;
    private Intent intent;
    private SharedPreferences sharedPreferences;
    private SearchView searchView;
}
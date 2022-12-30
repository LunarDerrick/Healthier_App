package wia2007.example.healthier_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.FCVBlank);
        NavController navController = host.getNavController();
        setupBottomNavMenu(navController);
        */
    }

    public void BtnPlannerOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), PlannerActivity.class);
        startActivity(intent);
    }

    public void BtnCalculatorOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);
        startActivity(intent);
    }

    private void setupBottomNavMenu(NavController navController) {
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottomNav, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom, menu);
        return true;
    }
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            Navigation.findNavController(this, R.id.FCVBlank).navigate(item.getItemId());
            return true;
        } catch (Exception ex) {
            return super.onOptionsItemSelected(item);
        }
    }
    */
}
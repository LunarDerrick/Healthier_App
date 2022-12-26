package wia2007.example.healthier_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class PlannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);
    }

    public void BtnCompleteOnClick(View view) {
        String message = "'Complete' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void BtnEditOnClick(View view) {
        String message = "'Edit' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
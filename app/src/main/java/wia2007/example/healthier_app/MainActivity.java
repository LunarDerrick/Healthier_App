package wia2007.example.healthier_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BtnPlannerOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), PlannerActivity.class);
        startActivity(intent);
    }
}
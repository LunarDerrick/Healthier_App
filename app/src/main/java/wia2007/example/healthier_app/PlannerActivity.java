package wia2007.example.healthier_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

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

    public void BtnAddOnClick(View view) {
        String message = "'Add' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void BtnStrTrainOnClick(View view) {
        String message = "'Strength training' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void BtnYogaOnClick(View view) {
        String message = "'Yoga and stretching' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void BtnDietOnClick(View view) {
        FragmentContainerView FCVDiet = findViewById(R.id.FCVDiet);
        FragmentContainerView FCVExercise = findViewById(R.id.FCVExercise);
        FCVDiet.setVisibility(View.VISIBLE);
        FCVExercise.setVisibility(View.GONE);
    }

    public void BtnExerciseOnClick(View view) {
        FragmentContainerView FCVDiet = findViewById(R.id.FCVDiet);
        FragmentContainerView FCVExercise = findViewById(R.id.FCVExercise);
        FCVDiet.setVisibility(View.GONE);
        FCVExercise.setVisibility(View.VISIBLE);
    }
}
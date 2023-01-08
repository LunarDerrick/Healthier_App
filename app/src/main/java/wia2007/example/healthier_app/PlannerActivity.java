package wia2007.example.healthier_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

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

    public void BtnEditStartOnClick(View view) {
        String message = "'Edit start' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void BtnPauseOnClick(View view) {
        String message = "'Pause fast' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void BtnStopOnClick(View view) {
        String message = "'Stop fast' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void Btn52DietOnClick(View view) {
        String message = "'5:2 Diet' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void BtnEatStopOnClick(View view) {
        String message = "'Eat-Stop-Eat' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void Btn168MethodOnClick(View view) {
        String message = "'16/8 Method' button pressed";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void BtnDietOnClick(View view) {
        FragmentContainerView FCVDiet = findViewById(R.id.FCVDiet);
        FragmentContainerView FCVExercise = findViewById(R.id.FCVExercise);
        FragmentContainerView FCVFast = findViewById(R.id.FCVFast);
        FCVDiet.setVisibility(View.VISIBLE);
        FCVExercise.setVisibility(View.GONE);
        FCVFast.setVisibility(View.GONE);
    }

    public void BtnExerciseOnClick(View view) {
        FragmentContainerView FCVDiet = findViewById(R.id.FCVDiet);
        FragmentContainerView FCVExercise = findViewById(R.id.FCVExercise);
        FragmentContainerView FCVFast = findViewById(R.id.FCVFast);
        FCVDiet.setVisibility(View.GONE);
        FCVExercise.setVisibility(View.VISIBLE);
        FCVFast.setVisibility(View.GONE);
    }

    public void BtnFastOnClick(View view) {
        FragmentContainerView FCVDiet = findViewById(R.id.FCVDiet);
        FragmentContainerView FCVExercise = findViewById(R.id.FCVExercise);
        FragmentContainerView FCVFast = findViewById(R.id.FCVFast);
        FCVDiet.setVisibility(View.GONE);
        FCVExercise.setVisibility(View.GONE);
        FCVFast.setVisibility(View.VISIBLE);
    }
}
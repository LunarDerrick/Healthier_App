package wia2007.example.healthier_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.View;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void BtnBMIMacroOnClick(View view) {
        FragmentContainerView FCVBMIMacro = findViewById(R.id.FCVBMIMacro);
        FragmentContainerView FCVCalorie = findViewById(R.id.FCVCalorie);
        FCVBMIMacro.setVisibility(View.VISIBLE);
        FCVCalorie.setVisibility(View.GONE);
    }

    public void BtnCalorieOnClick(View view) {
        FragmentContainerView FCVBMIMacro = findViewById(R.id.FCVBMIMacro);
        FragmentContainerView FCVCalorie = findViewById(R.id.FCVCalorie);
        FCVBMIMacro.setVisibility(View.GONE);
        FCVCalorie.setVisibility(View.VISIBLE);
    }
}
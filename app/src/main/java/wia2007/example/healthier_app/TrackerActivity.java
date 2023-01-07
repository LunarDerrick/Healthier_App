package wia2007.example.healthier_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.View;

public class TrackerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
    }

    public void BtnProgressOnClick(View view) {
        FragmentContainerView FCVProgress = findViewById(R.id.FCVProgress);
        FragmentContainerView FCVReward = findViewById(R.id.FCVReward);
        FragmentContainerView FCVFood = findViewById(R.id.FCVFood);
        FCVProgress.setVisibility(View.VISIBLE);
        FCVReward.setVisibility(View.GONE);
        FCVFood.setVisibility(View.GONE);
    }

    public void BtnRewardOnClick(View view) {
        FragmentContainerView FCVProgress = findViewById(R.id.FCVProgress);
        FragmentContainerView FCVReward = findViewById(R.id.FCVReward);
        FragmentContainerView FCVFood = findViewById(R.id.FCVFood);
        FCVProgress.setVisibility(View.GONE);
        FCVReward.setVisibility(View.VISIBLE);
        FCVFood.setVisibility(View.GONE);
    }

    public void BtnFoodOnClick(View view) {
        FragmentContainerView FCVProgress = findViewById(R.id.FCVProgress);
        FragmentContainerView FCVReward = findViewById(R.id.FCVReward);
        FragmentContainerView FCVFood = findViewById(R.id.FCVFood);
        FCVProgress.setVisibility(View.GONE);
        FCVReward.setVisibility(View.GONE);
        FCVFood.setVisibility(View.VISIBLE);
    }
}
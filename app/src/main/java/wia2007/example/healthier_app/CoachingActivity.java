package wia2007.example.healthier_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.View;

public class CoachingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coaching);
    }

    public void BtnFinderOnClick(View view) {
        FragmentContainerView FCVFinder = findViewById(R.id.FCVFinder);
        FragmentContainerView FCVLesson = findViewById(R.id.FCVLesson);
        FragmentContainerView FCVLocator = findViewById(R.id.FCVLocator);
        FCVFinder.setVisibility(View.VISIBLE);
        FCVLesson.setVisibility(View.GONE);
        FCVLocator.setVisibility(View.GONE);
    }

    public void BtnLessonOnClick(View view) {
        FragmentContainerView FCVFinder = findViewById(R.id.FCVFinder);
        FragmentContainerView FCVLesson = findViewById(R.id.FCVLesson);
        FragmentContainerView FCVLocator = findViewById(R.id.FCVLocator);
        FCVFinder.setVisibility(View.GONE);
        FCVLesson.setVisibility(View.VISIBLE);
        FCVLocator.setVisibility(View.GONE);
    }

    public void BtnLocatorOnClick(View view) {
        FragmentContainerView FCVFinder = findViewById(R.id.FCVFinder);
        FragmentContainerView FCVLesson = findViewById(R.id.FCVLesson);
        FragmentContainerView FCVLocator = findViewById(R.id.FCVLocator);
        FCVFinder.setVisibility(View.GONE);
        FCVLesson.setVisibility(View.GONE);
        FCVLocator.setVisibility(View.VISIBLE);
    }
}
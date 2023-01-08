package wia2007.example.healthier_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class PlannerActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        tabLayout = findViewById(R.id.tabs);
        viewPager2 = findViewById(R.id.VP2Diet);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
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
}
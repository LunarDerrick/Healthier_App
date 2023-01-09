package wia2007.example.healthier_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapterCalculator extends FragmentStateAdapter {
    public ViewPagerAdapterCalculator(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new BMIMacroCalc();
            case 1:
                return new CalorieCalc();
            default:
                return new CalorieCalc();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

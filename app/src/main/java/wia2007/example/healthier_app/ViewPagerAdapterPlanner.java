package wia2007.example.healthier_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapterPlanner extends FragmentStateAdapter {
    public ViewPagerAdapterPlanner(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DietFragment();
            case 1:
                return new ExerciseFragment();
            case 2:
                return new FastingFragment();
            default:
                return new DietFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

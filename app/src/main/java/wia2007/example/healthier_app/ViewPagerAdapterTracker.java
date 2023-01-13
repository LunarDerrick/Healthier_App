package wia2007.example.healthier_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapterTracker extends FragmentStateAdapter {
    public ViewPagerAdapterTracker(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new EarnRewardTFragment();
            case 2:
                return new FoodInventoryTFragment();
            default:
                return new ProgressTFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
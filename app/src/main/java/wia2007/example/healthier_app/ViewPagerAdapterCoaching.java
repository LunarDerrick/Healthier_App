package wia2007.example.healthier_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapterCoaching extends FragmentStateAdapter {
    public ViewPagerAdapterCoaching(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new LessonsFragment();
//            case 2:
//                return new LocatorFragment();
            default:
                return new FinderFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
package wia2007.example.healthier_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    TextView hello;
    ViewPager2 viewPager2;
    ArrayList<ViewPagerItem> viewPagerItemArrayList;
    int cont;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        hello = view.findViewById(R.id.TVHome);

        DatabaseReference dbuser = FirebaseDatabase
                .getInstance("https://healthier-app-aed74-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference("User").child(firebaseAuth.getUid());

        dbuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                hello.setText(userProfile.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

        viewPager2 = view.findViewById(R.id.viewpager);
        int[] images = {R.drawable.home_news, R.drawable.home_news2, R.drawable.home_news3};
        String[] heading = {"Healthy Diet - WHO",
                "World Obesity Day 2022 – Accelerating action to stop obesity - WHO",
                "Healthy public food procurement and service policies - WHO"};

        viewPagerItemArrayList = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            ViewPagerItem viewPagerItem = new ViewPagerItem(images[i], heading[i]);
            viewPagerItemArrayList.add(viewPagerItem);
        }

        VPAdapter vpAdapter = new VPAdapter(viewPagerItemArrayList);
        viewPager2.setAdapter(vpAdapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(40));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.15f);
                page.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (cont) {
                            case 1:
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                                        "https://www.who.int/news-room/fact-sheets/detail/healthy-diet#:~:text=A%20healthy%20diet%20includes%20the,cassava%20and%20other%20starchy%20roots."));
                                startActivity(browserIntent);
                                break;
                            case 2:
                                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(
                                        "https://www.who.int/news/item/04-03-2022-world-obesity-day-2022-accelerating-action-to-stop-obesity"));
                                startActivity(browserIntent2);
                                break;
                            case 3:
                                Intent browserIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(
                                        "https://www.who.int/news/item/15-07-2022-the-untapped-potential-of-healthy-public-food-procurement-and-service-policies-to-support-the-repurposing-of-food-and-agricultural-policies-for-delivery-of-affordable-healthy-diets"));
                                startActivity(browserIntent3);
                                break;
                        }
                    }
                });
            }
        });

        viewPager2.setPageTransformer(transformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        cont = 1;
                        break;
                    case 1:
                        cont = 2;
                        break;
                    case 2:
                        cont = 3;
                        break;
                    default:
                        cont = 0;
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // Calculator Navigation
        ImageView BtnCalculator = view.findViewById(R.id.calculator_btn);
        View.OnClickListener OCLCalculator = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestCalculator);
            }
        };
        BtnCalculator.setOnClickListener(OCLCalculator);

        // Planner Navigation
        ImageView BtnPlanner = view.findViewById(R.id.planner_btn);
        View.OnClickListener OCLPlanner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestPlanner);
            }
        };
        BtnPlanner.setOnClickListener(OCLPlanner);

        // Tracker Navigation
        ImageView BtnTracker = view.findViewById(R.id.tracker_btn);
        View.OnClickListener OCLTracker = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestTracker);
            }
        };
        BtnTracker.setOnClickListener(OCLTracker);

        // Coaching Navigation
        ImageView BtnCoaching = view.findViewById(R.id.coach_btn);
        View.OnClickListener OCLCoaching = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestCoaching);
            }
        };
        BtnCoaching.setOnClickListener(OCLCoaching);
    }
}
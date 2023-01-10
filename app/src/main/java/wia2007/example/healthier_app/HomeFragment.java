package wia2007.example.healthier_app;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    TextView hello;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        hello = view.findViewById(R.id.TVHome);

        DatabaseReference dbuser = FirebaseDatabase
                .getInstance("https://healthier-app-aed74-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference("User").child(firebaseAuth.getUid());

        dbuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                hello.setText("Hello, " + userProfile.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
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
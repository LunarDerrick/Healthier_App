package wia2007.example.healthier_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SettingsFragment extends Fragment {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    TextView titlename, titleusername;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        titleusername = view.findViewById(R.id.sample_username);
        titlename = view.findViewById(R.id.sample_name);

        DatabaseReference dbuser = FirebaseDatabase
                .getInstance("https://healthier-app-aed74-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference("User").child(firebaseAuth.getUid());

        dbuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                titleusername.setText("@" + userProfile.getUsername());
                titlename.setText(userProfile.getName());
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

        ImageView BtnLogout = view.findViewById(R.id.logout_btn);
        ImageView BtnUser = view.findViewById(R.id.user_btn);
        ImageView BtnPayment = view.findViewById(R.id.managepay_btn);

        // Logout Navigation
        View.OnClickListener OCLLogout = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestGeneral);
            }
        };
        BtnLogout.setOnClickListener(OCLLogout);

        View.OnClickListener OCLUser = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestInfo);
            }
        };
        BtnUser.setOnClickListener(OCLUser);

        View.OnClickListener OCLPayment = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestEditPay);
            }
        };
        BtnPayment.setOnClickListener(OCLPayment);
    }
}
package wia2007.example.healthier_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfoFragment extends Fragment {

    TextView numb, age, gender, userweight, userheight;
    TextView titlename, titleusername;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        titleusername = view.findViewById(R.id.TVUsername);
        titlename = view.findViewById(R.id.TVName);
        age = view.findViewById(R.id.age);
        numb = view.findViewById(R.id.number);
        gender = view.findViewById(R.id.gender);
        userweight = view.findViewById(R.id.weight);
        userheight = view.findViewById(R.id.height);

        DatabaseReference dbuser = FirebaseDatabase
                .getInstance("https://healthier-app-aed74-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference("User").child(firebaseAuth.getUid());

        dbuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                titleusername.setText("@" + userProfile.getUsername());
                titlename.setText(userProfile.getName());
                age.setText(userProfile.getAge() + " years old");
                numb.setText(userProfile.getPhoneNumber());
                userweight.setText((int) userProfile.getWeight() + " kg");
                userheight.setText((int) userProfile.getHeight() + " cm");
                gender.setText(userProfile.getGender());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button BtnEdit = view.findViewById(R.id.EditButton);

        // Edit Profile Navigation
        View.OnClickListener OCLEdit = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.DestEdit);
            }
        };
        BtnEdit.setOnClickListener(OCLEdit);
    }
}
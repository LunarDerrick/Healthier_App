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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditPaymentFragment extends Fragment {

    TextView cnum, expdate, cvvcode, wallet;
    Button gobtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_payment, container, false);

        gobtn = view.findViewById(R.id.confirmbtn);
        cnum = view.findViewById(R.id.cardnum_content);
        expdate = view.findViewById(R.id.cardnum_content2);
        cvvcode = view.findViewById(R.id.cardnum_content3);
        wallet = view.findViewById(R.id.choose_ewallet4);

        DatabaseReference dbpay = FirebaseDatabase
                .getInstance("https://healthier-app-aed74-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference().child("Payment");

        dbpay.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Payment paymentProfile = dataSnapshot.getValue(Payment.class);
                    cnum.setText(paymentProfile.getCardnumber());
                    expdate.setText(paymentProfile.getExpirydate());
                    cvvcode.setText(paymentProfile.getCvv() + "");
                    wallet.setText(paymentProfile.getEwallet());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.DestPaymentSettings);
            }
        });

        return view;
    }
}
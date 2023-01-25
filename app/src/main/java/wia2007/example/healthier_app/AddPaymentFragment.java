package wia2007.example.healthier_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class AddPaymentFragment extends Fragment {

    TextInputEditText cnum, expdate, cvv;
    Button confirm;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://healthier-app-aed74-default-rtdb.asia-southeast1.firebasedatabase.app");
    DatabaseReference root = db.getInstance().getReference();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addpayment, container, false);

        Spinner dropdown = view.findViewById(R.id.e_wallet);
        String[] items = new String[]{"Touch\'N\'Go", "GrabPay", "Boost"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        cnum = view.findViewById(R.id.cardno);
        expdate = view.findViewById(R.id.cardexpire);
        cvv = view.findViewById(R.id.cvv);
        confirm = view.findViewById(R.id.confrimBtn);

        confirm.setOnClickListener(v -> {
            if (cnum.getText().toString().isEmpty() || expdate.getText().toString().isEmpty() || cvv.getText().toString().isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in the text fields", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(requireContext(), "Saved successfully", Toast.LENGTH_SHORT).show();
                String ewallet = dropdown.getSelectedItem().toString();
                String cardnum = cnum.getText().toString();
                String expired = expdate.getText().toString();
                int cvvcode = Integer.parseInt(cvv.getText().toString());

                HashMap<String, Object> paymentMap = new HashMap<>();
                paymentMap.put("ewallet", ewallet);
                paymentMap.put("cardnumber", cardnum);
                paymentMap.put("expirydate", expired);
                paymentMap.put("cvv", cvvcode);

                root.child("User").child(Objects.requireNonNull(firebaseAuth.getUid())).updateChildren(paymentMap);

                Navigation.findNavController(view).navigate(R.id.DestPayment);
            }
        });
        return view;
    }
}
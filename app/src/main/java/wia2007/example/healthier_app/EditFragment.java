package wia2007.example.healthier_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class EditFragment extends Fragment {

    TextInputEditText etusername, etname, etage, height, weight, phone;
    Spinner gender;
    Button confirm;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://healthier-app-aed74-default-rtdb.asia-southeast1.firebasedatabase.app");
    DatabaseReference root = db.getInstance().getReference();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        etusername = view.findViewById(R.id.userName);
        etname = view.findViewById(R.id.name);
        etage = view.findViewById(R.id.age);
        height = view.findViewById(R.id.height);
        weight = view.findViewById(R.id.etweight);
        phone = view.findViewById(R.id.phone);
        confirm = view.findViewById(R.id.confirmBtn);

        //get the spinner from the xml.
        Spinner dropdown = view.findViewById(R.id.gender);
        //create a list of items for the spinner.
        String[] items = new String[]{"Male", "Female"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etusername.getText().toString().isEmpty() || etname.getText().toString().isEmpty() ||
                        etage.getText().toString().isEmpty() || phone.getText().toString().isEmpty()) {
                    Toast.makeText(requireContext(), "Please fill in the text fields", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(requireContext(), "Saved successfully", Toast.LENGTH_SHORT).show();
                    String username = etusername.getText().toString();
                    String name = etname.getText().toString();
                    int age = Integer.parseInt(etage.getText().toString());
                    double high = Double.parseDouble(Objects.requireNonNull(height.getText()).toString());
                    double wigh = Double.parseDouble(Objects.requireNonNull(weight.getText()).toString());
                    String nump = phone.getText().toString();
                    String gender = dropdown.getSelectedItem().toString();

                    HashMap<String, Object> userMap = new HashMap<>();
                    userMap.put("username", username);
                    userMap.put("name", name);
                    userMap.put("age", age);
                    userMap.put("height", high);
                    userMap.put("weight", wigh);
                    userMap.put("phoneNumber", nump);
                    userMap.put("gender", gender);

                    root.child("User").child(Objects.requireNonNull(firebaseAuth.getUid())).updateChildren(userMap);

                    Navigation.findNavController(view).navigate(R.id.DestInfo);
                }

            }
        });


        return view;
    }
}
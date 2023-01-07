package wia2007.example.healthier_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        final EditText Uname = view.findViewById(R.id.userName);
        final EditText Mail = view.findViewById(R.id.email);
        final EditText Pass = view.findViewById(R.id.pass);
        final EditText ConfirmPass = view.findViewById(R.id.confirmpass);

        TextView alreadyHave= view.findViewById(R.id.signin);
        View.OnClickListener BtnNoAccOnClick= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.DestLogin);
            }
        };
        alreadyHave.setOnClickListener(BtnNoAccOnClick);

        Button RegBtn = view.findViewById(R.id.RegBtn);

        DAOUser dao = new DAOUser();
        RegBtn.setOnClickListener(v -> {
            if (Uname.getText().toString().isEmpty() || Mail.getText().toString().isEmpty() || Pass.getText().toString().isEmpty() || ConfirmPass.getText().toString().isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in the text fields", Toast.LENGTH_SHORT).show();
                return;
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(Mail.getText().toString(), Pass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    User user = new User(Uname.getText().toString(), Mail.getText().toString());

                    dao.add(user).addOnSuccessListener(suc -> {
                        Toast.makeText(requireContext(), "Account created successfully", Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(view).navigate(R.id.DestLogin);
                    }).addOnFailureListener(er -> {
                        Toast.makeText(requireContext(), "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(requireContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });


        return view;
    }
}
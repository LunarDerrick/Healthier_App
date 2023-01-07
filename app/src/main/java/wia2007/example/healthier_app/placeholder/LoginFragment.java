package wia2007.example.healthier_app.placeholder;

import android.content.Intent;
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

import wia2007.example.healthier_app.R;


public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText emailET = view.findViewById(R.id.email);
        EditText passwordET = view.findViewById(R.id.pass);
        Button loginButton = view.findViewById(R.id.loginBtn);

        TextView dontHave= view.findViewById(R.id.signin);
        View.OnClickListener BtnNoAccOnClick= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.DestRegister);
            }
        };
        dontHave.setOnClickListener(BtnNoAccOnClick);

        loginButton.setOnClickListener(view1 -> register(emailET.getText().toString(), passwordET.getText().toString(), view1));

        return view;
    }

    private void register(String email, String password, View view) {
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(requireContext(), "Please fill in both of the text fields", Toast.LENGTH_SHORT).show();
            return;
        }
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email.trim(), password.trim())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(requireContext(), "Login successfully!", Toast.LENGTH_SHORT).show();
                        // todo navigate to home page
                        // phang: hopefully this works, since I can't get login to work for me
                        Navigation.findNavController(view).navigate(R.id.DestHome);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(requireContext(), "Login Failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
package wia2007.example.healthier_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText Uname = findViewById(R.id.userName);
        final EditText Mail = findViewById(R.id.email);
        final EditText Pass = findViewById(R.id.pass);
        final EditText ConfirmPass = findViewById(R.id.confirmpass);
        Button RegBtn = findViewById(R.id.RegBtn);

        DAOUser dao = new DAOUser();

        RegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(Uname.getText().toString(),Mail.getText().toString(),
                        Pass.getText().toString(), ConfirmPass.getText().toString());

                /*
                dao.add(user).addOnSuccessListener(suc->{
                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT.).show();

                }).addOnFailureListener(er->{
                    Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                });
                 */

            }
        });
    }
}
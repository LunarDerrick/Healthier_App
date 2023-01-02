package wia2007.example.healthier_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class GeneralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
    }

    public void BtnNoAccOnClick(View view) {
        FragmentContainerView FCVRegister = findViewById(R.id.FCVRegister);
        FragmentContainerView FCVLogin = findViewById(R.id.FCVLogin);
        FCVRegister.setVisibility(View.VISIBLE);
        FCVLogin.setVisibility(View.GONE);
    }

    public void BtnHasAccOnClick(View view) {
        FragmentContainerView FCVRegister = findViewById(R.id.FCVRegister);
        FragmentContainerView FCVLogin = findViewById(R.id.FCVLogin);
        FCVRegister.setVisibility(View.GONE);
        FCVLogin.setVisibility(View.VISIBLE);
    }

    public void BtnLoginOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
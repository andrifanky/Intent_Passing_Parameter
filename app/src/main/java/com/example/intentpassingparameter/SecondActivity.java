package com.example.intentpassingparameter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tEmail, tPassword; // Mendeklarasikan variable dengan tipe data TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tEmail = findViewById(R.id.tvEmail);
        tPassword = findViewById(R.id.tvPassword);

        Bundle bundle = getIntent().getExtras();

        String email = bundle.getString("email");
        String password = bundle.getString("password");

        tEmail.setText(email);
        tPassword.setText(password);
    }
}
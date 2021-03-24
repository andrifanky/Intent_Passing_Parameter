package com.example.intentpassingparameter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Deklarasi variable untuk Button
    Button btnLogin;

    // Deklarasi variable untuk EditText
    EditText edtEmail, edtPassword;

    // Deklarasi variable untuk menyimpan email dan password
    String email, password;

    // Deklarasi variable untuk menyimpan user dan pass default
    String user = "admin@mail.com";
    String pass = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan variable dengan componen pada Layout
        btnLogin = findViewById(R.id.btnSignIn);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Menyimpan input user di EditText ke variable
                email = edtEmail.getText().toString();
                password = edtPassword.getText().toString();

                String message = ""; // Deklarasi variable message untuk ditampilkan di Toast

                if (email.isEmpty() || password.isEmpty()) { // Cek email atau password apakah kosong
                    message = "Email atau Password tidak boleh kosong!";
                } else if (email.equals(user) && password.equals(pass)) { // Cek email dan password apakah cocok
                    message = "Login Berhasil";

                    Bundle bundle = new Bundle(); // Membuat objek bundle

                    bundle.putString("email", email.trim()); // Memasukkan value dari variable email dengan kunci "email"
                    bundle.putString("password", password.trim()); // Memasukkan value dari variable password dengan kunci "password"

                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class); // Membuat objek intent berpindah activity dari MainActivity ke SecondActivity

                    intent.putExtras(bundle); // Memasukkan bundle

                    startActivity(intent); // Berpindah ke SecondActivity
                } else if (!email.equals(user) && !password.equals(pass)) { // Cek email dan password apakah tidak cocok
                    message = "Email dan Password salah!";
                } else if (!email.equals(user)) { // Cek email apakah tidak cocok
                    message = "Email yang Anda masukkan salah!";
                } else if (!pass.equals(user)) { // Cek password apakah tidak cocok
                    message = "Password salah!";
                } else { // Kesalahan lain
                    message = "Kesalahan!";
                }
                // Membuat variable toast dan menampilkan pesan dari variable message
                Toast t = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
                t.show(); // Menampilkan toast
            }
        });
    }
}
package com.example.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    private EditText email,pass;
    private Button letmein;
    private TextView forgotPass,signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginDetails();

    }
    private void loginDetails(){
        email=findViewById(R.id.email_login);
        pass=findViewById(R.id.password_login);
        letmein=findViewById(R.id.btn_login);
        forgotPass=findViewById(R.id.forgot_password);
        signUp=findViewById(R.id.new_account);

        letmein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=email.getText().toString().trim();
                String password=pass.getText().toString().trim();

                if(TextUtils.isEmpty(mail)){
                    email.setError("Email Required..");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    pass.setError("Password Required..");
                    return;
                }
            }
        });
        //new Account
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });

        //reset password activity
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ResetActivity.class));
            }
        });
    }
}
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

public class RegistrationActivity extends AppCompatActivity {
    private EditText email,newPass,confPass;
    private Button welcome;
    private TextView logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        registration();
    }
    private void registration(){
        email=findViewById(R.id.email_new);
        newPass=findViewById(R.id.password_new);
        confPass=findViewById(R.id.password_confirm);
        welcome=findViewById(R.id.btn_new);
        logIn=findViewById(R.id.sign_in);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=email.getText().toString().trim();
                String pass=newPass.getText().toString().trim();
                String conf=confPass.getText().toString().trim();

                if(TextUtils.isEmpty(mail)){
                    email.setError("Email Required..");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    newPass.setError("Password Required..");
                    return;
                }
                if(TextUtils.isEmpty(conf)){
                    confPass.setError("Confirm Password Required..");
                    return;
                }
                if(!pass.equals(conf)) {
                    confPass.setError("Password do not match!");
                }
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

    }
}
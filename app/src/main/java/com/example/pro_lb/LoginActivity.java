package com.example.pro_lb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private TextView signUp;
    private TextView x;
    private ImageView forgotPw;
    private Button LogIn;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signUp=(TextView)findViewById(R.id.textViewSignUp);
        x=(TextView) findViewById(R.id.textViewExit);
        forgotPw=(ImageView)findViewById(R.id.imageViewForgotPw);
        LogIn=(Button) findViewById(R.id.buttonLogIn);
        email=(EditText) findViewById(R.id.editTextEmil);
        password=(EditText) findViewById(R.id.editTextPw);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this , MainActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this , firstActivity.class);
                startActivity(intent);
                finishAffinity();


            }
        });

        forgotPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this , ForgotpassActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validate()){
                    //authenticate the user
                    String uEmail=email.getText().toString();
                    String uPassowrd=password.getText().toString();

                    mAuth.signInWithEmailAndPassword(uEmail,uPassowrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(LoginActivity.this , CheckemailActivity.class);
                                startActivity(intent);
                                finishAffinity();
                            }else {
                                Toast.makeText(LoginActivity.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
    private boolean validate(){
        boolean result=false;
        String uEmail=email.getText().toString();
        String uPassowrd=password.getText().toString();
        if(uEmail.isEmpty() || uPassowrd.isEmpty()){
            Toast.makeText(this,"Please enter all fucking details",Toast.LENGTH_SHORT).show();
        }
        else{
            result=true;
        }
        return result;
    }
}




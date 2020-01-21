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

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private TextView signIn;
    private TextView x;
    private Button LogUp;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        signIn=(TextView)findViewById(R.id.textViewSignIn);
        x=(TextView) findViewById(R.id.textViewExit);
        LogUp=(Button) findViewById(R.id.buttonLogUp);
        email=(EditText) findViewById(R.id.editTextEmil);
        password=(EditText) findViewById(R.id.editTextPw);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this , LoginActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this , firstActivity.class);
                startActivity(intent);
                finishAffinity();


            }
        });

        LogUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validate()){
                    //upload to database;
                    String uEmail=email.getText().toString();
                    String uPassowrd=password.getText().toString();
                    mAuth.createUserWithEmailAndPassword(uEmail,uPassowrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "User Created", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(MainActivity.this , CheckemailActivity.class);
                                startActivity(intent);
                                finishAffinity();
                            }else {
                                Toast.makeText(MainActivity.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                //Intent intent=new Intent(MainActivity.this , LoginActivity.class);
              //  startActivity(intent);
              //  finishAffinity();
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


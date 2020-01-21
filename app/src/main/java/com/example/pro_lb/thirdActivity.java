package com.example.pro_lb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class thirdActivity extends AppCompatActivity {

    private Button signIn;
    private ImageView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        signIn=(Button)findViewById(R.id.buttonSignIn);
        signUp=(ImageView)findViewById(R.id.imageViewSignUp);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(thirdActivity.this , LoginActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(thirdActivity.this , MainActivity.class);
                startActivity(intent);
                finishAffinity();


            }
        });
    }
}

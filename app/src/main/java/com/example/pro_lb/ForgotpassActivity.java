package com.example.pro_lb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ForgotpassActivity extends AppCompatActivity {


    private ImageButton bck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);

        bck=(ImageButton)findViewById(R.id.imageButtonBck);

        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ForgotpassActivity.this , LoginActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

    }
}

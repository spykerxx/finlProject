package com.example.pro_lb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class secondActivity extends AppCompatActivity {

    private Button next;
    private ImageView xkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        next=(Button)findViewById(R.id.buttonNext);
        xkip=(ImageView)findViewById(R.id.imageViewXkip);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(secondActivity.this , thirdActivity.class);
                startActivity(intent);
                // finish();
            }
        });

        xkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(secondActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}


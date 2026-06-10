package com.siddexpo.tictactoegame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class loading extends AppCompatActivity {

    TextView txt0 ,txtX , txt_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loading);

        txt0 = findViewById(R.id.txt0);
        txtX = findViewById(R.id.txtX);
        txt_logo = findViewById(R.id.txt_logo);

        txt0.animate()
                .alpha(1f)
                .rotation(360)
                .setDuration(800);

        txtX.animate()
                .alpha(1f)
                .rotation(-360)
                .setStartDelay(800)
                .setDuration(800);

        txt_logo.animate()
                .alpha(1f)
                .setStartDelay(1600)
                .setDuration(800);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(loading.this , frontActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
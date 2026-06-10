package com.siddexpo.tictactoegame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;

public class frontActivity extends AppCompatActivity {

    Button btnFront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_front);

        btnFront = findViewById(R.id.btnFront);

        Intent play = new Intent(frontActivity.this, MainActivity.class);

        btnFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(play);
            }
        });

        Animation pulse = AnimationUtils.loadAnimation(this,R.anim.pulse);
        btnFront.setAnimation(pulse);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
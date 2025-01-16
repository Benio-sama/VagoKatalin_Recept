package com.example.konyvtar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    private TextView recepttextview2;
    private TextView minosegtextview2;
    private TextView nehezsegtextview2;
    private TextView evtextview;
    private Button vissza;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    @SuppressLint("SetTextI18n")
    public void init() {
        recepttextview2 = findViewById(R.id.recepttextview2);
        minosegtextview2 = findViewById(R.id.minosegtextview2);
        nehezsegtextview2 = findViewById(R.id.nehezsegtextview2);
        evtextview = findViewById(R.id.evtextview);
        vissza = findViewById(R.id.vissza);
        Intent intent = getIntent();
        String recept = intent.getStringExtra("recept");
        int minoseg = intent.getIntExtra("minoseg", 0);
        int nehezseg = intent.getIntExtra("nehezseg", 0);
        recepttextview2.setText("Recept: " + recept);
        minosegtextview2.setText("Minoseg: " + minoseg);
        nehezsegtextview2.setText("Nehezseg: " + nehezseg);
        int ev = random.nextInt(2024 - 1000 + 1) + 1000;
        evtextview.setText("Ev: " + ev);
        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
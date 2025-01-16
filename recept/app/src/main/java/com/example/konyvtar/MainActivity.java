package com.example.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText receptedittext;
    private EditText minosegedittext;
    private EditText nehezsegedittext;
    private Button hozzaadas;
    private ListView receptlistview;
    private static List<Recept> receptlista = new ArrayList<>();
    private ReceptAdapter adapter = new ReceptAdapter(receptlista, MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        hozzaadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int minosegszam = 0;
                    int nehezsegszam = 0;
                    String recept = receptedittext.getText().toString();
                    String minoseg = minosegedittext.getText().toString();
                    String nehezseg = nehezsegedittext.getText().toString();
                    minosegszam = Integer.parseInt(minoseg);
                    nehezsegszam = Integer.parseInt(nehezseg);
                    if (minosegszam < 0 || minosegszam > 100) {
                            System.out.println("nem jo");
                            Toast.makeText(MainActivity.this, "a minoseg nem lehet kevesebb mint 0 es nem lehet nagyobb mint 100", Toast.LENGTH_SHORT).show();
                    } else if (nehezsegszam < 0 || nehezsegszam > 3) {
                        System.out.println("nem jo");
                        Toast.makeText(MainActivity.this, "a nehezseg nem lehet 0-nal kisebb se nagyobb 3-nal", Toast.LENGTH_SHORT).show();
                    } else {
                        receptlista.add(new Recept(recept, Integer.parseInt(minoseg), Integer.parseInt(nehezseg)));
                        receptlistview.setAdapter(adapter);
                        receptedittext.setText("");
                        minosegedittext.setText("");
                        nehezsegedittext.setText("");
                    }
                } catch (Exception e) {
                    //System.out.println(e);
                    Toast.makeText(MainActivity.this, "mindent ki kell tolteni", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void init() {
        receptedittext = findViewById(R.id.recepttext);
        minosegedittext = findViewById(R.id.minosegtext);
        nehezsegedittext = findViewById(R.id.nehezsegtext);
        hozzaadas = findViewById(R.id.hozzaadas);
        receptlistview = findViewById(R.id.receptlistview);
        receptlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Recept kivalasztott = receptlista.get(i);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("recept", kivalasztott.getRecept());
                intent.putExtra("minoseg", kivalasztott.getMinoseg());
                intent.putExtra("nehezseg", kivalasztott.getNehezseg());
                startActivity(intent);
            }
        });
    }
}
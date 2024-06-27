package com.example.juegoraqueta;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button comenzarBtn;

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

        comenzarBtn = findViewById(R.id.comenzarBtn);
        comenzarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Juego juego = new Juego(MainActivity.this);
                setContentView(juego);
            }
        });

        Display pantalla = getWindowManager().getDefaultDisplay();
        Point size = new Point();

        pantalla.getSize(size);

        int x = size.x;
        int y = size.y;

        Log.i("Pantalla", "ancho: " + x);
        Log.i("Pantalla", "alto: " + y);





    }
}
package com.example.a20_tarasenko;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {

    private ImageView carRed;
    private ImageView carPink;
    private Button btnStart;
    private Button btnDrive1;
    private Button btnDrive2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Находим UI элементы
        carRed = findViewById(R.id.carRed);
        carPink = findViewById(R.id.carPink);
        btnStart = findViewById(R.id.btnStart);
        btnDrive1 = findViewById(R.id.btnDrive1);
        btnDrive2 = findViewById(R.id.btnDrive2);

        // Обработка нажатия на "СТАРТ" - сброс позиций
        btnStart.setOnClickListener(v -> {
            carRed.setTranslationX(0);
            carPink.setTranslationX(0);
            Toast.makeText(this, "Гонка началась!", Toast.LENGTH_SHORT).show();
        });

        // Движение красной машины
        btnDrive1.setOnClickListener(v -> {
            carRed.setTranslationX(carRed.getTranslationX() + 40);
        });

        // Движение розовой машины
        btnDrive2.setOnClickListener(v -> {
            carPink.setTranslationX(carPink.getTranslationX() + 40);
        });
    }
}

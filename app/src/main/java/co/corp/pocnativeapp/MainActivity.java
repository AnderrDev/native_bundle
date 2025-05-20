package co.corp.pocnativeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Crear el botón
        Button openBundleBtn = new Button(this);
        openBundleBtn.setText("Abrir módulo React Native");
        openBundleBtn.setTextSize(18);
        openBundleBtn.setPadding(60, 30, 60, 30);

        // Acción al hacer clic
        openBundleBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, PoCModuleActivity.class);
            startActivity(intent);
        });

        // Layout para centrar el botón
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(32, 32, 32, 32);
        layout.addView(openBundleBtn);

        setContentView(layout);
    }
}

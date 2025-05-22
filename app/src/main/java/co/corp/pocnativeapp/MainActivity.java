package co.corp.pocnativeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EditText nameInput = new EditText(this);
        nameInput.setHint("Ingresa tu nombre");

        Button openBundleBtn = new Button(this);
        openBundleBtn.setText("Abrir módulo React Native");

        openBundleBtn.setOnClickListener(v -> {
            String nombre = nameInput.getText().toString();
            Bundle props = new Bundle();
            props.putString("nombre", nombre); // ✅ ahora es un Bundle real
            Intent intent = new Intent(this, PoCModuleActivity.class);
            intent.putExtra("bundleName", "app.bundle");
            intent.putExtra("moduleName", "PoCModule");
            intent.putExtra("props", props); // ✅ props como Bundle
            startActivity(intent);
        });

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(32, 32, 32, 32);
        layout.addView(nameInput);
        layout.addView(openBundleBtn);

        setContentView(layout);
    }
}

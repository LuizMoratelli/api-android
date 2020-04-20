package br.com.luizmoratelli.api_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);

        button = findViewById(R.id.button);

        addListeners();
    }

    private void addListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormActivity.this, "Not yet", Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.example.croquis;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private PlanoViewModel viewModel;
    private PlanoView planoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planoView = findViewById(R.id.plano_view);

        viewModel = new ViewModelProvider(this).get(PlanoViewModel.class);
        viewModel.getAmbientes().observe(this, ambientes -> {
            // Actualizar el plano con los ambientes
            planoView.setAmbientes(ambientes);
        });
    }
}
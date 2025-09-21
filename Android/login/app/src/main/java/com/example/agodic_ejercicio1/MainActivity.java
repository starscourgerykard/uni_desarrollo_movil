package com.example.agodic_ejercicio1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usuario, password;
    Button btnLogin, btnCancel;
    TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        mensaje = findViewById(R.id.mensaje);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuario.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("admin") && pass.equals("1234")) {
                    mensaje.setText("ACCESO CORRECTO");
                    mensaje.setBackgroundColor(Color.GREEN);
                    mensaje.setVisibility(View.VISIBLE);
                } else {
                    mensaje.setText("ACCESO DENEGADO");
                    mensaje.setBackgroundColor(Color.RED);
                    mensaje.setVisibility(View.VISIBLE);
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setText("");
                password.setText("");
                mensaje.setVisibility(View.GONE);
            }
        });
    }
}
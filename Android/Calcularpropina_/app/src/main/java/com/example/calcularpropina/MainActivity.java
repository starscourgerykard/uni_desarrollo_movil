package com.example.calcularpropina;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText d_totalCuenta;
    EditText d_numeroPersonas;
    RadioGroup radioGroupPropina;
    Button calcular;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //recuperar el vinculo con la interfaz
        d_totalCuenta=findViewById(R.id.totalCuenta);
        d_numeroPersonas=findViewById(R.id.numeroPersonas);
        radioGroupPropina=findViewById(R.id.radioGroupPropina);
        calcular=findViewById(R.id.calcular);
        resultado=findViewById(R.id.res);

        calcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double total=Double.parseDouble(d_totalCuenta.getText().toString());
                int personas=Integer.parseInt(d_numeroPersonas.getText().toString());

                double porcentajePropina = 0.10;
                int selectedId = radioGroupPropina.getCheckedRadioButtonId();
                if (selectedId == R.id.radio5) {
                    porcentajePropina = 0.05;
                } else if (selectedId == R.id.radio10) {
                    porcentajePropina = 0.10;
                } else if (selectedId == R.id.radio15) {
                    porcentajePropina = 0.15;
                }

                double propina = total * porcentajePropina;
                double totalConPropina = total + propina;
                double porPersona = totalConPropina / personas;

                resultado.setText(String.valueOf(porPersona));

            }


        });

    }
}
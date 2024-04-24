package com.example.ni_23024640_app_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Saude extends AppCompatActivity {

    EditText txtPeso, txtAltura;
    TextView resultadoIMC, situacao;
    Button btnCalcIMC,btnSair,btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        txtPeso = findViewById(R.id.editTextPeso);
        txtAltura = findViewById(R.id.editTextAltura);
        resultadoIMC = findViewById(R.id.textViewResultado);
        situacao = findViewById(R.id.textViewSituacao);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSair = findViewById(R.id.btnExit);
        btnCalcIMC = findViewById(R.id.btnCalcIMC);

        btnCalcIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcularImc();
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saude.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultadoIMC.setText("");
                situacao.setText("");
            }
        });
    }
    public void CalcularImc(){
        String PesoString = txtPeso.getText().toString();
        String AlturaString = txtAltura.getText().toString();

        if (PesoString.isEmpty() || AlturaString.isEmpty()) {
            resultadoIMC.setText("Por favor, insira o peso e a altura.");
            return;
        }

        double Peso = Double.parseDouble(PesoString);
        double Altura = Double.parseDouble(AlturaString);


        double imc = Peso / (Altura * Altura);



        resultadoIMC.setText("Seu IMC é: " + String.format("%.2f",imc));

        if (imc <= 18.5){
            situacao.setText("Abaixo do peso!");
        }else if( imc >= 18.6 && imc <= 24.9){
            situacao.setText("Peso Ideal!");
        } else if (imc >= 25 && imc <= 29.9) {
            situacao.setText("Levemente Acima do Peso!");
        } else if (imc >= 30 && imc <=34.9) {
            situacao.setText("Obesidade Grau I");
        } else if (imc >= 35 && imc <= 39.9) {
            situacao.setText("Obesidade Grau II (Severa)");
        } else {
            situacao.setText("Obesidade Grau III (Mórbido)");
        }

    }
}
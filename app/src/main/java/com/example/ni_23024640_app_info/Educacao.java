package com.example.ni_23024640_app_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Educacao extends AppCompatActivity {
    EditText N1, PI, PO;
    TextView Resultado;
    TextView Aprovacao;
    Button btnCalcMedia, btnSair, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educacao);
        N1 = findViewById(R.id.editTxtN1);
        PI = findViewById(R.id.editTxtPI);
        PO = findViewById(R.id.editTxtPO);
        Resultado = findViewById(R.id.txtResultado);
        Aprovacao = findViewById(R.id.aprovacao);
        btnCalcMedia = findViewById(R.id.btnCalcMedia);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSair = findViewById(R.id.btnExit);


        btnCalcMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calcularMedia();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resultado.setText("");
                Aprovacao.setText("");
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Educacao.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void calcularMedia(){

        String notaN1 = N1.getText().toString();
        String notaPI = PI.getText().toString();
        String notaPO = PO.getText().toString();
        Double media = Double.valueOf(0);


        if(notaN1.isEmpty()){
            N1.setError("Coloque um valor");
        } else{
            double n1Nota = Double.valueOf(notaN1);
            n1Nota = n1Nota * 0.20;
            media = media + n1Nota;
        }
        if(notaPI.isEmpty()){
            PI.setError("Coloque um valor");
        }else {
            double piNota = Double.valueOf(notaPI);
            piNota = piNota * 0.30;
            media = media + piNota;
        }
        if(notaPO.isEmpty()){
            PO.setError("Coloque um valor");
        } else{
            double poNota = Double.valueOf(notaPO);
            poNota = poNota * 0.50;
            media = media + poNota;
        }

        Resultado.setText("Sua media é " + String.format("%.2f", media));

        if (media < 6){
            Aprovacao.setText("Reprovado");
        }else{
            Aprovacao.setText("Aprovado");
        }




    }
    }

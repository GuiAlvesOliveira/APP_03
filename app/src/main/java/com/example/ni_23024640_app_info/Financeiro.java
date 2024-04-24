package com.example.ni_23024640_app_info;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Financeiro extends AppCompatActivity {
    EditText inputSalario;
    TextView salBruto;
    TextView desInss;
    TextView desFgts;
    TextView salLiq;
    Button btnCalcSalario, btnLimpar, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financeiro);

        inputSalario = findViewById(R.id.editTextSalary);
        salBruto = findViewById(R.id.textViewSalBruto);
        desInss = findViewById(R.id.textViewINSS);
        desFgts = findViewById(R.id.textViewFGTS);
        salLiq = findViewById(R.id.textViewSalLiq);

        btnCalcSalario = findViewById(R.id.btnCalculate);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSair = findViewById(R.id.btnExit);


        btnCalcSalario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularSalario();
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salBruto.setText("Salário Bruto:");
                desInss.setText("Desconto INSS:");
                desFgts.setText("Desconto FGTS:");
                salLiq.setText("Salário Líquido:");
            }
        });
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Financeiro.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void calcularSalario(){
        String getSalario = inputSalario.getText().toString();

        if (getSalario.isEmpty()){
            inputSalario.setError("Insira um valor");
            return;
        }
        double salario = Double.parseDouble(getSalario);
        double salarioINSS = Double.parseDouble(getSalario);
        double salarioFGTS = Double.parseDouble(getSalario);
        double salarioLiq = Double.parseDouble(getSalario);

        salarioFGTS = salarioFGTS * 0.08;

        if (salarioINSS <= 1420){
            salarioINSS = salarioINSS * 0.075;
        }else if (salarioINSS>1420.01 && salarioINSS<=2666.68){
            salarioINSS = salarioINSS * 0.09;
        }else if(salarioINSS > 2666.69 && salarioINSS<=4000.03){
            salarioINSS = salarioINSS * 0.12;
        }else if (salarioINSS > 4000.04 && salarioINSS <= 7786.02){
            salarioINSS = salarioINSS * 0.14;
        }else{
            salarioINSS = 0;
        }

        salBruto.setText("Salário Bruto: R$"+ String.format("%.2f", salario));
        desFgts.setText("Desconto FGTS: R$"+ String.format("%.2f", salarioFGTS));
        desInss.setText("Desconto INSS: R$" + String.format("%.2f", salarioINSS));
        salarioLiq = salarioLiq - salarioFGTS - salarioINSS;
        salLiq.setText("Salário Líquido: R$"+String.format("%.2f", salarioLiq));


    }
}
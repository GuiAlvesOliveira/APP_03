package com.example.ni_23024640_app_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnFinanceiro, btnEducacao, btnSaude, btnInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFinanceiro = findViewById(R.id.financeiro);
        btnEducacao = findViewById(R.id.educacao);
        btnSaude = findViewById(R.id.saude);
        btnInfo = findViewById(R.id.info);



    }

    public void telaFinanceiro(View view){
        Intent intent = new Intent(MainActivity.this, Financeiro.class);
        startActivity(intent);
    }
    public void telaEducacao(View view){
        Intent intent = new Intent(MainActivity.this, Educacao.class);
        startActivity(intent);
    }
    public void telaSaude(View view){
        Intent intent = new Intent(MainActivity.this, Saude.class);
        startActivity(intent);
    }
    public void telaInfo(View view){
        Intent intent = new Intent(MainActivity.this, Info.class);
        startActivity(intent);
    }



}
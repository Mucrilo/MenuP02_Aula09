package com.example.menup02_aula09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.menup02_aula09.databinding.ActivityIptuBinding;

public class ActivityIptu extends AppCompatActivity {
    private ActivityIptuBinding binding;
    private int opcao=0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iptu);
        binding=ActivityIptuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter adapter=ArrayAdapter.createFromResource(ActivityIptu.this,
            R.array.tipos, android.R.layout.simple_spinner_item);
        binding.spinner1.setAdapter(adapter);
        binding.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                opcao=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=binding.edtArea.getText().toString();
                double area=Double.parseDouble(str);
                double valor=area;
                switch (opcao){
                    case 0:
                        valor=30*valor;
                        break;
                    case 1:
                        valor=25*valor;
                        break;
                    case 2:
                        valor=40*valor;
                        break;
                }
                binding.txtValor.setText("Valor: "+Double.toString(valor));
            }
        });
    }
}
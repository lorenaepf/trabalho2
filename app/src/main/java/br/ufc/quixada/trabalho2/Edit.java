package br.ufc.quixada.trabalho2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {

    EditText modeloEdt;
    EditText anoEdt;
    EditText placaEdt;


    ImageButton botaozin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        botaozin = findViewById(R.id.button);
        modeloEdt = findViewById(R.id.modeloEdit);
        anoEdt = findViewById(R.id.anoEdit);
        placaEdt = findViewById(R.id.placaEdit);

        Intent intent = getIntent();
        Carro carrito = (Carro) intent.getSerializableExtra("input");

        iniciar(carrito);


    }

    public void iniciar(Carro c){
        modeloEdt.setText(c.getModelo());
        anoEdt.setText(c.getAno());
        placaEdt.setText(c.getPlaca());

        botaozin.setOnClickListener(new View.OnClickListener() {
            String modeloEdt1 = modeloEdt.getText().toString();
            String anoEdt1 = anoEdt.getText().toString();
            String placaEdt1 = placaEdt.getText().toString();
            @Override
            public void onClick(View view) {

               editar(c);
            }
        });
    }

    public void enviar(Carro carrin){
        Intent i = new Intent();
        i.putExtra("key",carrin);
        setResult(RESULT_OK, i);
        finish();

    }

    public void editar(Carro c){
        String modeloEdt1 = modeloEdt.getText().toString();
        String anoEdt1 = anoEdt.getText().toString();
        String placaEdt1 = placaEdt.getText().toString();
        int id = c.getId();
        Carro carrin =  new Carro(modeloEdt1,placaEdt1,anoEdt1,id);
        enviar(carrin);
    }

}
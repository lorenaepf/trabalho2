package br.ufc.quixada.trabalho2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    ArrayList<Carro> listcarro = new ArrayList<>();
    ListView list;
    ImageButton btn;
    ArrayAdapter adapter;

    EditText modelo;
    EditText ano;
    EditText placa;

    EditText find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listcarro);

        modelo = findViewById(R.id.edtText1);
        ano = findViewById(R.id.edtText2);
        placa = findViewById(R.id.edtText3);

        list =  findViewById(R.id.listview);
        list.setAdapter(adapter);

        find = findViewById(R.id.procurarid);

        btn =  findViewById(R.id.btnEdit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int findtext = Integer.parseInt(find.getText().toString());
                    Intent intent=new Intent(MainActivity.this, Edit.class);
                    for(int i = 0; i < listcarro.size();i++){
                        if(findtext == listcarro.get(i).getId()){

                            intent.putExtra("input",listcarro.get(findtext));
                            startActivityForResult(intent,10);
                    }else if(findtext != listcarro.get(i).getId()){
                            Toast.makeText(MainActivity.this, "ID não encontrado", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });

    }

    public void addCarro(View v){

    String modelo1 = modelo.getText().toString();
    String ano1 = ano.getText().toString();
    String placa1 = placa.getText().toString();
    int id = listcarro.size();
    Carro c = new Carro(modelo1, ano1, placa1,id);
    listcarro.add(c);

    modelo.setText("");
    ano.setText("");
    placa.setText("");

    }
    public void limparLista( View view ){
        listcarro.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10){
            if (resultCode == MainActivity.RESULT_OK){
                Carro c = (Carro)data.getSerializableExtra("key");
                listcarro.get(c.getId()).setModelo(c.getModelo());
                listcarro.get(c.getId()).setAno(c.getAno());
                listcarro.get(c.getId()).setPlaca(c.getPlaca());
                adapter.notifyDataSetChanged();

            }else if(resultCode == MainActivity.RESULT_CANCELED){
                Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
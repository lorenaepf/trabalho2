package br.ufc.quixada.trabalho2;

import java.io.Serializable;

public class Carro implements Serializable {
    String modelo;
    String placa;
    String ano;
    int id;

    public Carro(String modelo, String placa, String ano, int id) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }



    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public void setId(int id){
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + "\n" + "id: " + id;
    }
}

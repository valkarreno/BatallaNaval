package com.example.barcos;

import java.util.List;

public class Barco {
    private int tipo;

    // 1 para un barco de 1 posición, 2 para uno de 2 posiciones, etc.
    private List<Integer> posiciones;

    public Barco(int tipo, List<Integer> posiciones) {
        this.tipo = tipo;
        this.posiciones = posiciones;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<Integer> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(List<Integer> posiciones) {
        this.posiciones = posiciones;
    }
}

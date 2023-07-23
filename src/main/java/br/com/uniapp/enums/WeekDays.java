package br.com.uniapp.enums;

public enum WeekDays {

    SEGUNDA("SEGUNDA", 1), TERCA("TERÇA", 2), QUARTA("QUARTA", 3), QUINTA("QUINTA", 4);

    private final int valor;
    private final String dia;

    private WeekDays(String dia, int valor) {
        this.dia = dia;
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    public String getDia(){
        return this.dia;
    }

}


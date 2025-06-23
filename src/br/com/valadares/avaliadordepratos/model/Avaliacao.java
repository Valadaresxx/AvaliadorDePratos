package br.com.valadares.avaliadordepratos.model;

public class Avaliacao {
    private String cliente;
    private String comentario;
    private int nota;

    public Avaliacao(String cliente, int nota, String comentario) {
        this.cliente = cliente;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return " " + cliente + ": " + comentario + " -  Nota:" + nota;
    }
}

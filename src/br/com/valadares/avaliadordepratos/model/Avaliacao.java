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

    public String getCliente() {
        return cliente;
    }

    public String getComentario() {
        return comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Avaliacao" + "\n" +
                " cliente = " + cliente +"\n" +
                " comentario = " + comentario +"\n" +
                " nota = " + nota +"\n";
    }
}

package br.com.valadares.avaliadordepratos.model;

public class Prato {
    private String nome;
    private String restaurante;
    private String tipo;
    private Avaliacao avaliacao;

    public void adicionarAvaliacao(Avaliacao a){
        this.avaliacao = a;
    }

    public double calcularMedia(){
        return 0;
    }

}

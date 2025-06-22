package br.com.valadares.avaliadordepratos.model;

import java.util.ArrayList;
import java.util.List;

public class Prato {
    private String nome;
    private String restaurante;
    private String descricao;
    private List<Avaliacao> avaliacao = new ArrayList<>();

    public Prato(String nome, String restaurante, String descricao) {
        this.nome = nome;
        this.restaurante = restaurante;
        this.descricao = descricao;
    }

    public void adicionarAvaliacao(Avaliacao a){
        this.avaliacao.add(a);
    }

    public double calcularMedia(){
        return 0;
    }

    public String getNome() {
        return nome;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    @Override
    public String toString() {
        return "Prato\n" +
                " nome = " + nome + "\n" +
                " restaurante = " + restaurante +"\n" +
                " descricao = " + descricao +"\n"
                + avaliacao +"\n";
    }
}

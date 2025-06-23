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
        if(avaliacao.isEmpty()){
            return 0.0;
        }
        double soma = 0;
        for (Avaliacao a : avaliacao){
            soma += a.getNota();
        }
        return soma / avaliacao.size();
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Prato: ").append(nome).append("\n");
        sb.append("Restaurante: ").append(restaurante).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n\n");

        if (avaliacao.isEmpty()) {
            sb.append("Sem avaliações no momento.\n");
        } else {
            sb.append("Avaliações:\n");
            for (Avaliacao a : avaliacao) {
                sb.append(a).append("\n");
            }
        }
        sb.append("\nMédia das avaliações: ").append(String.format("%.2f", calcularMedia()));
        sb.append("\n-----------------------------\n");

        return sb.toString();
    }
}

package br.com.valadares.avaliadordepratos.service;

import br.com.valadares.avaliadordepratos.model.Avaliacao;

import java.util.Scanner;

public class AvaliacaoService {
    public static Avaliacao avaliarPrato(Scanner s){

        System.out.println("Nome do cliente que vai avaliar: ");
        String nomeA = s.nextLine();

        System.out.println("Sua nota: ");
        int notaA = s.nextInt();
        s.nextLine();

        System.out.println("Comentario: ");
        String comentarioA = s.nextLine();

        return new Avaliacao(nomeA, notaA, comentarioA);
    }
}

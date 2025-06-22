package br.com.valadares.avaliadordepratos.service;

import br.com.valadares.avaliadordepratos.model.Prato;
import java.util.Scanner;

public class PratoService {

    public static Prato criarPrato(Scanner s){
        System.out.println("Nome do prato: ");
        String nomeP = s.nextLine();

        System.out.println("Restaurante: ");
        String restauranteP = s.nextLine();

        System.out.println("Descrição: ");
        String descricaoP = s.nextLine();

        return new Prato(nomeP, restauranteP, descricaoP);
    }
}

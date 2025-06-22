package br.com.valadares.avaliadordepratos.app;

import br.com.valadares.avaliadordepratos.model.Avaliacao;
import br.com.valadares.avaliadordepratos.model.Prato;
import br.com.valadares.avaliadordepratos.service.AvaliacaoService;
import br.com.valadares.avaliadordepratos.service.PratoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void exibirMenu() {
        boolean continuar = true;
        Scanner s = new Scanner(System.in);
        List<Prato> listaDePratos = new ArrayList<>();

        while (continuar) {
            System.out.println("------Menu------");
            System.out.println("1- Adicione um prato");
            System.out.println("2- Avalie um prato");
            System.out.println("3- Cardapio ");
            System.out.println("4- Carpadio com avaliações");
            System.out.println("5- Sair");
            System.out.println("----------------");
            int escolha = s.nextInt();
            s.nextLine();

            switch (escolha){
                case 1:
                    listaDePratos.add(PratoService.criarPrato(s));
                    break;
                case 2:
                    if (listaDePratos.isEmpty()){
                        System.out.println("Sem nenhum prato para avaliar");
                    }else{
                        System.out.println("Qual prato quer avaliar:");
                        for (int i = 0; i < listaDePratos.size(); i++) {
                            System.out.println(i+1 +" - " + listaDePratos.get(i).getNome());
                        }
                        int indice = s.nextInt();
                        s.nextLine();
                        if (indice >= 0 && indice <= listaDePratos.size()){
                            Avaliacao nova = AvaliacaoService.avaliarPrato(s);
                            listaDePratos.get(indice-1).adicionarAvaliacao(nova);
                            System.out.println("Avaliação adicionada! ");
                        }else {
                            System.out.println("Numero do prato errado!");
                        }
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    continuar = false;
                       break;

            }

        }
    }
}

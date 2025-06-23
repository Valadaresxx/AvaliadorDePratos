package br.com.valadares.avaliadordepratos.app;

import br.com.valadares.avaliadordepratos.model.Avaliacao;
import br.com.valadares.avaliadordepratos.model.Prato;
import br.com.valadares.avaliadordepratos.service.AvaliacaoService;
import br.com.valadares.avaliadordepratos.service.PratoService;
import br.com.valadares.avaliadordepratos.service.ListaService;
import br.com.valadares.avaliadordepratos.util.Entrada;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void exibirMenu() {
        boolean continuar = true;
        Scanner s = new Scanner(System.in);
        List<Prato> listaDePratos = ListaService.carregarPratos();

        while (continuar) {
            System.out.println("------Menu------");
            System.out.println("1- Adicione um prato");
            System.out.println("2- Avalie um prato");
            System.out.println("3- Cardapio ");
            System.out.println("4- Excluir ");
            System.out.println("5- Sair e Salvar");
            System.out.println("----------------");
            int escolha = Entrada.lerInteiro(s);
            if (escolha < 1 || escolha > 5){
                System.out.println("Opção invalida!");
            }

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
                        int indice = Entrada.lerInteiro(s);
                        if (indice >= 0 && indice <= listaDePratos.size()){
                            Avaliacao nova = AvaliacaoService.avaliarPrato(s);
                            listaDePratos.get(indice-1).adicionarAvaliacao(nova);
                            System.out.println("Avaliação adicionada! ");
                        }else {
                            System.out.println("Numero do prato invalido!");
                        }
                    }
                    break;
                case 3:
                    for (Prato lista:listaDePratos){
                        System.out.println(lista.toString());
                    }
                    break;
                case 4:
                    ListaService.excluir(s, listaDePratos);
                    break;
                case 5:
                    ListaService.salvarPratos(listaDePratos);
                    continuar = false;
                       break;

            }

        }
    }
}

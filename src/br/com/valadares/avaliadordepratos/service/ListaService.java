package br.com.valadares.avaliadordepratos.service;

import br.com.valadares.avaliadordepratos.model.Avaliacao;
import br.com.valadares.avaliadordepratos.model.Prato;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaService {
    public static void salvarPratos(List<Prato> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Pratos.json"))) {
            Gson gson = new GsonBuilder().setPrettyPrinting()
                    .create();
            String json = gson.toJson(lista);
            writer.write(json);
            System.out.println("Arquivo salvo!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Prato> carregarPratos() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Prato> lista = new ArrayList<>();
        File file = new File("Pratos.json");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                Type tipoLista = new TypeToken<List<Prato>>() {
                }.getType();
                lista = gson.fromJson(reader, tipoLista);
                if (lista == null) {
                    lista = new ArrayList<>();
                }
            } catch (IOException e) {
                throw new RuntimeException("Erro ao carregar Pratos " + e);
            }
        } else {
            System.out.println("Arquivo de pratos não encontrado. Iniciando lista vazia.");
        }
        return lista;
    }

    public static void excluir(Scanner s, List<Prato> lista) {
        System.out.println("Oque deseja excluir?" +
                "\nPrato - Digite 1" +
                "\nAvalição - Digite 2");
        int excluirEscolha = s.nextInt();
        s.nextLine();

        if (excluirEscolha < 1 || excluirEscolha > 2) {
            System.out.println("Opção indisponivel");
        } else {
            switch (excluirEscolha) {
                case 1:
                    System.out.println("Qual prato que excluir? ");
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(i + 1 + " - " + lista.get(i).getNome());
                    }
                    int excluirPrato = s.nextInt();
                    if (excluirPrato < 1 || excluirPrato > lista.size()) {
                        System.out.println("Prato indisponivel! ");
                    } else {
                        lista.remove(excluirPrato - 1);
                        System.out.println("Prato removido do cardapio!");
                    }
                    break;
                case 2:

                    System.out.println("A avaliação de qual prato deseja excluir? ");
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(i + 1 + " - " + lista.get(i).getNome());
                    }
                    int pratoEscolhido = s.nextInt();
                    s.nextLine();

                    if (pratoEscolhido < 1 || pratoEscolhido > lista.size()) {
                        System.out.println("Esse prato não existe!");
                    } else {
                        List<Avaliacao> avaliacoes = lista.get(pratoEscolhido - 1).getAvaliacao();
                        if (avaliacoes.isEmpty()) {
                            System.out.println("Não tem avaliação");
                        }

                        for (int i = 0; i < avaliacoes.size(); i++) {
                            System.out.println(i + 1 + "-" + avaliacoes.get(i));
                        }
                        System.out.println("Qual avaliação deseja excluir? ");
                        int excluiAvaliacao = s.nextInt();
                        if (excluiAvaliacao < 1 || excluiAvaliacao > avaliacoes.size()){
                            System.out.println("Numero de Avaliação errado!");
                        }else{
                            avaliacoes.remove(excluiAvaliacao - 1);
                            System.out.println("avaliaçao excluida! ");
                        }
                    }
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }
}

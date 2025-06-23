package br.com.valadares.avaliadordepratos.service;

import br.com.valadares.avaliadordepratos.model.Prato;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
                if (lista == null){
                        lista = new ArrayList<>();
                }
            } catch (IOException e) {
                throw new RuntimeException("Erro ao carregar Pratos " + e);
            }
        }else{
            System.out.println("Arquivo de pratos não encontrado. Iniciando lista vazia.");
        }
        return lista;
    }
}

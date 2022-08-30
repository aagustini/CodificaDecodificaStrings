package Codificadores;

import java.util.Arrays;

public class Codifica21100411 implements Codifica{

    @Override
    public String codifica(String str) {
        //Transforma a String em bytes
        String cod = "";
        byte[] bytes = str.getBytes();
        String teste = Arrays.toString(bytes);
        teste = teste.replace(",", "");
        teste = teste.replace("[", "");
        teste = teste.replace("]", "");
        cod = teste;
        return cod;
    }

    @Override
    public String decodifica(String str) {
        //Decodifica a String pegando os valores dos bytes
        //ERRO: Não reconheçe a partir do "ç"
        String dec = "";
        String[] separa = str.split(" ");
        for (String s : separa) {
            int resultado = Integer.parseInt(s);
            String frase = Character.toString(resultado);
            System.out.println(frase);
            dec = frase;
        }
        return dec;
    }

    @Override
    public String getMatriculaAutor() {
        return "21100411-4";
    }

    @Override
    public String getNomeAutor() {
        return "Eduardo Eichner";
    }
}
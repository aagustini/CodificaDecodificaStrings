package Codificadores;

import java.util.Random;

public class Codifica21100417 implements Codifica {
    private static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";

    @Override
    public String codifica(String str) {
        String codificada = "";
        Random r = new Random();
        // adiciona um caracter gerado aleatoriamente ao lado direito
        // de cada caracter/espaço
        for (char c : str.toCharArray()) {
            int random = r.nextInt(chars.length());
            codificada += c;
            codificada += chars.charAt(random);
        }
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String decodificada = "";
        // remove o caracter aleatorio de cada caracter
        for (int i = 0; i < str.length(); i += 2) {
            decodificada += str.charAt(i);
        }
        return decodificada;
    }

    @Override
    public String getNomeAutor() {
        return "Eduardo Balzan";
    }

    @Override
    public String getMatriculaAutor() {
        return "21100417-1";
    }
}
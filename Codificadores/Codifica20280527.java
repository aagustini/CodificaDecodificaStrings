package Codificadores;

public class Codifica20280527 implements Codifica {
    private static String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
    private static String alfabetoReverso = "zyxwvutsrqponmlkjihgfedcba0987654321ZYXWVUTSRQPONMLKJIHGFEDCBA";
 
    @Override
    public String codifica(String str) {
        String codificada = "";

        for (char c : str.toCharArray()) {
            Boolean temReverso = false;
            for (int i = 0; i < alfabeto.length(); i++) {
                if (c == alfabeto.charAt(i)) {
                    codificada += alfabetoReverso.charAt(i);
                    temReverso = true;
                }
            }
            if (!temReverso) {
                codificada += c;
            }
        }
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String decodificada = "";

        for (char c : str.toCharArray()) {
            Boolean temReverso = false;
            for (int i = 0; i < alfabetoReverso.length(); i++) {
                if (c == alfabetoReverso.charAt(i)) {
                    decodificada += alfabeto.charAt(i);
                    temReverso = true;
                }
            }
            if (!temReverso) {
                decodificada += c;
            }
        }
        return decodificada;
    }

    @Override
    public String getMatriculaAutor() {
        return "20280527";
    }

    @Override
    public String getNomeAutor() {
        return "Gabriela Zorzo";
    }

}
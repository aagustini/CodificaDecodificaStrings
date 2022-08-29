package Codificadores;

import java.util.ArrayList;

public class Codifica21100552 implements Codifica
{
    private static String tabela = "01234567890aAíÍbBcCdDeEfFúÚgGhHiIéÉjJkKlLmMnNoOpPqQrRsSóÓtTuUvVwWxXyYzZçCáÁàÀ:().,{}";

    @Override
    public String getNomeAutor() {
        return "Gabriel Isdra Moszkowicz";
    }

    @Override
    public String getMatriculaAutor() {
        return "21100552";
    }

    @Override
    public String codifica(String str) {
        ArrayList<Integer> spacing = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String string : str.split(" ")) {
            spacing.add(string.length());
            for (int index = 0; index < string.length(); index++) {
                int pos = tabela.indexOf(string.charAt(index));
                char c = tabela.charAt((pos + string.length())%tabela.length());//(char)(string.charAt(index) + string.length());
                sb.append(c);    
                System.out.println(string.charAt(index) + " -> " + c + " -> " + (int) c);
            }
        }
        int cumulative = 0;
        for (int i = spacing.size() - 1; i >= 0; i--) {
            cumulative += spacing.get(i); 
            sb.insert(cumulative, ' ');
            cumulative++;
        }
        System.out.println(sb.toString());
        System.out.println(str);
        return sb.toString();
    }

    @Override
    public String decodifica(String str) {
        ArrayList<Integer> spacing = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String string : str.split(" ")) {
            spacing.add(string.length());
            sb.append(string);
        }
        int cumulative = 0;
        for (int i = spacing.size() - 1; i > 0; i--) {
            cumulative += spacing.get(i); 
            sb.insert(cumulative, ' ');
            cumulative++;
        }

        cumulative = 0;
        for (String string : sb.toString().split(" ")) {
            for (int index = 0; index < string.length(); index++) {
                int pos = tabela.indexOf(string.charAt(index)) - string.length();
                char c = tabela.charAt(pos >= 0? pos%tabela.length(): string.length() - pos);//(char)(string.charAt(index) + string.length());
                sb.setCharAt(index + cumulative, c);   
                System.out.println(string.charAt(index) + " -> " + c + " -> " + (int) c);
            }
            cumulative += string.length() + 1;
        }
        System.out.println(sb.toString());
        System.out.println(str);
        return sb.toString();
    }
}
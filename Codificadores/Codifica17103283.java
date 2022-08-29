package Codificadores;

public class Codifica17103283 implements Codifica {

    private static int i = (int) (Math.random() * (127 - 0)) + 0;

    @Override
    public String codifica(String str) {

        System.out.println("char: " + i);

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
             sb.append(c += i);
        }

        return sb.toString();
    }

    @Override
    public String decodifica(String str) {

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append(c -= i);

        }

        return sb.toString();
    }

    @Override
    public String getMatriculaAutor() {
        return "17103283";
    }

    @Override
    public String getNomeAutor() {
        return "Marco Ames";
    }

}
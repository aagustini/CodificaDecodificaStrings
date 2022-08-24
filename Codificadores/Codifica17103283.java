package Codificadores;

public class Codifica17103283 implements Codifica {

    @Override
    public String codifica(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    @Override
    public String decodifica(String str) {
       
        return new StringBuilder(str).reverse().toString();
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
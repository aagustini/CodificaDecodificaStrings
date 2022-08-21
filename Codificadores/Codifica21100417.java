package Codificadores;

public class Codifica21100417 implements Codifica {

    @Override
    public String codifica(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    @Override
    public String decodifica(String str) {
        return new StringBuilder(str).reverse().toString();
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
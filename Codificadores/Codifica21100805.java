package Codificadores;
import java.util.Random;

public class Codifica21100805 implements Codifica {

    private String caracterAleatorio = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890áéíãõ{}[]():+-=?/!.,#@$%&*"; 




    @Override
    public String codifica(String str) {
        Random random = new Random();
        char[] codificada = new char[str.length()*3];
        int numAdc = 0;
        for(int i = 0; i < codificada.length; i++){
            if(i == 0 || i % 3 == 0){
                codificada[i] = str.charAt(numAdc);
                numAdc++;
            }
        }
        for(int j = 0; j < codificada.length; j++){
            if(j != 0 && j % 3 != 0){
                codificada[j] = caracterAleatorio.charAt(random.nextInt(caracterAleatorio.length()));
            }
        }
        String strCod = new String(codificada);
        return strCod;
    }

    @Override
    public String decodifica(String str) {
        String descodificada = "";

        for(int i = 0; i < str.length(); i++){
            if(i == 0 || i %3 == 0){
                descodificada += str.charAt(i);
            }
        }
        return descodificada;
    }

    @Override
    public String getMatriculaAutor() {
        return "21100805-7";
    }

    @Override
    public String getNomeAutor() {
        return "João Pedro Feijó";
    }

}
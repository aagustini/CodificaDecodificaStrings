package Codificadores;

import java.lang.invoke.CallSite;
import java.util.Random;

public class Codifica21100194 implements Codifica {

    @Override
    public String codifica(String str){


        String Resultado = "";
        String[] aux = str.split("");
        for(int i = 0; i < aux.length; i++){
            switch (aux[i]){
                case "a":
                    Resultado += "b";
                    break;
                case "b":
                    Resultado += "a";
                    break;
                case "c":
                    Resultado += "d";
                    break;
                case "d":
                    Resultado += "c";
                    break;
                case "e":
                    Resultado += "f";
                    break;
                case "f":
                    Resultado += "e";
                    break;
                case "g":
                    Resultado += "h";
                    break;
                case "h":
                    Resultado += "g";
                    break;
                case "i":
                    Resultado += "j";
                    break;
                case "j":
                    Resultado += "i";
                    break;
                case "k":
                    Resultado += "l";
                    break;
                case "l":
                    Resultado += "k";
                    break;
                default:
                    Resultado += aux[i];
                    break;
            };
        }

        return Resultado;
    }

    public String decodifica(String str){
        //aqui ele chama o método codifica, pois é a mesma coisa.
        return codifica(str);
    }

    @Override
    public String getMatriculaAutor() {
        return "21100194";
    }

    @Override
    public String getNomeAutor() {
        return "Bernardo Fiorini";
    }


}
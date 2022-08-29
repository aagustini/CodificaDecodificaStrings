package Codificadores;

import java.util.Random;

public class Codifica21103800 implements Codifica{

    @Override
    public String getNomeAutor() {
        return "Eduardo Menegaz Pretto";
    }

    @Override
    public String getMatriculaAutor() {
        return "21103800-5";
    }

    @Override
    public String codifica(String str) {
        char aux[] = str.toCharArray();
        StringBuilder resultado = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < aux.length; i ++){
            //adiciona 1 ao valor correspondente a cada letra da palavra na tabela ascii
            resultado.append(Character.toChars(aux[i] + 1)); 
            if ((i % 3) == 0){//apos cada posicao da string correspondente a um numero multiplo de tres, acrescenta tres caracteres aleatorios
                for (int j = 0; j < 3; j++){
                    resultado.append(Character.toChars(r.nextInt(106) + 20));
                }
            }
        }

        return resultado.toString();
    }

    @Override
    public String decodifica(String str) {
        char aux[] = str.toCharArray();
        StringBuilder resultado = new StringBuilder();
        int i = 0;
        while (i<aux.length){
            resultado.append(Character.toChars(aux[i] - 1));//diminui 1 ao valor correspondente a cada letra da palavra na tabela ascii
            if ((i % 3) == 0){//ao encontrar um numero multiplo de tres pula as tres posicoes seguintes, que correspondem a caracteres aleatorios
                i += 3;
            }
            i++;
        }
        return resultado.toString();
    }
    
}

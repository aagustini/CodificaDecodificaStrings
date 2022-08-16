package Codificadores;

import java.util.Random;

public class MeuCodificador implements Codifica{

     @Override
     public String getNomeAutor() {
          return "Giovanni Schenato";
     }

     @Override
     public String getMatriculaAutor() {
          return "21100627";
     }

     @Override
     public String codifica(String str) {
          Random rand = new Random();
          String codificado = "";
          for(Character c : str.toCharArray()){
               for(char binario : Integer.toString(c, 2).toCharArray()){
                    for(int i = 0; i < rand.nextInt(4); i++)
                         codificado += (rand.nextInt(6) + 2);
                    codificado += binario; 
                    for(int i = 0; i < rand.nextInt(1); i++)
                         codificado += (rand.nextInt(6) + 2);
               }
               codificado+="9";
          }
          return codificado;
     }

     @Override
     public String decodifica(String str) {
          String original = "";
          String aux = "";
          for(char c : str.toCharArray()){
               if(c == '9'){
                    original += (char) Integer.parseInt(aux, 2);
                    aux = "";
                    continue;
               }
               else if (c == '0' || c == '1')
                    aux += c;
          }
          return original;
     }     
}
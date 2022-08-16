package Codificadores;

import java.util.ArrayList;
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
          int pos = -1;
          for(Byte b : str.getBytes()){
               pos++;
               if(b < 0){
                    codificado += str.substring(pos, pos+1);
                    continue;
               }
               String bin = Integer.toBinaryString(b);
               String newBin = "";
               for(char s : bin.toCharArray()){
                    String val = "" + (rand.nextInt(6) + 2);
                    newBin += s+val;
               }
               codificado+=newBin + "9";
          }
          return codificado;
     }

     @Override
     public String decodifica(String str) {
          ArrayList<ArrayList<String>> bins2 = new ArrayList<>();
          ArrayList<String> bins = new ArrayList<>();
          String bin = "";
          String t = "";
          for(char v : str.toCharArray()){
               t+=v;
               if(v == '0' || v == '1') bin += v;
               else if(v == '9'){
                    bins.add(bin);
                    System.out.println("Teta");
                    System.out.println(bin);
                    bin = "";
               }  
               else if(Character.isLetter(v)){
                    System.out.println("TO QUI");
                    System.out.println(bin);
                    if(bins.size() > 0)bins2.add(bins);
                    ArrayList<String> temp = new ArrayList<>();
                    bin += v;
                    temp.add(bin);
                    bins2.add(temp);
                    bins = new ArrayList<>();
                    bin = "";
               }
          }
          bins2.add(bins);
          System.out.println(t.replaceAll("[2-8]", "").replace('9', ' '));

          String original = "";
          for (ArrayList<String> a : bins2) {
               System.out.println(a);
               if(Character.isDigit(a.get(0).charAt(0)))
                    original += a.stream()
                              .map(binario -> Integer.parseInt(binario, 2))
                              .map(value -> Character.toString(value))
                              .reduce("", (c1, c2) -> c1 + c2);
               else
                    for(String s : a) original+=s;
          }

          return original;
     }     
}
import java.util.ArrayList;
import java.util.Random;

import Codificadores.Codifica;

public class Teste{

     public static void main(String[] args) {
          codifica("A");
     }

     public static String codifica(String str) {
          Random rand = new Random();
          String codificado = "áéíóúãõâêîôûç";	
          int pos = -1;
          String bin = "";
          for(Character c : codificado.toCharArray()){
               for(char b : Integer.toString(c, 2).toCharArray()){
                    bin += b; 
                    for(int i = 0; i < rand.nextInt(4); i++)
                         bin += (rand.nextInt(6) + 2);
                    // bin += (rand.nextInt(6) + 2);
               }
               bin+="9";
          }
          System.out.println(bin);
          String result = "";
          String aux = "";
          for(char c : bin.toCharArray()){
               if(c == '9'){
                    result += (char) Integer.parseInt(aux, 2);
                    aux = "";
                    continue;
               }
               else if (c == '0' || c == '1'){
                    aux += c;
               }
          }

          System.out.println(result);
     
          // for(Byte b : str.getBytes(Charset.forName("UTF-8"))) {
          //      pos++;
          //      System.out.println(str.charAt(pos));
          //      if(b < 0){
          //           System.out.println(b + "  " + str.charAt(pos));
          //           codificado += str.substring(pos, pos+1);

          //           continue;
          //      }
          //      String bin = Integer.toBinaryString(b);
          //      String newBin = "";
          //      for(char s : bin.toCharArray()){
          //           String val = "" + (rand.nextInt(6) + 2);
          //           newBin += s+val;
          //      }
          //      codificado+=newBin + "9";
          // }
          return codificado;
     }

     // public String decodifica(String str) {
     //      ArrayList<ArrayList<String>> bins2 = new ArrayList<>();
     //      ArrayList<String> bins = new ArrayList<>();
     //      String bin = "";
     //      String t = "";
     //      for(char v : str.toCharArray()){
     //           // System.out.println(v);
     //           t+=v;
     //           if(v == '0' || v == '1') bin += v;
     //           else if(v == '9'){
     //                bins.add(bin);
     //                // System.out.println("Teta");
     //                System.out.println(bin);
     //                System.out.println(Character.toString(Integer.parseInt(bin, 2)));
     //                bin = "";
     //           }  
     //           else if(Character.isLetter(v)){
     //                System.out.println("TO QUI");
     //                System.out.println(v);
     //                // System.out.println(bin);
     //                if(bins.size() > 0)bins2.add(bins);
     //                ArrayList<String> temp = new ArrayList<>();
     //                bin += v;
     //                temp.add(bin);
     //                bins2.add(temp);
     //                bins = new ArrayList<>();
     //                bin = "";
     //           }
     //      }
     //      bins2.add(bins);
     //      System.out.println(t.replaceAll("[2-8]", "").replace('9', ' '));

     //      String original = "";
     //      for (ArrayList<String> a : bins2) {
     //           System.out.println(a);
     //           if(Character.isDigit(a.get(0).charAt(0)))
     //                original += a.stream()
     //                          .map(binario -> Integer.parseInt(binario, 2))
     //                          .map(value -> Character.toString(value))
     //                          .reduce("", (c1, c2) -> c1 + c2);
     //           else
     //                for(String s : a) original+=s;
     //      }

     //      return original;
     // }     
}
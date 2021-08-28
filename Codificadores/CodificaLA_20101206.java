package Codificadores;

public class CodificaLA_20101206 implements Codifica {
 
    @Override
    public String codifica(String str) {

        String strReversa = new StringBuilder(str).reverse().toString();

        String strCodificada = "";

        for(int i=0; i<str.length(); i++){

            strCodificada += String.valueOf(str.charAt(i)) + String.valueOf(strReversa.charAt(i));
        }
        return strCodificada;
    }

    @Override
    public String decodifica(String str) {
       
        String strDecodificada = "";

        for(int i=0; i<str.length();i+=2){
            strDecodificada += String.valueOf(str.charAt(i));
        }
        return strDecodificada;
    }

    @Override
    public String getMatriculaAutor() {
        return "20101206";
    }

    @Override
    public String getNomeAutor() {
        return "Lucas A.";
    }

}

// L u c a s   A n d r e o t t i 
//  i t t o e r d n A   s a c u L 

// Liutcaose rAdnndAr esoatctuiL






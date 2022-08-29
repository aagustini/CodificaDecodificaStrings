package Codificadores;


public class Codifica21101567 implements Codifica{
    @Override 
    public String getNomeAutor(){
        return "Sophia Chaiben Furini";
    }
    @Override
    public String getMatriculaAutor(){
        return "21101567";
    }
    @Override
    public String codifica(String str){
        String codificada = "";
        int code;
        for(int i = 0; i < str.length(); i++){
           if(str.charAt(i) == ' '){
               codificada += ' ';
           }
           //Codifica a frase fazendo uma operação de shift left de 3 caracteres    
           else{
               code = (int)str.charAt(i);
               codificada += (char)(code + 3);
           }
        }
        return codificada;
    }
    @Override
    public String decodifica(String str){
        String decodificada = "";
        int decode;
        for(int i = 0; i < str.length(); i++){
           if(str.charAt(i) == ' '){
               decodificada += ' ';
           }
           //Decodifica a frase fazendo uma operação de shift right de 3 caracteres    
           else{
               decode = (int)str.charAt(i);
               decodificada += (char)(decode - 3);
           }
        }
        return decodificada;
    }
}

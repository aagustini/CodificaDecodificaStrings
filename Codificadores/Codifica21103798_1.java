package Codificadores;

public class Codifica21103798_1 implements Codifica {
 
    private static char[][] regras = {{'a','e'},{'b','y'},{'c','j'},{'d','a'},{'e','l'},{'f','p'},{'g','t'},{'h','s'},{'i','z'},
                                      {'j','r'},{'k','o'},{'l','x'},{'n','n'},{'m','u'},{'o','b'},{'p','w'},{'q','c'},{'r','q'},
                                      {'s','d'},{'t','f'},{'u','i'},{'v','m'},{'w','h'},{'x','v'},{'y','g'},{'z','k'},{'0','8'},
                                      {'1','3'},{'2','0'},{'3','4'},{'4','1'},{'5','9'},{'6','2'},{'7','6'},{'8','5'},{'9','7'},
                                      {' ','ç'},{'ç','{'},{'{','/'},{'/',' '},{'}',':'},{':','}'}};

    @Override
    public String codifica(String str) {

        // Nesta etapa é modificado a String de entrada conforme as regras definidas na variável 'regras'
        char[] etapa1 = str.toCharArray();
        for(int i = 0; i < etapa1.length; i++){
            for(int j = 0; j < 42; j++){
                if((etapa1[i]+"").equals(regras[j][0]+"")){
                    etapa1[i]=regras[j][1];
                    break;
                }
            }
        }

        // Nesta etapa é invertido a String resultante da primeira etapa
        String etapa2 = new StringBuilder(String.valueOf(etapa1)).reverse().toString();

        // Por fim para cada caractere é diminuido em 1 do seu respectivo valor na tabela ascii
        char[] etapa3 = etapa2.toCharArray();
        for(int i = 0; i < etapa3.length; i++){
            etapa3[i] = (char)((int)etapa3[i]-1);
        }

        return String.valueOf(etapa3);
    }

    @Override
    public String decodifica(String str) {
       
        // Para cada caractere da String de entrada soma 1 na sua referencia da tabela ascii
        char[] etapa1 = str.toCharArray();
        for(int i = 0; i < etapa1.length; i++){
            etapa1[i] = (char)((int)etapa1[i]+1);
        }

        // Inverte a String resultante da etapa 1
        String etapa2 = new StringBuilder(String.valueOf(etapa1)).reverse().toString();

        // Aplica as regras da variável 'regras', ao contrário
        char[] etapa3 = etapa2.toCharArray();
        for(int i = 0; i < etapa3.length; i++){
            for(int j = 0; j < 42; j++){
                if((etapa3[i]+"").equals(regras[j][1]+"")){
                    etapa3[i]=regras[j][0];
                    break;
                }
            }
        }

        return String.valueOf(etapa3);
    }

    @Override
    public String getMatriculaAutor() {
        return "21103798-1";
    }

    @Override
    public String getNomeAutor() {
        return "Eduardo Machado Martins";
    }
}
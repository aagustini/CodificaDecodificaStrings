package Codificadores;

public class Codifica21100255 implements Codifica {
    private String antigosCaracteres = "";

    @Override
     public String codifica(String str) {
        // Reestrutura a string do nome do autor
        String nomeMaiusculoSemEspacos = getNomeAutor().replace(" ", "").toLowerCase();
        char[] aux = str.toCharArray();
        
        int j = 0;
        // Substitui pelas letras do nome do autor nas posições pares
        for(int i = 0; i < aux.length; i++){
            if (i % 2 == 0) {
                // Armazena os valores a serem substituídos
                antigosCaracteres += aux[i];
                aux[i] = nomeMaiusculoSemEspacos.charAt(j);
                j++;
                // Caso acabem as letras do nome do autor, volta para o início do nome
                if (j == nomeMaiusculoSemEspacos.length()) {
                    j = 0;
                }
            }
        }
        String codificada = new String(aux);
        return codificada;
     }

     @Override
     public String decodifica(String str) {
        char[] aux = str.toCharArray();
        int j = 0;

        // Substitui de volta nas posições pares a partir da variável que tem as letras antigas armazenadas
        for (int i = 0; i < aux.length; i++) {
            if (i % 2 == 0) {
                aux[i] = antigosCaracteres.charAt(j);
                j++;
            }
        }
        String decodificada = new String(aux);
        return decodificada;
     }

    @Override
     public String getNomeAutor() {
          return "Camila da Costa Ilges";
     }

     @Override
     public String getMatriculaAutor() {
          return "21100255";
     }
}
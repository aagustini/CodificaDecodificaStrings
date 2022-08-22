package Codificadores;

public class CodificaTabajara implements Codifica{

    @Override
    public String getNomeAutor() {
        return "Gabriel Tabajara dos Santos";
    }

    @Override
    public String getMatriculaAutor() {
        return "21100560-8";
    }

    @Override
    public String codifica(String str) {
        //Inverte a String
        String reverseString = new StringBuilder(str).reverse().toString();
        String[] letras = reverseString.split(""); 
        StringBuilder novaString = new StringBuilder();

        //Pega o valor da letra na tabela ascii soma 10 e adiciona ele na string codificada
        //Após isso concatena mais 10 caracteres aleatórios para cada letra codificada depois dela 
        for(int i = 0; i < letras.length; i++){
            int posLetra = letras[i].charAt(0);
            char[] letraReal = Character.toChars((posLetra + 10));
            novaString.append(letraReal);

            for(int j = 0; j < 10; j++){
                int posComplicando = 0;

                while(posComplicando < 31 || posComplicando > 255) {
                    posComplicando = (int) (Math.random() * 255);
                }
            
                char[] complicando = Character.toChars(posComplicando);
                novaString.append(complicando);
            }
        }
        return novaString.toString();
    }

    @Override
    public String decodifica(String str) {
        //Desenverte a String
        String reverseString = new StringBuilder(str).reverse().toString();
        String[] letras = reverseString.split(""); 

        //Subtrai 10 do valor da letra na tabela ascii e adiciona na string decodificada
        //Depois pula os caracteres aleatórios e faz o mesmo com a próxima letra
        StringBuilder antigaString = new StringBuilder();
        //Começa na pos = 10 pois como invertemos a string os 10 primeiros caracteres são aleatórios
        for(int i = 10; i < letras.length; i+=11){
            int posLetra = letras[i].charAt(0);
            char[] letraReal = Character.toChars((posLetra - 10));
            antigaString.append(letraReal);
        }
        return antigaString.toString();
    }
    
}

//@autor Gabriel Silverio

package Codificadores;

public class Codifica20106468 implements Codifica{

    String abcInv = "9876543210zyxwvutsrqponmlkjihgfedcba ZYXWVUTSRQPONMLKJIHGFEDCBA";
    final int aux = 2;
    
    //Metodo para codificar
    @Override  
    public String codifica(String str) {        
        StringBuilder encoded = new StringBuilder();
        //for que passa pela String enviada a este metodo
        for(int i=0; i<str.length();i++){          
            //for que passa pela string abcInv
            for(int j=0; j<abcInv.length();j++){     
                //if para verificar se a str(i) é igual a abcInv(j)
                if(str.charAt(i) == abcInv.charAt(j)){
                    // para codificar, multipliquei a posicao da letra em abcInv por 2 e armazenei em x
                    // caso o valor ultrapasse o tamanho de abcInv, eu utilizei o resto da divisão do x por abcInv.length()
                    // EX: G esta na posição 57, neste caso 57*2 é 114, 114%63 é 51
                    // na posicao 51 temos a letra M            
                    int x=aux*(j+1);
                    if(x>=abcInv.length()){
                        x = x % abcInv.length();
                    }
                    encoded.append(abcInv.charAt(x-1));
                }
            }            
        }        
        return encoded.toString();
    }  

    //metodo para decodificar
    @Override
    public String decodifica(String str) {  
        StringBuilder decoded = new StringBuilder();    
        for(int i=0; i<str.length();i++){          
            for(int j=0; j<abcInv.length();j++){
                // para decodificar fiz o processo inverso
                if(str.charAt(i) == abcInv.charAt(j)){
                    int x;
                    // se j+1 for um numero negativo, sei que para codificar foi feito pelo menos 1 volta completa em abcInv
                    // Neste caso devo somar j com o tamanho de abcInv e dividir por aux(2), tendo assim a posicao da letra na palavra original
                    if(((j+1)%aux)==1){
                        x = (j+abcInv.length())/aux;
                    }
                    // se j for um numero par, entao sei que não foi feita nenhuma volta completa no abcInv
                    // neste caso, apenas divido por 2, tendo como resultado a posição original da letra da palavra original
                    else{
                        x = j/aux;
                    }
                    decoded.append(abcInv.charAt(x));
                }
            }            
        }        
        return decoded.toString();
    }
    @Override
    public String getMatriculaAutor() {
        return "20106468";
    }
    @Override
    public String getNomeAutor() {
        return "Gabriel Silverio";
    }    
}
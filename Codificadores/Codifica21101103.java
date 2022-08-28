package Codificadores;
import java.util.Arrays;

public class Codifica21101103 implements Codifica {
    private static String[] jogadoresTimao = {
        "Rafael Ramos", "Bambu", "Gil", "Maycon", "Piton", "Ranato Augusto", "Yuri Alberto", "Roger Guedes", 
        "Giuliano", "Cassio", "Paulinho", "Ramiro", "Junior Moraes", "Mosquito",
        "Mateus Vital", "Carlos Miguel", "Fagner", "Cantillo", "Fabio Santos", "Bruno Mendez", "Bruno Melo", "Adson", "Roni",
        "Balbuena", "Matheus Doneli", "Fausto Vera", "Raul Gustavo", "Ruan Oliveira", "Du Queiroz", "Leo Natel", "Xavier"
    };
    private static String[] conversaoNumeros = {
        "Tinga simulando penalti", "DVD", "Brasileiro 2009", "Copa do Brasil 2009", "Edenilsoooon 41 anos", "Yuri Alberto",
        "2 Mundiais", "1 Libertadores", "7 Brasileiros", "3 Copas Do Brasil"
    };

    @Override
    public String codifica(String str) {
        String codificada = "";
        for (char s : str.toCharArray()) {
            int ascii = (int) s;
            if (ascii > 127) {
                codificada += s;
                continue;
            }

            if (ascii > 95){
                int n = ascii - 95;
                codificada += "|" + jogadoresTimao[n] + "|";
            }else if(Character.isDigit(s)){
                int sInt = s - '0';
                codificada += "{" + conversaoNumeros[sInt] + "{";
            } else {
                codificada += s;
            }
        }
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String decodificada = "";
        boolean buscando = false;
        String b = "";
        for (char s : str.toCharArray()) {
            int ascii = (int) s;
            if (!buscando && ascii > 127) {
                decodificada += s;
                continue;
            }

            if (ascii == 123 || ascii == 124){
                if (!buscando) {
                    b = "";
                    buscando = true;
                }else if (buscando) {
                    if (ascii == 123){
                        int getIndex = Arrays.asList(conversaoNumeros).indexOf(b);
                        decodificada += getIndex;
                    } else {
                        int getIndex = Arrays.asList(jogadoresTimao).indexOf(b);
                        decodificada += (char)(95+getIndex);
                    }
                    buscando = false;
                    b = "";
                    continue;
                }
            } else {
                b += s;
            }

            if (!buscando) decodificada+=s;
            
        }
        return decodificada;
    }

    @Override
    public String getMatriculaAutor() {
        return "21101103-6";
    }

    @Override
    public String getNomeAutor() {
        return "Guilherme Romanini";
    }

}
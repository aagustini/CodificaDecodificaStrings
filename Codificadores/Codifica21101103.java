package Codificadores;

public class Codifica21101103 implements Codifica {
    private static String[] jogadoresTimao = {
        "Rafael Ramos", "Bambu", "Gil", "Maycon", "Piton", "Ranato Augusto", "Yuri Alberto", "Roger Guedes", 
        "Giuliano", "Cassio", "Paulinho(Nem lembrava que ainda esta lá)", "Ramiro", "Junior Moraes", "Mosquito",
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
                int n = ascii - 96;
                codificada += "|" + jogadoresTimao[n] + "|";
            }else if(Character.isDigit(s)){
                int sInt = s - '0';
                codificada += "{" + conversaoNumeros[sInt] + "}";
            } else {
                codificada += s;
            }
        }
        return codificada;
    }

    @Override
    public String decodifica(String str) {
        String decodificada = "";
        for (char s : str.toCharArray()) {
            int ascii = (int) s;
            if (ascii > 127) {
                codificada += s;
                continue;
            }
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
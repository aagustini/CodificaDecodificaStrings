package Codificadores;

public class CodificaSplit implements Codifica {

    @Override
    public String getNomeAutor() {

        return "LeonardoLerschForner";
    }

    @Override
    public String getMatriculaAutor() {

        return "21100996-04";
    }

    @Override
    public String codifica(String str) {
        char[] string = str.toCharArray();
        int ascii = 0;
        int count = 0;
        char ascii_c = 'a';

        for (char s : string) {
            ascii = (int) s;
            if (ascii > 36) {
                ascii -= 4;
            }
            ascii_c = (char) ascii;
            string[count] = ascii_c;
            count++;

        }
        String codificado = new String(string);
        return codificado;
    }

    @Override
    public String decodifica(String str) {
        char[] string = str.toCharArray();
        int ascii = 0;
        int count = 0;
        char ascii_c = 'a';

        for (char s : string) {
            ascii = (int) s;
            if (ascii > 36) {
                ascii += 4;
            }
            ascii_c = (char) ascii;
            string[count] = ascii_c;
            count++;

        }
        String codificado = new String(string);
        return codificado;
    }
}

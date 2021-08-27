package Codificadores;

import java.util.HashMap;

/**
 * Codifica19111109.java
 *
 * @author Anderson Sprenger
 * @matricula 19111109-5
 */

public class Codifica19111109 implements Codifica {

    /** Dicionario com os caracteres que vão substituir os da frase original na frase codificada. */
    private final HashMap<Character, Character> encoder;
    /** Dicionario com os caracteres que foram substituídos na frase codificada que retornarão na frase decodificada. */
    private final HashMap<Character, Character> decoder;

    /**
     * Construtor da classe Codifica19111109.
     *
     * Inicializa os dicionários encoder e decoder com os caracteres usados para a substituição na frase original.
     */
    public Codifica19111109() {
        encoder = new HashMap<>();
        decoder = new HashMap<>();

        encoder.put('a', 'ᚨ');
        encoder.put('b', 'β');
        encoder.put('c', 'γ');
        encoder.put('d', 'ᛞ');
        encoder.put('e', 'ᛖ');
        encoder.put('f', 'ᚠ');
        encoder.put('g', 'ᚷ');
        encoder.put('h', 'η');
        encoder.put('i', 'ћ');
        encoder.put('j', 'ѧ');
        encoder.put('k', 'ѿ');
        encoder.put('l', 'ᛚ');
        encoder.put('m', 'ш');
        encoder.put('n', 'ᚾ');
        encoder.put('o', 'ᛟ');
        encoder.put('p', 'ᛈ');
        encoder.put('q', 'ӕ');
        encoder.put('r', 't');
        encoder.put('s', 'ᛋ');
        encoder.put('t', 'ᛏ');
        encoder.put('u', 'ᚢ');
        encoder.put('v', 'ß');
        encoder.put('w', 'ᚹ');
        encoder.put('x', 'ξ');
        encoder.put('y', 'ю');
        encoder.put('z', 'ᛉ');

        encoder.put('0', '十');
        encoder.put('1', '一');
        encoder.put('2', '二');
        encoder.put('3', '三');
        encoder.put('4', '四');
        encoder.put('5', '五');
        encoder.put('6', '六');
        encoder.put('7', '七');
        encoder.put('8', '八');
        encoder.put('9', '九');

        decoder.put('ᚨ', 'a');
        decoder.put('β', 'b');
        decoder.put('γ', 'c');
        decoder.put('ᛞ', 'd');
        decoder.put('ᛖ', 'e');
        decoder.put('ᚠ', 'f');
        decoder.put('ᚷ', 'g');
        decoder.put('η', 'h');
        decoder.put('ћ', 'i');
        decoder.put('ѧ', 'j');
        decoder.put('ѿ', 'k');
        decoder.put('ᛚ', 'l');
        decoder.put('ш', 'm');
        decoder.put('ᚾ', 'n');
        decoder.put('ᛟ', 'o');
        decoder.put('ᛈ', 'p');
        decoder.put('ӕ', 'q');
        decoder.put('t', 'r');
        decoder.put('ᛋ', 's');
        decoder.put('ᛏ', 't');
        decoder.put('ᚢ', 'u');
        decoder.put('ß', 'v');
        decoder.put('ᚹ', 'w');
        decoder.put('ξ', 'x');
        decoder.put('ю', 'y');
        decoder.put('ᛉ', 'z');

        decoder.put('十', '0');
        decoder.put('一', '1');
        decoder.put('二', '2');
        decoder.put('三', '3');
        decoder.put('四', '4');
        decoder.put('五', '5');
        decoder.put('六', '6');
        decoder.put('七', '7');
        decoder.put('八', '8');
        decoder.put('九', '9');
    }

    /**
     * Substitui os caracteres da frase original por suas ocorrências no dicionário encoder.
     * @param str da frase original.
     * @return a string da frase codificada.
     */
    @Override
    public String codifica(String str) {
        return stringWorks(str, encoder);
    }

    /**
     * Substitui os caracteres da frase codificada por suas ocorrências no dicionário decoder.
     * @param str da frase codificada.
     * @return a string da frase decodificada.
     */
    @Override
    public String decodifica(String str) {
        return stringWorks(str, decoder);
    }

    /**
     * Recebe uma String str cujos caracteres são iterados e substituídos pelas ocorrências onde os cujos são a chave
     * no HashMap dictionary.
     *
     * @param str é a String a ser modificada.
     * @param dictionary é o dicionario que sera usado para a troca dos caracteres.
     * @return uma String com os caracteres modificados conforme o HashMap.
     */
    private String stringWorks(String str, HashMap<Character, Character> dictionary) {
        StringBuilder builder = new StringBuilder(str);

        for (int i = 0; i < str.length(); i++) {
            if (dictionary.containsKey(builder.charAt(i))) {
                builder.setCharAt(i, dictionary.get(builder.charAt(i)));
            }
        }

        return builder.reverse().toString();
    }

    /**
     * @return o nome do autor do codigo.
     */
    @Override
    public String getNomeAutor() {
        return "Anderson Sprenger";
    }

    /**
     * @return matricula do autor do código na melhor universidade do Brasil.
     */
    @Override
    public String getMatriculaAutor() {
        return "19111109";
    }
}
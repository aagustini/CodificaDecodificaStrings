package Codificadores;

import java.util.Random;

public class Codifica151042165 implements Codifica {
    private static final int MAX = 126;
    private static final int MIN = 33;


    @Override
    public String getNomeAutor() {
        return "Gregorio Ramos";
    }

    @Override
    public String getMatriculaAutor() {
        return "151042165";
    }

    @Override
    public String codifica(String str) {
        StringBuilder builder = new StringBuilder();

        int sign = str.charAt(0);
        Random random = new Random((long) sign * sign);

        builder.append(converte(sign * sign, random)).append(" ");
        for (int i = 1; i < str.length(); i++) {
            int rnd = random.nextInt(sign * sign);
            builder.append(converte(str.charAt(i) * rnd, random)).append(" ");
        }
        builder.replace(builder.length() - 1, builder.length(), "");

        return builder.toString();
    }

    @Override
    public String decodifica(String str) {
        StringBuilder builder = new StringBuilder();

        String[] split = str.split(" ");

        int sign = (int) Math.sqrt(desconverte(split[0], null));
        Random random = new Random((long) sign * sign);
        desconverte(split[0], random);

        builder.append((char) sign);
        for (int i = 1; i < split.length; i++) {
            int rnd = random.nextInt(sign * sign);
            builder.append((char) (desconverte(split[i], random) / rnd));
        }

        return builder.toString();
    }

    private static String converte(int i, Random random) {
        StringBuilder builder = new StringBuilder();

        int remaining = i;
        while (remaining > 0) {
            if (remaining <= MAX) {
                builder.append((char) remaining);
                break;
            }

            int rnd = random.nextInt(MAX - MIN + 1) + MIN;
            remaining -= rnd;
            builder.append((char) rnd);
        }

        return builder.toString();
    }

    private static int desconverte(String str, Random random) {
        int total = 0;

        for (int i = 0; i < str.length(); i++)
            total += str.charAt(i);

        if (random != null) {
            int remaining = total;
            while (remaining > 0) {
                if (remaining <= MAX) {
                    break;
                }

                int rnd = random.nextInt(MAX - MIN + 1) + MIN;
                remaining -= rnd;
            }
        }

        return total;
    }
}

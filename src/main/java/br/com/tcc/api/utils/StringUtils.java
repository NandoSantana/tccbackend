package br.com.tcc.api.utils;

public class StringUtils {

    private StringUtils() {
    }

    static String[] separarString(String string, String valorSeparar){
        return string.split(valorSeparar);
    }

    /**
     * Verifica se a string é nulo ou vazio ou seu tamanho = 0
     */
    public static Boolean isNuloVazio(String valor) {
        return valor == null || valor.isEmpty();
    }
    /**
     * Verifica se a string não é nula ou vazio ou seu tamanho > 0
     */
    public static Boolean isNotNuloVazio(String valor) {
        return !isNuloVazio(valor);
    }

}

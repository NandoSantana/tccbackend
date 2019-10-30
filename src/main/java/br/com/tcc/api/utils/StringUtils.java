package br.com.tcc.api.utils;

public class StringUtils {

    private StringUtils() {
    }

    /**
     * Verifica se a string é nulo ou vazio ou seu tamanho = 0
     */
    public static Boolean isNuloVazio(String valor) {
        Boolean retorno = false;
        if (valor == null || valor.isEmpty() || valor.length() == 0) {
            retorno = true;
        }
        return retorno;
    }
    /**
     * Verifica se a string não é nula ou vazio ou seu tamanho > 0
     */
    public static Boolean isNotNuloVazio(String valor) {
        return !isNuloVazio(valor);
    }

}

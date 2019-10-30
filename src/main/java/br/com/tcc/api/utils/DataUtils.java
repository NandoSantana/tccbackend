package br.com.tcc.api.utils;

import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static br.com.tcc.api.utils.StringUtils.isNuloVazio;

public class DataUtils {

    private DataUtils() {
    }

    public static String formataData(Date data) {
        if (data == null) {
            return null;
        } else {
            return new SimpleDateFormat("dd/MM/yyyy").format(data);
        }
    }

    public static Date formataData(String data) throws Exception {
        if (isNuloVazio(data)) {
            return null;
        }
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat(
                    "dd/MM/yyyy");
            date = formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

}

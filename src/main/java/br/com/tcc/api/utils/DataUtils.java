package br.com.tcc.api.utils;

import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static br.com.tcc.api.utils.StringUtils.isNuloVazio;
import static br.com.tcc.api.utils.StringUtils.separarString;
import static java.lang.Integer.parseInt;

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

    public static String formataDataHora(Date data) {
        if (data == null) {
            return null;
        } else {
            String dataString = new SimpleDateFormat("dd/MM/yyyy").format(data);
            String horaString = new SimpleDateFormat("hh:mm:ss").format(data);
            return dataString + " às " + horaString;
        }
    }

    public static Date formataData(String data) {
        if (isNuloVazio(data)) {
            return null;
        }
        Calendar calendario = new GregorianCalendar();
        String[] separarData = separarString(data, "T");
        String[] separar = separarString(separarData[0], "-");
        calendario.set( parseInt(separar[0]), parseInt(separar[1]) - 1, parseInt(separar[2]));
        return calendario.getTime();
    }
}

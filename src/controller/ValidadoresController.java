package controller;

import com.sun.xml.internal.ws.util.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author frede
 */
public class ValidadoresController {

    private static final int[] pesoCpf = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    public ValidadoresController() {
    }

    public String validaNome(String nome) {
        nome = nome.toLowerCase();
        String[] nomeSeparado = nome.split("\\s+");
        nome = "";
        for (String s: nomeSeparado) {           
            nome += s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
        }
        
        return nome.trim();
    }

    public String validaSexo(String stringSexo) {

        stringSexo = (stringSexo.equals("1") ? "Fem." : (stringSexo.equals("2") ? "Masc." : "Nda."));
        return stringSexo;
    }

    public String validaCpf(String stringCpf) {

        return ((validoCpf(stringCpf) ? stringCpf : stringCpf + "*"));
    }

    public String validaDataNasc(String stringDataNasc) {
        SimpleDateFormat formataControle = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat formataView = new SimpleDateFormat("dd/MM/yyyy");
        String stringRetorno = "";
        Date dataFormatada = null;
        try {
            dataFormatada = formataControle.parse(stringDataNasc);
            stringRetorno = formataView.format(dataFormatada);
        } catch (ParseException e) {
            System.out.println("Data inválida: " + stringDataNasc);
            stringRetorno = stringDataNasc + "*";
        }
        return stringRetorno;
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean validoCpf(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCpf);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCpf);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }
}

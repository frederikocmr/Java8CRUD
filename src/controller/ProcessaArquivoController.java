package controller;

import java.util.ArrayList;
import model.AlunoModel;

/**
 *
 * @author frede
 */
public class ProcessaArquivoController {

    public static ArrayList<AlunoModel> leitura() {
        ArrayList<AlunoModel> ap = new ArrayList<AlunoModel>();
        
        String teste = "JOSE DA SILVA12345678901;";
        teste += "MARIA PEREIRA98765432100";
        
        String v[] = teste.split(";");
        
        int tamanho = teste.length();
        
        for (int i = 0; i < v.length; i++) {

            String nome = v[i].substring(0, 13);
            String cpf = v[i].substring(13);
            
            AlunoModel p = new AlunoModel();
            
            p.setNome(nome);
            
            p.setCpf(cpf);
            
            ap.add(p);

        }

        return ap;
    }
}

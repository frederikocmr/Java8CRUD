package controller;

import java.util.ArrayList;
import model.AlunoModel;

/**
 *
 * @author frede
 */
public class ProcessaArquivoController {

    public static String leitura(String textoDoArquivo) {
        ArrayList<AlunoModel> ap = new ArrayList();

        String v[] = textoDoArquivo.split(";"); 
        //JOAO_________02366549180;JOSE DA SILVA12345678901;

        for (int i = 0; i < v.length; i++) {

            String nome = v[i].substring(0, 13);
            String cpf = v[i].substring(13);

            AlunoModel p = new AlunoModel();

            p.setNome(nome);

            p.setCpf(cpf);

            ap.add(p);

        }

        return ProcessaArquivoController.montaDadosImpressao(ap);
    }

    public static String montaDadosImpressao(ArrayList<AlunoModel> pessoas) {
        String impressao = "Relacao de Pessoas Cadastradas:" + "\n";
        impressao += "==============================" + "\n";

        for (int i = 0; i < pessoas.size(); i++) {
            AlunoModel p = new AlunoModel();
            p = pessoas.get(i);
            impressao += "Nome=" + p.getNome() + " - " + p.getCpf() + "\n";
            impressao += "------------------------------" + "\n";
        }
        
        return impressao;

    }
}

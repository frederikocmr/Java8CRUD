package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import model.AlunoModel;
import model.DisciplinaModel;

/**
 *
 * @author frede
 */
public class ProcessaArquivoController {
    public static int  seqNumero, seqDigitos;
    public static ArrayList<AlunoModel> ap;

    public static void leitura(BufferedReader bufferArquivo) {
        ap = new ArrayList();
        ValidadoresController validador = new ValidadoresController();
        String linhaArquivo = null;
        
        try {
            while ((linhaArquivo = bufferArquivo.readLine()) != null) {

                AlunoModel aluno = new AlunoModel();
                
                int matricula = Integer.parseInt(linhaArquivo.substring(0, 4));
                String nome = validador.validaNome(linhaArquivo.substring(4, 29).trim());
                String cpf  = validador.validaCpf(linhaArquivo.substring(29,40));
                String sexo = validador.validaSexo(linhaArquivo.substring(40, 41));
                String data = validador.validaDataNasc(linhaArquivo.substring(41, 49));
                
                aluno.setMatricula(matricula);
                aluno.setNome(nome);
                aluno.setCpf(cpf);
                aluno.setSexo(sexo);
                aluno.setDataNascimento(data);
                
                //Adicionado disciplina...
                String disciplinas = linhaArquivo.substring(49);
                ArrayList<DisciplinaModel> ad = new ArrayList();
                
                int posicao = 0;
                while (posicao < disciplinas.length()) {
                    DisciplinaModel disciplina =  new DisciplinaModel();
                    disciplina.setCodigo(disciplinas.substring(posicao, posicao+4));
                    
                    ad.add(disciplina);
                    posicao += 7;
                }
                aluno.setDisciplinas(ad);

                ap.add(aluno);
            }

        } catch (IOException ex) {
            System.out.println("Problemas ao ler: " + linhaArquivo);
        }

    }

    public static String montaDadosImpressao(ArrayList<AlunoModel> pessoas) {
        String impressao = "RELAÇÃO DE ALUNOS DE OUTROS PÓLOS DE ENSINO" + "\n\n";
        impressao += "Seq. - Matricula - Nome - CPF - Sexo - Dt. Nasc.\n\n";

        for (int i = 0; i < pessoas.size(); i++) {
            AlunoModel p = new AlunoModel();
            p = pessoas.get(i);

            impressao += verificaSequencia(seqNumero+i);
            impressao += " - " + p.getMatricula();
            impressao += " - " + p.getNome();
            impressao += " - " + p.getCpf();
            impressao += " - " + p.getSexo();
            impressao += " - " + p.getDataNascimento();
            
            
            impressao += "\nDISCIPLINAS:";

            for (DisciplinaModel disciplina: p.getDisciplinas()) {
                impressao += " "+disciplina.getCodigo();
            }
            
            impressao += "\n\n";
                   
        }

        return impressao;

    }
    
    private static String verificaSequencia(int contador){
       
        return String.format("%0" + seqDigitos +"d", contador);
    }

}

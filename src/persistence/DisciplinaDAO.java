/*
 *  Copyright 2018, Frederiko Cesar Moreira Ribeiro
 *  GitHub: https://github.com/frederikocmr
 */
package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.DisciplinaModel;

/**
 *
 * @author frede
 */
public class DisciplinaDAO {

    static ArrayList<DisciplinaModel> getDisciplinasAluno(String idAluno) {

        ArrayList<DisciplinaModel> lista = new ArrayList();
        ResultSet rs;
        try {
            Conexao connect = new Conexao();
            rs = connect.executarSelect("ALUNOS_DISCIPLINAS AD",
                    "INNER JOIN DISCIPLINAS D ON AD.ID_DISCIPLINA = D.IDDISCIPLINAS WHERE AD.ID_ALUNO = " + idAluno);
            while (rs.next()) {
                DisciplinaModel disciplina = new DisciplinaModel();
                disciplina.setCodigo(rs.getString("codigo"));

                lista.add(disciplina);
            }
        } catch (Exception e) {
        }

        return lista;

    }

}

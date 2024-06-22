package Exportar;

import Institution.Institution;
import People.Person;
import Submission.Submission;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SalvarArquivo {

    private ArrayList<Person> pessoas;
    private ArrayList<Submission> submissoes;
    private ArrayList<Institution> instituicoes;

    /**
     *
     * @param pessoas ...
     * @param submissoes ...
     * @param instituicoes ...
     */
    public SalvarArquivo(ArrayList<Person> pessoas,
                         ArrayList<Submission> submissoes,
                         ArrayList<Institution> instituicoes) {
        this.pessoas = pessoas;
        this.submissoes = submissoes;
        this.instituicoes = instituicoes;
    }

}

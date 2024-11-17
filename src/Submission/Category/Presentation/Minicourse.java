/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Submission.Category.Presentation;

import People.Author;
import Submission.PresentationSubmission;
import Submission.SubmissionStatus;
import java.util.List;

/**
 *
 * @author Auri Gabriel Castro de Melo
 */
public class Minicourse
        extends PresentationSubmission {

    private String resources;
    private String methodology;

    public Minicourse(String resources,
            String methodology,
            String summary,
            String presentationAbstract,
            int duration,
            String title,
            SubmissionStatus status,
            String category,
            List<Author> authors) {
        super(summary,
                presentationAbstract,
                duration,
                title,
                status,
                3,
                category,
                authors);
        this.resources = resources;
        this.methodology = methodology;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getMethodology() {
        return methodology;
    }

    public void setMethodology(String methodology) {
        this.methodology = methodology;
    }

}

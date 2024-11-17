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
public class Talk
        extends PresentationSubmission {

    private String Curriculum;

    public Talk(String Curriculum,
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
                1,
                category,
                authors);
        this.Curriculum = Curriculum;
    }

    public String getCurriculum() {
        return Curriculum;
    }

    public void setCurriculum(String Curriculum) {
        this.Curriculum = Curriculum;
    }

}

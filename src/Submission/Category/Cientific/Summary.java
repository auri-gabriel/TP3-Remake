/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Submission.Category.Cientific;

import Institution.Institution;
import People.Author;
import Submission.ScientificSubmission;
import Submission.SubmissionStatus;
import java.util.List;

/**
 *
 * @author Auri Gabriel Castro de Melo
 */
public class Summary
        extends ScientificSubmission {

    public Summary(String summary,
                   String submissionAbstract,
                   List<Institution> institutions,
                   List<String> keywords,
                   String title,
                   SubmissionStatus status,
                   String category,
                   List<Author> authors) {
        super(summary,
              submissionAbstract,
              institutions,
              keywords,
              title,
              status,
              8,
              4,
              8,
              category,
              authors);
    }

}

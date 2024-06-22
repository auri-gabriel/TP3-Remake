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
public class TechnicalReport
        extends ScientificSubmission {

    private int year;
    private int pages;

    public TechnicalReport(int year,
                           int pages,
                           String summary,
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
              4,
              4,
              1,
              category,
              authors);
        this.year = year;
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}

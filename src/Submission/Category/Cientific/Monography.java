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
public class Monography
        extends ScientificSubmission {

    private String supervisor;
    private String course;
    private int year;
    private int pages;

    public Monography(String supervisor,
                      String course,
                      int year,
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
              1,
              4,
              1,
              category,
              authors);
        this.supervisor = supervisor;
        this.course = course;
        this.year = year;
        this.pages = pages;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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

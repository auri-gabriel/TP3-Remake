/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Submission;

import People.Author;
import java.util.List;

/**
 *
 * @author Auri Gabriel Castro de Melo
 */
public class PresentationSubmission
        extends Submission {

    protected String summary;
    protected String presentationAbstract;
    protected int duration;

    public PresentationSubmission(String summary,
                                  String presentationAbstract,
                                  int duration,
                                  String title,
                                  SubmissionStatus status,
                                  int MAX_AUTHORS,
                                  String category,
                                  List<Author> authors) {
        super(title,
              status,
              MAX_AUTHORS,
              category,
              authors);
        this.summary = summary;
        this.presentationAbstract = presentationAbstract;
        this.duration = duration;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPresentationAbstract() {
        return presentationAbstract;
    }

    public void setPresentationAbstract(String presentationAbstract) {
        this.presentationAbstract = presentationAbstract;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}

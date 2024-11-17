package Submission;

import People.Author;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Auri Gabriel Castro de Melo
 */
public class Submission
        implements Serializable {

    private String title;
    private SubmissionStatus status;
    private List<Author> authors;
    private int MAX_AUTHORS;
    private String category;

    /**
     * Submission Constructor
     *
     * @param title       The title of the submission
     * @param status      The status of the submission
     * @param MAX_AUTHORS The maximum number of authors
     * @param category    The category
     * @param authors     The authors list
     */
    public Submission(
            String title,
            SubmissionStatus status,
            int MAX_AUTHORS,
            String category,
            List<Author> authors) {
        this.title = title;
        this.status = status;
        this.MAX_AUTHORS = MAX_AUTHORS;

        if (authors.size() > MAX_AUTHORS) {
            throw new IllegalArgumentException(
                    "Number of authors exceeds the maximum allowed.");
        }

        this.authors = new ArrayList<>(authors);
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SubmissionStatus getStatus() {
        return status;
    }

    public void setSituation(SubmissionStatus status) {
        this.status = status;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getMAX_AUTHORS() {
        return MAX_AUTHORS;
    }

    public void setMAX_AUTHORS(int MAX_AUTHORS) {
        this.MAX_AUTHORS = MAX_AUTHORS;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Submission{");
        sb.append("title=").append(title);
        sb.append(", status=").append(status);
        sb.append(", authors=").append(authors);
        sb.append(", MAX_AUTHORS=").append(MAX_AUTHORS);
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }

}

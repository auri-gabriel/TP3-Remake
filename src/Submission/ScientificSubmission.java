package Submission;

import Institution.Institution;
import People.Author;
import java.util.List;

/**
 *
 * @author Auri Gabriel Castro de Melo
 */
public class ScientificSubmission
        extends Submission {

    private String summary;
    private String submissionAbstract;
    private List<Institution> institutions;
    private List<String> keywords;
    private int MAX_KEYWORDS;
    private int MAX_INSTITUTIONS;

    public ScientificSubmission(String summary,
            String submissionAbstract,
            List<Institution> institutions,
            List<String> keywords,
            String title,
            SubmissionStatus status,
            int MAX_AUTHORS,
            int MAX_KEYWORDS,
            int MAX_INSTITUTIONS,
            String category,
            List<Author> authors) {
        super(title,
                status,
                MAX_AUTHORS,
                category,
                authors);
        this.summary = summary;
        this.submissionAbstract = submissionAbstract;

        this.MAX_INSTITUTIONS = MAX_INSTITUTIONS;
        if (institutions.size() > MAX_INSTITUTIONS) {
            throw new IllegalArgumentException(
                    "Number of institutions exceeds the maximum allowed.");
        }
        this.institutions = institutions;

        this.MAX_KEYWORDS = MAX_KEYWORDS;
        if (keywords.size() > MAX_KEYWORDS) {
            throw new IllegalArgumentException(
                    "Number of keywords exceeds the maximum allowed.");
        }
        this.keywords = keywords;

    }

}

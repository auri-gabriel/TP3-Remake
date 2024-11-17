package Submission.Category.Cientific;

import Institution.Institution;
import People.Author;
import Submission.ScientificSubmission;
import Submission.SubmissionStatus;
import java.util.List;

/**
 * Class that represents a scientific article submission.
 *
 * @author Auri Gabriel Castro de Melo
 *
 */
public class Article
        extends ScientificSubmission {

    public Article(String summary,
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

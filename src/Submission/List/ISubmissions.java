package Submission.List;

import Submission.Submission;
import java.util.List;

/**
 * Interface specifying the signature of methods to be implemented for
 * manipulating a set of submissions.
 *
 * @author Aline
 */
public interface ISubmissions {

    /**
     * Includes a submission in the list of submissions.
     *
     * @param submission Submission to be included.
     *
     * @return True if the inclusion was successful, or False otherwise.
     */
    public boolean add(Submission submission);

    /**
     * Queries for the submission with the given title.
     *
     * @param title Title to be queried.
     *
     * @return Submission with the given title or null if no submission with the
     * given title is found.
     */
    public Submission queryByTitle(String title);

    /**
     * Queries for the list of submissions with the given author.
     *
     * @param author Author to be queried.
     *
     * @return List of submissions from the specified author.
     */
    public List<Submission> queryByAuthor(String author);

    /**
     * Deletes the submission with the given title.
     *
     * @param title Title of the submission to be deleted.
     *
     * @return True if the submission with the given title is deleted, or False
     * if no submission with the
     * given title is found.
     */
    public boolean delete(String title);
}

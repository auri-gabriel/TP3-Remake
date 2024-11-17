package Submission.List;

import People.Person;
import Submission.Category.Cientific.Article;
import Submission.Category.Cientific.Monography;
import Submission.Category.Cientific.TechnicalReport;
import Submission.Category.Presentation.Minicourse;
import Submission.Category.Presentation.Talk;
import Submission.Submission;
import Submission.SubmissionStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * Submissions class implementing the ISubmissions interface.
 *
 * This class represents a collection of submissions and provides methods for
 * managing and querying them.
 *
 * @author Auri Gabriel Castro de Melo
 */
public class Submissions implements ISubmissions {

    private ArrayList<Submission> Submissions;

    /**
     * Constructor of the class.
     *
     * Initializes an empty list of submissions.
     */
    public Submissions() {
        Submissions = new ArrayList<>();
    }

    /**
     * Gets the ArrayList of submissions.
     *
     * @return ArrayList of submissions.
     */
    public ArrayList<Submission> getSubmissions() {
        return Submissions;
    }

    /**
     * Gets the type of submission.
     *
     * @return Type of submission.
     */
    public String getType() {
        for (Submission submission : Submissions) {
            if (submission instanceof Minicourse) {
                return "Minicourse";
            } else if (submission instanceof Talk) {
                return "Talk";
            } else if (submission instanceof Article) {
                return "Article";
            } else if (submission instanceof Monography) {
                return "Monography";
            } else if (submission instanceof TechnicalReport) {
                return "Technical Report";
            } else {
                return "Abstract";
            }
        }
        return null;
    }

    /**
     * Adds a submission to the list.
     *
     * @param submission The submission to be added.
     *
     * @return True if the submission is added successfully, false otherwise.
     */
    @Override
    public boolean add(Submission submission) {
        try {
            Submissions.add(submission);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Queries submissions by title.
     *
     * @param title Title to be queried.
     *
     * @return List of submissions with the specified title.
     */
    public List<Submission> queryListByTitle(String title) {
        List<Submission> list = new ArrayList<>();
        for (Submission submission : Submissions) {
            if ((title == null && submission.getTitle() == null)
                    || (title != null && title.equals(submission.getTitle()))) {
                try {
                    list.add(submission);
                } catch (Exception e) {
                }
            }
        }
        return list;
    }

    /**
     * Queries submissions by status.
     *
     * @param status The status to be queried.
     *
     * @return List of submissions with the specified status.
     */
    public List<Submission> queryListBySituation(SubmissionStatus status) {
        List<Submission> list = new ArrayList<>();
        for (Submission submission : Submissions) {
            if (status == submission.getStatus()) {
                try {
                    list.add(submission);
                } catch (Exception e) {
                }
            }
        }
        return list;
    }

    /**
     * Queries submissions by author.
     *
     * @param author Author to be queried.
     *
     * @return List of submissions with the specified author.
     */
    public List<Submission> queryListByAuthor(Person author) {
        List<Submission> resultList = new ArrayList<>();
        for (Submission submission : Submissions) {
            if (submission.getAuthors().contains(author)) {
                resultList.add(submission);
            }
        }
        return resultList;
    }

    /**
     * Queries submissions by category.
     *
     * @param category Category to be queried.
     *
     * @return List of submissions with the specified category.
     */
    public List<Submission> queryListByCategory(String category) {
        List<Submission> list = new ArrayList<>();
        for (Submission submission : Submissions) {
            if ((category == null && submission.getCategory() == null)
                    || (category != null && category.equals(submission.getCategory()))) {
                try {
                    list.add(submission);
                } catch (Exception e) {
                }
            }
        }
        return list;
    }

    /**
     * Queries a submission by title.
     *
     * @param title Title to be queried.
     *
     * @return The submission with the specified title, or null if not found.
     */
    @Override
    public Submission queryByTitle(String title) {
        for (Submission submission : Submissions) {
            if ((title == null && submission.getTitle() == null)
                    || (title != null && title.equals(submission.getTitle()))) {
                try {
                    return submission;
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    /**
     * Queries submissions by author name.
     *
     * @param name Author name to be queried.
     *
     * @return List of submissions with authors having the specified name.
     */
    @Override
    public List<Submission> queryByAuthor(String name) {
        List<Submission> resultList = new ArrayList<>();
        for (Submission submission : Submissions) {
            for (Person author : submission.getAuthors()) {
                if ((name == null && author.getName() == null) || (name != null && name.equals(author.getName()))) {
                    resultList.add(submission);
                    break;
                }
            }
        }
        return resultList;
    }

    /**
     * Deletes a submission by title.
     *
     * @param title Title of the submission to be deleted.
     *
     * @return True if the submission is deleted successfully, false otherwise.
     */
    @Override
    public boolean delete(String title) {
        for (Submission submission : Submissions) {
            if ((title == null && submission.getTitle() == null)
                    || (title != null && title.equals(submission.getTitle()))) {
                try {
                    Submissions.remove(submission);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }
}

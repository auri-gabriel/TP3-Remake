package People;

import java.util.List;

/**
 * Interface specifying the signature of methods to be implemented for
 * manipulating a set of submissions.
 *
 * @author Auri Gabriel Castro de Melo
 */
public interface IPeople {

    /**
     * Adds a person in the list of people.
     *
     * @param person Person to be added.
     *
     * @return True if the insertion was successful, or False otherwise.
     */
    public boolean add(Person person);

    /**
     * Deletes the person with the given name.
     *
     * @param name Name of the person to be deleted.
     *
     * @return True if the person with the given name is deleted, or False if no
     *         person with the
     *         given name is found.
     */
    public boolean delete(String name);

    /**
     * Returns a boolean indicating whether a person with the given name exists.
     *
     * @param name Name of the person
     *
     * @return True if the person with the given name is found,
     *         or False otherwise.
     */
    public boolean exists(String name);

    /**
     * Returns a list of all authors.
     *
     * @return List of all authors.
     */
    public List<Person> getAllAuthors();
}

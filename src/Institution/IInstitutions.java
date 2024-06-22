package Institution;

/**
 * Interface specifying the signature of methods to be implemented for
 * manipulating a set of Institutions.
 *
 * @author Auri Gabriel Castro de Melo
 */
public interface IInstitutions {

    /**
     * Checks if an institution with the given name already exists.
     *
     * @param name The name of the institution to check.
     *
     * @return True if the institution exists, false otherwise.
     */
    public boolean exists(String name);

    /**
     * Includes an institution in the list of institutions.
     *
     * @param institution Institution to be included.
     *
     * @return True if the inclusion was successful, or False otherwise.
     */
    public boolean include(Institution institution);

    /**
     * Deletes the institution with the given name.
     *
     * @param name Name of the institution to be deleted.
     *
     * @return True if the institution with the given name is deleted, or False
     * if no institution with the
     * given name is found.
     */
    public boolean delete(String name);

}

package Institution;

import java.util.ArrayList;

/**
 * The Institutions class manages a list of institutions and provides
 * methods for operations such as adding, deleting, and retrieving institutions.
 *
 * @author Auri Gabriel Castro de Melo
 */
public class Institutions
        implements IInstitutions {

    // List to store institutions
    private ArrayList<Institution> institutions;

    /**
     * Constructor of the class. Initializes the list of institutions.
     */
    public Institutions() {
        institutions = new ArrayList<>();
    }

    /**
     * Returns the list of institutions.
     *
     * @return The list of institutions.
     */
    public ArrayList<Institution> getInstitutions() {
        return institutions;
    }

    /**
     * Checks if an institution with the given name already exists.
     *
     * @param name The name of the institution to check.
     *
     * @return True if the institution exists, false otherwise.
     */
    @Override
    public boolean exists(String name) {
        for (Institution institution : institutions) {
            if ((name == null && institution.getName() == null) || (name != null && name.
                    equals(institution.getName()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves an institution with the given name.
     *
     * @param name The name of the institution to retrieve.
     *
     * @return The institution with the specified name, or null if not found.
     */
    public Institution getInstitution(String name) {
        for (Institution institution : institutions) {
            if (institution.getName().
                    equals(name)) {
                return institution;
            }
        }
        return null;
    }

    /**
     * Adds a new institution to the list.
     *
     * @param institution The institution to be added.
     *
     * @return True if the institution is added successfully, false otherwise.
     */
    @Override
    public boolean include(Institution institution) {
        try {
            institutions.add(institution);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Deletes an institution with the given name from the list.
     *
     * @param name The name of the institution to be deleted.
     *
     * @return True if the institution is deleted successfully, false otherwise.
     */
    @Override
    public boolean delete(String name) {
        for (Institution institution : institutions) {
            if (name.equals(institution.getName())) {
                try {
                    institutions.remove(institution);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }
}

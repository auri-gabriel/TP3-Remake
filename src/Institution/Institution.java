package Institution;

import java.io.Serializable;

/**
 * Represents an institution with a name and a unique identifier.
 * This class implements the Serializable interface for object serialization.
 *
 * The unique identifier is generated automatically and incremented for each new
 * instance.
 *
 * @author Auri Gabriel
 */
public class Institution
        implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private final int id;
    private static int nextId = 1;

    /**
     * Constructs an Institution with the specified name.
     * The unique identifier is automatically assigned.
     *
     * @param name The name of the institution.
     */
    public Institution(String name) {
        this.name = name;
        this.id = nextId++;
    }

    /**
     * Gets the name of the institution.
     *
     * @return The name of the institution.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the institution.
     *
     * @param name The new name for the institution.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the unique identifier of the institution.
     *
     * @return The unique identifier of the institution.
     */
    public int getId() {
        return id;
    }
}

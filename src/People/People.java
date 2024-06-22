package People;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Auri Gabriel Castro de Melo
 */
public class People
        implements IPeople {

    private ArrayList<Person> people;

    /**
     * Constructor for the People class.
     */
    public People() {
        people = new ArrayList<>();
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     *
     * @param name The person name
     *
     * @return true if the person exists;
     */
    public boolean exists(String name) {
        for (Person person : people) {
            if (name == null ? person.getName() == null : name.equals(person.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return the role of the person;
     */
    public String getRole() {
        for (Person person : people) {
            if (person instanceof Supervisor) {
                return "Supervisor";
            } else {
                return "Author";
            }
        }
        return null;
    }

    /**
     *
     * @param name The person name
     *
     * @return the person;
     */
    public Person getPerson(String name) {
        for (Person person : people) {
            try {
                if (name.equals(person.getName())) {
                    return person;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    /**
     *
     * @param person The person object
     *
     * @return true if the person was added successfully;
     */
    @Override
    public boolean add(Person person) {
        try {
            people.add(person);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param name The person name
     *
     * @return true if the person was deleted successfully;
     */
    @Override
    public boolean delete(String name) {
        for (Person person : people) {
            if (name.equals(person.getName())) {
                try {
                    people.remove(person);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public List<Person> getAllAuthors() {
        return this.people;
    }

}

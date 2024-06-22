/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

import java.io.Serializable;

/**
 *
 * @author Auri Gabriel
 */
public class Person implements Serializable {

    private String name;
    private final int id;
    private static int nextId = 1;

    public Person(String name) {
        this.name = name;
        this.id = nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", id=" + id + '}';
    }

    public Role getRole() {
        if (this instanceof Supervisor) {
            return Role.SUPERVISOR;
        } else {
            return Role.AUTHOR;
        }

    }

}

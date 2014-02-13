package objectstructures;

import java.util.ArrayList;

/**
 * Created by sklirg on 2/13/14.
 * @ToDo
 *
 * name, gender, mother, father, childCount, child
 */
public class Person {
    private String name;
    private char gender;
    private Person mother, father;
    private ArrayList<Person> children;

    public Person(String name, char gender) {
        this.name = name;

        if (gender == 'M' || gender == 'F' /* || gender == '\0'*/) { // Copied from encapsulation/Person
            this.gender = gender;
        }
        else {
            throw new IllegalArgumentException("Gender is either [M]ale or [F]emale.");
        }
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public int getChildCount() {
        return children.size();
    }

    public Person getChild(int n) {
        if (n > children.size()) {
            throw new IllegalArgumentException("This family does not have this many kids.");
        }
        else
            return children.get(n-1);
    }

    public void setMother(Person mother) {
        if (mother.gender == 'F') {
            this.mother = mother;
            mother.addChild(this);
        }
        else
            throw new IllegalArgumentException("This is not a female.");
    }

    public void setFather(Person father) {
        if (father.gender == 'M') {
            this.father = father;
            father.addChild(this);
        }
        else
            throw new IllegalArgumentException("This is not a male.");
    }

    public void addChild(Person child) {
        this.children.add(child);
        if (this.gender == 'M')
            child.setFather(this);
        else
            child.setMother(this);
    }

    public void removeChild(Person child) {
        boolean childAsChild = false;
        for (Person p : this.children) {
            if (p == child)
                childAsChild = true;
        }
        if (childAsChild) {
            this.children.remove(child);
            if (this.gender == 'M')
                child.setFather(null);
            else
                child.setMother(null);
        }
        else
            throw new IllegalArgumentException("This child is not a child of this parent.");
    }

    @Override
    public String toString() {
        return name;
    }
}

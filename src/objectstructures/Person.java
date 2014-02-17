package objectstructures;

import java.util.ArrayList;

/**
 * Created by sklirg on 2/13/14.
 *
 * name, gender, mother, father, childCount, child
 */
public class Person {
    private String name;
    private char gender;
    private Person mother, father;
    private ArrayList<Person> children = new ArrayList<Person>();

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
        //System.out.println("Trying to get kid at " + n);
        if (n > children.size()) {
            throw new IllegalArgumentException("This family does not have this many kids.");
        }
        else {
            return children.get(n);
        }
    }

    public void setMother(Person mother) {
        if (mother.gender != 'F') {
            throw new IllegalArgumentException("This is not a female.");
        }
        else if (this == mother)
            throw new IllegalArgumentException("Cannot add as own mother.");
        else if (this.mother != null) {
            //throw new IllegalArgumentException("This child already has a mother.");
        }
        else {
            this.mother = mother;
            mother.addChild(this);
        }
    }

    public void setFather(Person father) {
        if (father.gender != 'M')
            throw new IllegalArgumentException("This is not a male.");
        else if (this == father)
            throw new IllegalArgumentException("Cannot add as own father.");
        else if (this.father != null) {
            //throw new IllegalArgumentException("This child already has a father.");
        }
        else {
            this.father = father;
            father.addChild(this);
        }
    }

    public void addChild(Person child) {
        boolean childAsChild = false;
        for (Person p : this.children) {
            if (p == child)
                childAsChild = true;
        }
        if (childAsChild) {
         //   throw new IllegalArgumentException("This child is already a child of this parent.");
        }
        else if (this != child) {
            children.add(child);
            if (this.gender == 'M')
                child.setFather(this);
            else
                child.setMother(this);
        }
        else {
            throw new IllegalArgumentException("Cannot add as own child");
        }
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

    public void printDebug() {
        String r = String.format("n: %s, g: %s m: %s, f: %s", this.name, this.gender, this.mother, this.father);
        if (children.size()>0) {
            String childrenString = "";
            for (Person c : children) {
                childrenString += c.getName() + " ";
            }
            r += "\n-- Children: " + childrenString;
        }
        System.out.println(r);
    }

    public static void main(String[] args) {
        Person me = new Person("Håkon", 'M');
        Person sis = new Person("IA", 'F');
        Person p = new Person("Roald", 'M');
        Person m = new Person("Marit", 'F');
        Person ff = new Person("Tønnes", 'M');
        Person fm = new Person("Elna", 'F');
        Person mf = new Person("Alf", 'M');
        Person mm = new Person("Maria", 'F');

        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(me);
        persons.add(sis);
        persons.add(p);
        persons.add(m);
        persons.add(ff);
        persons.add(fm);
        persons.add(mf);
        persons.add(mm);

        mm.addChild(m);
        mf.addChild(m);
        fm.addChild(p);
        ff.addChild(p);
        p.addChild(sis);
        m.addChild(sis);
        p.addChild(me);
        m.addChild(me);

        System.out.println("Antall barn for p: " + p.getChildCount());
        System.out.println("barn 1: " + p.getChild(0));
        System.out.println("barn 2: " + p.getChild(1));
        for (Person x : persons) {
            x.printDebug();
        }
    }
}

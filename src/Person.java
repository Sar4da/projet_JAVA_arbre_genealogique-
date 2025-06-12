import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Homme father;
    private Femme mother;
    private List<Marriage> marriages;
    private boolean isfirst = false;
    public static boolean firstPersonCreated = false;


    public Person(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        if (firstPersonCreated == false) {
            this.isfirst = true;
            firstPersonCreated = true;
        }
        this.marriages = new ArrayList<>();
    }

    public Person(String firstName, String lastName, Date birthDate, Homme father, Femme mother) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.father = father;
        this.mother = mother;
        this.marriages = new ArrayList<>();
    }

    public Person(String firstName, String lastName, Date birthDate, Marriage marriage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.father = null;
        this.mother = null;
        this.marriages = new ArrayList<>();
        this.marriages.add(marriage);
    }

    public Person(String firstName, String lastName, Date birthDate, List<Marriage> marriages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.father = null;
        this.mother = null;
        this.marriages = marriages;
    }

    public Person() {
    }


    public boolean isIsfirst() {
        return isfirst;
    }

    public void setIsfirst(boolean isfirst) {
        this.isfirst = isfirst;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Homme getFather() {
        return father;
    }

    public void setFather(Homme father) {
        this.father = father;
    }

    public Femme getMother() {
        return mother;
    }

    public void setMother(Femme mother) {
        this.mother = mother;
    }

    public List<Marriage> getMarriages() {
        return this.marriages;
    }

    public void addMarriage(Marriage marriage) {
        marriages.add(marriage);
    }

    public List<Person> getCheldrens(){
        List<Person> childrens = new ArrayList<>();
        for (Marriage marriage : this.marriages) {
            childrens.addAll(marriage.getChildrens());
        }
        return childrens;
    }

    

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
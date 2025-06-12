import java.util.Date;
import java.util.List;

public class Femme extends Person {

    public Femme(String firstName, String lastName, Date birthDate, Homme father, Femme mother) {
        super(firstName, lastName, birthDate, father, mother);
    }

    public Femme(String firstName, String lastName, Date birthDate, Marriage marriage) {
        super(firstName, lastName, birthDate, marriage);
    }

    public Femme(String firstName, String lastName, Date birthDate, List<Marriage> marriages) {
        super(firstName, lastName, birthDate, marriages);
    }
}
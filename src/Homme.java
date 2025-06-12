import java.util.Date;
import java.util.List;

public class Homme extends Person {
    public Homme(String firstName, String lastName, Date birthDate) {
        super(firstName, lastName, birthDate);
    }

    public Homme(String firstName, String lastName, Date birthDate, Homme father, Femme mother) {
        super(firstName, lastName, birthDate, father, mother);
    }

    public Homme(String firstName, String lastName, Date birthDate, Marriage marriage) {
        super(firstName, lastName, birthDate, marriage);
    }

    public Homme(String firstName, String lastName, Date birthDate, List<Marriage> marriages) {
        super(firstName, lastName, birthDate, marriages);
    }
}
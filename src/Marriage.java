import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Marriage {
    public Homme husband;
    public Femme wife;
    public Optional<LocalDate> marriageDate;
    public Optional<LocalDate> divorceDate;
    public List<Person> children;

    public Marriage(Homme husband, Femme wife) {
        this.husband = husband;
        this.wife = wife;
        this.marriageDate = Optional.empty();
        this.divorceDate = Optional.empty();
        this.children = new ArrayList<>();
    }

    public Marriage(Homme husband, Femme wife, LocalDate marriageDate, LocalDate divorceDate) {
        this.husband = husband;
        this.wife = wife;
        this.marriageDate = Optional.of(marriageDate);
        this.divorceDate = Optional.of(divorceDate);
        this.children = new ArrayList<>();
    }

    // Getters and setters
    public Homme getHusband() {
        return husband;
    }

    public void setHusband(Homme husband) {
        this.husband = husband;
    }

    public Femme getWife() {
        return wife;
    }

    public void setWife(Femme wife) {
        this.wife = wife;
    }

    public Optional<LocalDate> getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(Optional<LocalDate> marriageDate) {
        this.marriageDate = marriageDate;
    }

    public Optional<LocalDate> getDivorceDate() {
        return divorceDate;
    }

    public void setDivorceDate(Optional<LocalDate> divorceDate) {
        this.divorceDate = divorceDate;
    }

    public List<Person> getChildrens() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    // Method to add child
    public void addChilden(Person child) {
        children.add(child);
    }

    // toString method
    @Override
    public String toString() {
        return "Marriage{" +
                "husband=" + husband +
                ", wife=" + wife +
                ", marriageDate=" + marriageDate +
                ", divorceDate=" + divorceDate +
                ", children=" + children +
                '}';
    }
}

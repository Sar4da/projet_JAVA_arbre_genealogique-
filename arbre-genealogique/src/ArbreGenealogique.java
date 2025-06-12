import java.util.ArrayList;
import java.util.List;

public class ArbreGenealogique {
    private List<Homme> hommes;
    private List<Femme> femmes;
    private List<Marriage> mariages;

    public ArbreGenealogique() {
        hommes = new ArrayList<>();
        femmes = new ArrayList<>();
        mariages = new ArrayList<>();
    }

    public void ajouterPerson(Homme homme) {
        hommes.add(homme);
    }

    public void ajouterPerson(Femme femme) {
        femmes.add(femme);
    }

    public void ajouterMarriage(Marriage mariage) {
        mariages.add(mariage);
    }

    public List<Homme> getHommes() {
        return hommes;
    }

    public List<Femme> getFemmes() {
        return femmes;
    }

    public List<Marriage> getMariages() {
        return mariages;
    }
}
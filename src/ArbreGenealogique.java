import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArbreGenealogique {
    private List<Person> persons;
    private List<Marriage> marriages;
   
    public ArbreGenealogique() {
        this.persons = new ArrayList<>();
        this.marriages = new ArrayList<>();
    }

    public ArbreGenealogique(List<Person> persons ,List<Marriage> marriages ){
        this.persons = persons;
        this.marriages = marriages;
    }

    // Ajouter une personne
    public void ajouterPerson(Person person) {
        persons.add(person);
    }

    // Ajouter un marriage
    public void ajouterMarriage(Marriage marriage) {
        marriages.add(marriage);
    }

    // Afficher l'arbre généalogique
    public void afficherArbre() {
        for (Marriage marriage : marriages) {
            System.out.println(marriage.getHusband() + " et " + marriage.getWife());
            for (Person enfant : marriage.getChildrens()) {
                System.out.println("  └─ " + enfant);
            }
        }
    }

    public Person rechercherPersonne(String nom, String prenom) {
        for (Person p : persons) {
            if (p.getLastName().equals(nom) && p.getFirstName().equals(prenom)) {
                return p;
            }
        }
        return null;
    }

    public Marriage rechercherMarriage(Homme epoux, Femme epouse) {
        for (Marriage m : marriages) {
            if (m.getHusband().equals(epoux) && m.getWife().equals(epouse)) {
                return m;
            }
        }
        return null;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Marriage> getMarriages() {
        return marriages;
    }

    public void setMarriages(List<Marriage> marriages) {
        this.marriages = marriages;
    }


    public Set<Person> getOncles(Person person) {
        Set<Person> oncles = new HashSet<Person>();
        Homme pere = person.getFather();
        Femme mere = person.getMother();
        if (pere != null){
            Person grandpere = pere.getFather();
            Person grandmere = pere.getFather();
            if (grandpere != null) oncles.addAll(grandpere.getCheldrens());
            if (grandmere != null) oncles.addAll(grandmere.getCheldrens());
        }
        if (mere != null){
            Person grandpere = mere.getFather();
            Person grandmere = mere.getFather();
            if (grandpere != null) oncles.addAll(grandpere.getCheldrens());
            if (grandmere != null) oncles.addAll(grandmere.getCheldrens());
        }
        return oncles;
    }

    public Set<Person> getCousins(Person person) {
        Set<Person> cousins = new HashSet<Person>();
        Set<Person> oncles = getOncles(person);
        for (Person oncle : oncles) {
            cousins.addAll(oncle.getCheldrens());
        }
        return cousins;
    }

    public List<Marriage> getAncetres(Person person){
        List<Marriage> ancetres = new ArrayList<Marriage>();
        if(person.getFather() == null || person.getMother() == null) {
            return ancetres;
        }
        Set<Marriage> fatherMarriages = new HashSet<Marriage>(person.getFather().getMarriages());
        Set<Marriage> motherMarriages = new HashSet<Marriage>(person.getMother().getMarriages());
        List<Marriage> ParentsMarriages = new ArrayList<>(fatherMarriages);
        ParentsMarriages.retainAll(motherMarriages);

        for(Marriage m : ParentsMarriages){
            if(m.getChildrens().contains(person)){
                ancetres.add(m);
                ancetres.addAll(getAncetres(person.getFather()));
                break;
            }
        }
        return ancetres;
    }

    public List<Homme> getFreres(Person person){
        List<Homme> freres = new ArrayList<Homme>();
        for(Marriage m : this.getMarriages()){
            if(m.getChildrens().contains(person)){
                for (Person p : m.getChildrens()) {
                    if (p instanceof Homme && !p.equals(person))
                        freres.add((Homme) p);
                }
                break;
            }
        }
        return freres;
    }

    public List<Person> getDemiFreresDemiSoeurs(Person person){
        List<Person> demiFreresSoeurs = new ArrayList<Person>();
        for(Marriage m : this.getMarriages()){
            if (m.getWife().equals(person.getMother()) && !m.getHusband().equals(person.getFather()))
                demiFreresSoeurs.addAll(m.getChildrens());
            if (!m.getWife().equals(person.getMother()) && m.getHusband().equals(person.getFather()))
                demiFreresSoeurs.addAll(m.getChildrens());
        }
        return demiFreresSoeurs;
    }    

    public List<Homme> getDemiFreres(Person person){
        List<Homme> demiFreres = new ArrayList<Homme>();
        for(Person p : this.getDemiFreresDemiSoeurs(person)){
            if ( p instanceof Homme)
                demiFreres.add((Homme) p);
        }
        return demiFreres;
    } 

    public List<Femme> getDemiSoeurs(Person person){
        List<Femme> demiSoeurs = new ArrayList<Femme>();
        for(Person p : this.getDemiFreresDemiSoeurs(person)){
            if ( p instanceof Femme)
                demiSoeurs.add((Femme) p);
        }
        return demiSoeurs;
    } 

    public List<Femme> getSoeurs(Person person){
        List<Femme> soeurs = new ArrayList<Femme>();
        for(Marriage m : this.getMarriages()){
            if(m.getChildrens().contains(person)){
                for (Person p : m.getChildrens()) {
                    if (p instanceof Femme && !p.equals(person))
                        soeurs.add((Femme) p);
                }
                break;
            }
        }
        return soeurs;
    }    

public boolean addMarriage(String firstName, String lastName, String sex, Date birthDate, Person spouse) {
    System.out.println("Début addMarriage");
    if (spouse == null) {
        System.out.println("Spouse est null");
        return false;
    }

    if (firstName == null || lastName == null || birthDate == null || sex == null) {
        System.out.println("Champs manquants");
        return false;
    }

    Person person;
    if (sex.equals("M")) {
        person = new Homme(firstName, lastName, birthDate, new ArrayList<>());
    } else if (sex.equals("F")) {
        person = new Femme(firstName, lastName, birthDate, new ArrayList<>());
    } else {
        System.out.println("Sexe invalide : " + sex);
        return false;
    }

    System.out.println("Personne créée : " + person);

    Marriage marriage;
    if (person instanceof Homme && spouse instanceof Femme) {
        marriage = new Marriage((Homme) person, (Femme) spouse);
    } else if (person instanceof Femme && spouse instanceof Homme) {
        marriage = new Marriage((Homme) spouse, (Femme) person);
    } else {
        System.out.println("Types incompatibles : " + person.getClass() + " et " + spouse.getClass());
        return false;
    }

    spouse.addMarriage(marriage);
    person.addMarriage(marriage);
    this.ajouterPerson(person);
    this.ajouterMarriage(marriage);

    System.out.println("Mariage ajouté : " + marriage);
    return true;
}


    public boolean addChildren(String firstName, String lastName, String sex, Date birthDate, Homme father, Femme mother) {
        Person person;
        // Vérifier que chaque parent est plus vieux que la personne d'au moins 18 ans
        if (father != null && !isOlderThan(father, birthDate)) {
            return false;
        }
        if (mother != null && !isOlderThan(mother, birthDate)) {
            return false;
        }

        if ((father == null || mother == null) && Person.firstPersonCreated == true) 
            return false;
        else if ((father == null || mother == null) && Person.firstPersonCreated == false)
            person = new Person(firstName, lastName, birthDate);
        else
            person = new Person(firstName, lastName, birthDate, father, mother);
        System.out.println(person.toString());
        if (father != null && mother != null) {
            for (Marriage marriage : father.getMarriages()) {
                if (marriage.getWife() == mother) {
                    marriage.addChilden(person);
                }
            }
        }
        this.ajouterPerson(person);
        return true;
    }
    // Méthode pour vérifier si une personne est plus vieille qu'une date d'au moins 12 ans
    private boolean isOlderThan(Person person, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -18);
        Date minBirthDate = cal.getTime();
        return person.getBirthDate().before(minBirthDate);
    }

    public List<Person> getFemmes(int age) {
        List<Person> eligiblePersons = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -age); // Déduction de 12 ans à partir de la date actuelle
        Date thresholdDate = cal.getTime();

        for (Person person : this.getPersons() ) {
            if (person instanceof Femme && person.getBirthDate().before(thresholdDate)) {
                eligiblePersons.add(person);
            }
        }
        return eligiblePersons;
    }

    public List<Person> getHommes(int age) {
        List<Person> eligiblePersons = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -age); // Déduction de 12 ans à partir de la date actuelle
        Date thresholdDate = cal.getTime();

        for (Person person : this.getPersons() ) {
            if (person instanceof Homme && person.getBirthDate().before(thresholdDate)) {
                eligiblePersons.add(person);
            }
        }
        return eligiblePersons;
    }

    public List<Person> getEpoux() {
        List<Person> eligiblePersons = new ArrayList<>();
        for (Marriage m : this.getMarriages()) {
            eligiblePersons.add(m.getHusband());
        }
        return eligiblePersons;
    }

    public List<Person> getEpouses() {
        List<Person> eligiblePersons = new ArrayList<>();
        for (Marriage m : this.getMarriages()) {
            eligiblePersons.add(m.getWife());
        }
        return eligiblePersons;
    }

}
public class Homme {
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private List<Marriage> mariages;
    private List<Homme> enfantsHomme;
    private List<Femme> enfantsFemme;

    public Homme(String prenom, String nom, Date dateNaissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.mariages = new ArrayList<>();
        this.enfantsHomme = new ArrayList<>();
        this.enfantsFemme = new ArrayList<>();
    }

    public Homme(String prenom, String nom, Date dateNaissance, Homme pere, Femme mere) {
        this(prenom, nom, dateNaissance);
        // Logique pour ajouter les parents si nécessaire
    }

    public void addMarriage(Marriage marriage) {
        mariages.add(marriage);
    }

    public void addChilden(Homme enfant) {
        enfantsHomme.add(enfant);
    }

    public void addChilden(Femme enfant) {
        enfantsFemme.add(enfant);
    }

    // Getters et Setters
    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public List<Marriage> getMariages() {
        return mariages;
    }

    public List<Homme> getEnfantsHomme() {
        return enfantsHomme;
    }

    public List<Femme> getEnfantsFemme() {
        return enfantsFemme;
    }
}
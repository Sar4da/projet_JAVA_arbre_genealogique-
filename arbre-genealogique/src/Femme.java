public class Femme {
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private List<Marriage> mariages;
    private Homme partenaire;

    public Femme(String prenom, String nom, Date dateNaissance, List<Marriage> mariages) {
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.mariages = mariages;
    }

    public Femme(String prenom, String nom, Date dateNaissance, Homme partenaire) {
        this(prenom, nom, dateNaissance, new ArrayList<>());
        this.partenaire = partenaire;
    }

    public void addMarriage(Marriage marriage) {
        mariages.add(marriage);
    }

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

    public Homme getPartenaire() {
        return partenaire;
    }
}
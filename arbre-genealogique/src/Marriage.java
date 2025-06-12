public class Marriage {
    private Homme husband;
    private Femme wife;
    private List<Person> children;

    public Marriage(Homme husband, Femme wife) {
        this.husband = husband;
        this.wife = wife;
        this.children = new ArrayList<>();
    }

    public Homme getHusband() {
        return husband;
    }

    public Femme getWife() {
        return wife;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChilden(Person child) {
        children.add(child);
    }
}
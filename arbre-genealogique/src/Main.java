import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        ArbreGenealogique arbre = new ArbreGenealogique();

        Date d0 = new Date(65, 1, 6);
        Date d1 = new Date(80, 1, 6);
        Date d2 = new Date(100, 1, 1);
        Date d3 = new Date(120, 1, 1);

        Homme h1 = new Homme("Cesar", "BEN EL HADJ", d0);
        Femme f1 = new Femme("Francine", "BEN REHOUMA", d0, new ArrayList<>());
        Marriage m1 = new Marriage(h1, f1);
        h1.addMarriage(m1);
        f1.addMarriage(m1);

        Homme h2 = new Homme("jean", "BEN EL HADJ", d1, h1, f1);
        Femme f2 = new Femme("dalola", "BEN EL HADJ", d1, h1, f1);
        Homme h3 = new Homme("bob", "BEN EL HADJ", d1, h1, f1);
        m1.addChilden(h2);
        m1.addChilden(f2);
        m1.addChilden(h3);

        Femme f3 = new Femme("leo", "BEN ali", d1, new ArrayList<>());
        Marriage m2 = new Marriage(h2, f3);
        h2.addMarriage(m2);
        f3.addMarriage(m2);

        Homme h5 = new Homme("jean", "BEN EL HADJ", d2, h2, f3);
        Femme f5 = new Femme("lola", "BEN EL HADJ", d2, h2, f3);
        Homme h6 = new Homme("bob", "BEN EL HADJ", d2, h2, f3);
        m2.addChilden(h5);
        m2.addChilden(f5);
        m2.addChilden(h6);

        Homme h4 = new Homme("marc", "BEN jack", d1, new ArrayList<>());
        Marriage m3 = new Marriage(h4, f2);
        h4.addMarriage(m3);
        f2.addMarriage(m3);

        Homme h7 = new Homme("jojo", "BEN jack", d2, h4, f2);
        Femme f6 = new Femme("polo", "BEN jack", d2, h4, f2);
        m3.addChilden(h7);
        m3.addChilden(f6);

        Femme f4 = new Femme("lila", "leroi", d1, new ArrayList<>());
        Marriage m4 = new Marriage(h3, f4);
        h3.addMarriage(m4);
        f4.addMarriage(m4);

        Homme h8 = new Homme("sam", "BEN EL HADJ", d2, h3, f4);
        Homme h9 = new Homme("boby", "BEN EL HADJ", d2, h3, f4);
        Homme h10 = new Homme("fab", "BEN EL HADJ", d2, h3, f4);
        m4.addChilden(h8);
        m4.addChilden(h9);
        m4.addChilden(h10);

        Femme f7 = new Femme("alia", "yoya", d1, new ArrayList<>());
        Marriage m5 = new Marriage(h3, f7);
        h3.addMarriage(m5);
        f7.addMarriage(m5);

        Homme h11 = new Homme("riko", "BEN EL HADJ", d2, h3, f7);
        Homme h12 = new Homme("david", "BEN EL HADJ", d2, h3, f7);
        m5.addChilden(h11);
        m5.addChilden(h12);

        arbre.ajouterPerson(h1);
        arbre.ajouterPerson(h2);
        arbre.ajouterPerson(h3);
        arbre.ajouterPerson(h4);
        arbre.ajouterPerson(h5);
        arbre.ajouterPerson(h6);
        arbre.ajouterPerson(h7);
        arbre.ajouterPerson(h8);
        arbre.ajouterPerson(h9);
        arbre.ajouterPerson(h10);
        arbre.ajouterPerson(h11);
        arbre.ajouterPerson(h12);
        arbre.ajouterPerson(f1);
        arbre.ajouterPerson(f2);
        arbre.ajouterPerson(f3);
        arbre.ajouterPerson(f4);
        arbre.ajouterPerson(f5);
        arbre.ajouterPerson(f6);
        arbre.ajouterPerson(f7);

        arbre.ajouterMarriage(m1);
        arbre.ajouterMarriage(m2);
        arbre.ajouterMarriage(m3);
        arbre.ajouterMarriage(m4);
        arbre.ajouterMarriage(m5);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GenealogyTreeApp(arbre).setVisible(true);
            }
        });
    }
}
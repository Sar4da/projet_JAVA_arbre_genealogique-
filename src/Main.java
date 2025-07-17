import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        ArbreGenealogique arbre = new ArbreGenealogique();

        // dates
        Date date0 = new Date(45, 1, 6);
        Date date1 = new Date(60, 1, 6);
        Date date2 = new Date(80, 1, 1);
        Date date3 = new Date(100, 1, 1);

        // premier couple
        Homme homme1 = new Homme("Jose","ANTELO", date0);
        Femme femme1 = new Femme("Maria", "ORIDAZ", date0, new ArrayList<>());
        Marriage marriage1 = new Marriage(homme1, femme1);
        homme1.addMarriage(marriage1);
        femme1.addMarriage(marriage1);

        // enfants
        Homme homme2 = new Homme("Andre", "ANTELO", date1, homme1, femme1);
        Femme femme2 = new Femme("Irene", "ANTELO", date1, homme1, femme1);
        Homme homme3 = new Homme("Jose", "ANTELO", date1, homme1, femme1);
        Femme femme3 = new Femme("Elsa", "ANTELO", date1, homme1, femme1);
        Femme femme4 = new Femme("Maria", "ANTELO", date1, homme1, femme1);
        Femme femme5 = new Femme("Kelo", "ANTELO", date1, homme1, femme1);
        Femme femme6 = new Femme("Haydee", "ANTELO", date1, homme1, femme1);
        marriage1.addChilden(homme2);
        marriage1.addChilden(femme2);
        marriage1.addChilden(homme3);
        marriage1.addChilden(femme3);
        marriage1.addChilden(femme4);
        marriage1.addChilden(femme5);
        marriage1.addChilden(femme6);

        // ajout arbre
        arbre.ajouterPerson(homme1);
        arbre.ajouterPerson(femme1);
        arbre.ajouterPerson(homme2);
        arbre.ajouterPerson(femme2);
        arbre.ajouterPerson(homme3);
        arbre.ajouterPerson(femme3);
        arbre.ajouterPerson(femme4);
        arbre.ajouterPerson(femme5);
        arbre.ajouterPerson(femme6);
        arbre.ajouterMarriage(marriage1);

        // deuxième lignée
        //andres
        Femme femme01 = new Femme("Rosa", "MELANO", date1, new ArrayList<>());
        Marriage marriage01 = new Marriage(homme2, femme01);
        homme2.addMarriage(marriage01);
        femme01.addMarriage(marriage01);
        Homme homme01 = new Homme("Juan Carlos", "ANTELO", date2, homme2, femme01);
        Femme femme02 = new Femme("Alicia", "ANTELO", date2, homme2, femme01);
        marriage01.addChilden(homme01);
        marriage01.addChilden(femme02);
        arbre.ajouterPerson(femme01);
        arbre.ajouterPerson(homme01);
        arbre.ajouterPerson(femme02);
        arbre.ajouterMarriage(marriage01);
        //irene
        Homme homme04 = new Homme("Eduardo", "ROJAS", date1, new ArrayList<>());
        Marriage marriage02 = new Marriage(homme04, femme2);
        homme04.addMarriage(marriage02);
        femme2.addMarriage(marriage02);
        Femme femme03 = new Femme("Anita", "ROJAS", date2, homme04, femme2);
        arbre.ajouterPerson(homme04);
        marriage02.addChilden(femme03);
        arbre.ajouterPerson(femme03);
        arbre.ajouterMarriage(marriage02);
        //jose
        Femme femme07 = new Femme("Zulema","ELONGA", date1, new ArrayList<>());
        Marriage marriage03 = new Marriage(homme3, femme07);
        homme3.addMarriage(marriage03);
        femme07.addMarriage(marriage03);
        arbre.ajouterPerson(femme07);
        arbre.ajouterMarriage(marriage03);
        //elsa
        Homme homme05 = new Homme("Ernesto", "CARRERA", date1, new ArrayList<>());
        Marriage marriage04 = new Marriage(homme05, femme3);
        homme05.addMarriage(marriage04);
        femme3.addMarriage(marriage04);
        Femme femme04 = new Femme("Cecilia", "CARRERA", date2, homme05, femme3);
        Homme homme06 = new Homme("Ruben", "CARRERA", date2, homme05, femme3);
        marriage04.addChilden(femme04);
        marriage04.addChilden(homme06);
        arbre.ajouterPerson(homme05);
        arbre.ajouterPerson(femme04);
        arbre.ajouterPerson(homme06);
        arbre.ajouterMarriage(marriage04);

        // troisième lignée
        //Cecilia
        Homme homme07 = new Homme("Mauro", "FORTUNATO", date2, new ArrayList<>());
        Marriage marriage05 = new Marriage(homme07, femme04);
        homme07.addMarriage(marriage05);
        femme04.addMarriage(marriage05);
        Homme homme08 = new Homme("Mauro", "FORTUNATO", date3, homme07, femme04);
        Femme femme08 = new Femme("Gioia", "FORTUNATO", date3, homme07, femme04);
        Femme femme09 = new Femme("Mariela", "FORTUNATO", date3, homme07, femme04);
        marriage05.addChilden(homme08);
        marriage05.addChilden(femme08);
        marriage05.addChilden(femme09);
        arbre.ajouterPerson(homme07);
        arbre.ajouterPerson(homme08);
        arbre.ajouterPerson(femme08);
        arbre.ajouterPerson(femme09);
        arbre.ajouterMarriage(marriage05);
        //Ruben
        Femme femme10 = new Femme("Elena", "SCHVARTZ", date2, new ArrayList<>());
        Marriage marriage06 = new Marriage(homme06, femme10);
        homme06.addMarriage(marriage06);
        femme10.addMarriage(marriage06);
        Femme femme11 = new Femme("Candela", "CARRERA", date3, homme06, femme10);
        marriage06.addChilden(femme11);
        arbre.ajouterPerson(femme10);
        arbre.ajouterPerson(femme11);
        arbre.ajouterMarriage(marriage06);
        Femme femme12 = new Femme("Graciela", "ETCHANDY", date2, new ArrayList<>());
        Marriage marriage07 = new Marriage(homme06, femme12);
        homme06.addMarriage(marriage07);
        femme12.addMarriage(marriage07);
        Femme femme13 = new Femme("Jimena", "CARRERA", date3, homme06, femme12);
        marriage07.addChilden(femme13);
        arbre.ajouterPerson(femme12);
        arbre.ajouterPerson(femme13);
        arbre.ajouterMarriage(marriage07);

        /* Date d0 = new Date(65, 1, 6);
        Date d1 = new Date(80, 1, 6);
        Date d2 = new Date(100, 1, 1);
        Date d3 = new Date(120, 1, 1);

        Homme h1 = new Homme("Cesar", "BEN EL HADJ", d0);
        Femme f1 = new Femme("Francine", "BEN REHOUMA", d0, new ArrayList<>());
        Marriage m1 = new Marriage(h1, f1);
        h1.addMarriage(m1);
        f1.addMarriage(m1);

        // les enfants de h1 et f1
        Homme h2 = new Homme("jean", "BEN EL HADJ", d1, h1, f1);
        Femme f2 = new Femme("dalola", "BEN EL HADJ", d1, h1, f1);
        Homme h3 = new Homme("bob", "BEN EL HADJ", d1, h1, f1);
        m1.addChilden(h2);
        m1.addChilden(f2);
        m1.addChilden(h3);

        // conjoit de h2
        Femme f3 = new Femme("leo", "BEN ali", d1, new ArrayList<>());
        Marriage m2 = new Marriage(h2, f3);
        h2.addMarriage(m2);
        f3.addMarriage(m2);

        // enfants de h2 et f3
        Homme h5 = new Homme("jean", "BEN EL HADJ", d2, h2, f3);
        Femme f5 = new Femme("lola", "BEN EL HADJ", d2, h2, f3);
        Homme h6 = new Homme("bob", "BEN EL HADJ", d2, h2, f3);
        m2.addChilden(h5);
        m2.addChilden(f5);
        m2.addChilden(h6);

        // conjoit de f2
        Homme h4 = new Homme("marc", "BEN jack", d1, new ArrayList<>());
        Marriage m3 = new Marriage(h4, f2);
        h4.addMarriage(m3);
        f2.addMarriage(m3);

        // enfants de h4 et f2
        Homme h7 = new Homme("jojo", "BEN jack", d2, h4, f2);
        Femme f6 = new Femme("polo", "BEN jack", d2, h4, f2);
        m3.addChilden(h7);
        m3.addChilden(f6);

        // conjoit de h3
        Femme f4 = new Femme("lila", "leroi", d1, new ArrayList<>());
        Marriage m4 = new Marriage(h3, f4);
        h3.addMarriage(m4);
        f4.addMarriage(m4);

        // enfants de h3 et f4
        Homme h8 = new Homme("sam", "BEN EL HADJ", d2, h3, f4);
        Homme h9 = new Homme("boby", "BEN EL HADJ", d2, h3, f4);
        Homme h10 = new Homme("fab", "BEN EL HADJ", d2, h3, f4);
        m4.addChilden(h8);
        m4.addChilden(h9);
        m4.addChilden(h10);

        // conjoit de h3
        Femme f7 = new Femme("alia", "yoya", d1, new ArrayList<>());
        Marriage m5 = new Marriage(h3, f7);
        h3.addMarriage(m5);
        f7.addMarriage(m5);

        // enfants de h3 et f7
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
 */


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GenealogyTreeApp(arbre).setVisible(true);
            }
        });
    }
}
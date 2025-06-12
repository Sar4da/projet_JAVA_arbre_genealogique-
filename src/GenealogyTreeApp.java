import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.toedter.calendar.JDateChooser;

public class GenealogyTreeApp extends JFrame {
    private ArbreGenealogique arbre;
   
    public GenealogyTreeApp(ArbreGenealogique arbre) {
        this.arbre = arbre;
        setTitle("Genealogy Tree");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize card layout and panel
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Add menus
        JMenu menu = new JMenu("Options");
        menuBar.add(menu);

        // Create menu items and add action listeners
        JMenuItem menuItem1 = new JMenuItem("Ajout enfant de");
        JMenuItem menuItem2 = new JMenuItem("Ajout conjoint de");
        JMenuItem menuItem3 = new JMenuItem("Afficher toute l'arbre généalogiques");
        JMenuItem menuItem4 = new JMenuItem("Show Person");
        JMenuItem menuItem5 = new JMenuItem("Link between two person");

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menu.add(menuItem5);

        // Add action listeners
        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Ajout enfant de");
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Ajout conjoint de");
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Afficher toute l'arbre généalogiques");
            }
        });

        cardPanel.add(addChildrenJPanel(), "Ajout enfant de");
        cardPanel.add(addSpouseJPanel(), "Ajout conjoint de");
        cardPanel.add(showtree(), "Afficher toute l'arbre généalogiques");

        add(cardPanel);      
    }

    private JPanel addChildrenJPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JTextField firstNameField;
        JTextField lastNameField;
        JComboBox<String> sexComboBox;
        JDateChooser birthDateChooser;
        JComboBox<Person> fatherComboBox = new JComboBox<>();;
        JComboBox<Person> motherComboBox = new JComboBox<>();;
        JButton addButton;
        JPanel inputPanel = new JPanel(new GridLayout(8, 2));
        JTextArea outputArea = new JTextArea();

        List<Person> eligibleFathers = new ArrayList<>();
        List<Person> eligibleMothers = new ArrayList<>();
        // Ajout d'un écouteur de composants swing au JPanel
        panel.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                // Action à effectuer lorsque le JPanel est affiché
                System.out.println("Le JPanel est maintenant affiché !");

                eligibleFathers.clear();
                eligibleFathers.addAll(arbre.getEpoux());
                DefaultComboBoxModel<Person> fatherComboBoxModel = new DefaultComboBoxModel<>(eligibleFathers.toArray(new Person[0]));
                fatherComboBox.setModel(fatherComboBoxModel);
        
                eligibleMothers.clear();    
                eligibleMothers.addAll(arbre.getEpouses());
                DefaultComboBoxModel<Person> motherComboBoxModel = new DefaultComboBoxModel<>(eligibleMothers.toArray(new Person[0]));
                motherComboBox.setModel(motherComboBoxModel);

                System.out.println(eligibleFathers.toString());
                System.out.println(eligibleMothers.toString());

            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                // Action à effectuer lorsque le JPanel est masqué
                System.out.println("Le JPanel est maintenant masqué !");
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                // Action à effectuer lorsque le JPanel est déplacé
                System.out.println("Le JPanel est maintenant déplacé !");
            }
        });

        inputPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("Sex:"));
        String[] sexOptions = {"M", "F"};
        sexComboBox = new JComboBox<>(sexOptions);
        inputPanel.add(sexComboBox);
        inputPanel.add(new JLabel("Birth Date:"));
        birthDateChooser = new JDateChooser();
        inputPanel.add(birthDateChooser);
        inputPanel.add(new JLabel("Father:"));
        inputPanel.add(fatherComboBox);

        inputPanel.add(new JLabel("Mother:"));
        inputPanel.add(motherComboBox);

        addButton = new JButton("Ajout enfant de");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbre.addChildren(firstNameField.getText(), lastNameField.getText(), (String) sexComboBox.getSelectedItem(), birthDateChooser.getDate(), (Homme) fatherComboBox.getSelectedItem(), (Femme) motherComboBox.getSelectedItem()))
                    outputArea.append("Enfant ajouté : " + firstNameField.getText() + " " + lastNameField.getText() + "\n");
                else
                    outputArea.append("Enfant non ajouté : " + firstNameField.getText() + " " + lastNameField.getText() + "\n");

                firstNameField.setText("");
                lastNameField.setText("");
                sexComboBox.setSelectedIndex(0);
                birthDateChooser.setDate(null);
        
                eligibleFathers.clear();
                eligibleFathers.addAll(arbre.getEpoux());
                DefaultComboBoxModel<Person> fatherComboBoxModel = new DefaultComboBoxModel<>(eligibleFathers.toArray(new Person[0]));
                fatherComboBox.setModel(fatherComboBoxModel);
        
                eligibleMothers.clear();
                eligibleMothers.addAll(arbre.getEpouses());
                DefaultComboBoxModel<Person> motherComboBoxModel = new DefaultComboBoxModel<>(eligibleMothers.toArray(new Person[0]));
                motherComboBox.setModel(motherComboBoxModel);
            }
        });
        inputPanel.add(addButton);
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        return panel;
    }

    private JPanel addSpouseJPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JTextField firstNameField;
        JTextField lastNameField;
        JComboBox<String> sexComboBox;
        JDateChooser birthDateChooser;       
        JButton addButton;
        JTextArea outputArea = new JTextArea();
        JPanel inputPanel = new JPanel(new GridLayout(8, 2));
        JComboBox<Person> spouseComboBox = new JComboBox<>();
        List<Person> eligibleSpouses = new ArrayList<>();

        String[] sexOptions = {"M", "F"};
        sexComboBox = new JComboBox<>(sexOptions);

        // Ajout d'un écouteur de composants swing au JPanel
        panel.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                // Action à effectuer lorsque le JPanel est affiché
                System.out.println("Le JPanel est maintenant affiché !");
                String selectedSex = (String) sexComboBox.getSelectedItem();
                eligibleSpouses.clear();
                if (selectedSex == "M") {
                    eligibleSpouses.addAll(arbre.getFemmes(18));
                }
                else {
                    eligibleSpouses.addAll(arbre.getHommes(18));
                }       
                System.out.println(eligibleSpouses.toString());
                DefaultComboBoxModel<Person>  spouseComboBoxModel = new DefaultComboBoxModel<>(eligibleSpouses.toArray(new Person[0]));
                spouseComboBox.setModel(spouseComboBoxModel);
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                // Action à effectuer lorsque le JPanel est masqué
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                // Action à effectuer lorsque le JPanel est déplacé
            }
        });

        inputPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("Sex:"));
        inputPanel.add(sexComboBox);
        sexComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                eligibleSpouses.clear();
                String selectedSex = (String) sexComboBox.getSelectedItem();
                if (selectedSex == "M") {
                    eligibleSpouses.addAll(arbre.getFemmes(18));
                }
                else {
                    eligibleSpouses.addAll(arbre.getHommes(18));
                }       
                System.out.println(eligibleSpouses.toString());
      
                DefaultComboBoxModel<Person> spouseComboBoxModel = new DefaultComboBoxModel<>(eligibleSpouses.toArray(new Person[0]));
                spouseComboBox.setModel(spouseComboBoxModel);
            }
        });

        inputPanel.add(new JLabel("Birth Date:"));
        birthDateChooser = new JDateChooser();
        inputPanel.add(birthDateChooser);
        inputPanel.add(new JLabel("Spouse:"));
        

        inputPanel.add(spouseComboBox);
        addButton = new JButton("Ajout conjoint de");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbre.addMarriage(firstNameField.getText(), lastNameField.getText(), (String) sexComboBox.getSelectedItem(), birthDateChooser.getDate(), (Person) spouseComboBox.getSelectedItem()))
                    outputArea.append("Conjoint ajouté : " + firstNameField.getText() + " " + lastNameField.getText() + "\n");
                else
                    outputArea.append("Conjoint non ajouté : " + firstNameField.getText() + " " + lastNameField.getText() + "\n");
                firstNameField.setText("");
                lastNameField.setText("");
                sexComboBox.setSelectedIndex(0);
                birthDateChooser.setDate(null);
        
                eligibleSpouses.clear();
                eligibleSpouses.addAll(arbre.getEpouses());
                DefaultComboBoxModel<Person> spouseComboBoxModel = new DefaultComboBoxModel<>(eligibleSpouses.toArray(new Person[0]));
                spouseComboBox.setModel(spouseComboBoxModel);
            }
        });
        inputPanel.add(addButton);
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        return panel;
    }


    private JPanel showtree() {
        JPanel panel = new JPanel();
        JTextArea outputArea = new JTextArea();
        JTree tree = new JTree();
        panel.setLayout(new GridLayout(2, 1));
        Icon maleIcon = new ImageIcon("resources/homme.jpg");
        Icon femaleIcon = new ImageIcon("resources/femme.jpg");

        panel.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                Person firstPerson = new Person();
                for (Person person : arbre.getPersons()) {
                    if (person.isIsfirst()) {
                        firstPerson = person;
                        break;
                    }
                }
                System.out.println(firstPerson.toString());
                DefaultMutableTreeNode root = buildTree(firstPerson); // new DefaultMutableTreeNode(firstPerson);
                DefaultTreeModel treeModel = new DefaultTreeModel(root);
                tree.setModel(treeModel);

                DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer() {
                    @Override
                    public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                                  boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                        Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        
                        if (value instanceof DefaultMutableTreeNode) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                            Object userObject = node.getUserObject();
        
                            if (userObject instanceof Person) {
                                Person person = (Person) userObject;
                                if (person instanceof Homme) {
                                    setIcon(maleIcon);
                                } else {
                                    setIcon(femaleIcon);
                                }
                            }
                        }
                        return c;
                    }
                };
                tree.setCellRenderer(renderer);
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                // Action à effectuer lorsque le JPanel est masqué
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                // Action à effectuer lorsque le JPanel est déplacé
            }
        });

        tree.getSelectionModel().addTreeSelectionListener(e -> {
            // Obtenez le nœud sélectionné
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectedNode != null && selectedNode.getUserObject() instanceof Person) {
                Person person = (Person) selectedNode.getUserObject();
                // Obtenez le nom du nœud sélectionné
                outputArea.setText("");
                outputArea.append("Prenom : " + person.getFirstName() + "\n");
                outputArea.append("Nom : " + person.getLastName() + "\n");
                if (person instanceof Homme) outputArea.append("sex : M\n");
                else outputArea.append("Sexe : F\n");
                outputArea.append("Date de naissance : " + (1900 + person.getBirthDate().getYear()) + "/" + (person.getBirthDate().getMonth()+1) + "/" + person.getBirthDate().getDate() + "\n");
                if (person.getFather() != null)
                    outputArea.append("Pere : " + person.getFather().getFirstName() + " " + person.getFather().getLastName() + "\n");
                if (person.getMother() != null)
                    outputArea.append("Mere : " + person.getMother().getFirstName() + " " + person.getMother().getLastName() + "\n");
                for (Marriage marriage : person.getMarriages()) {
                    if (person instanceof Homme)
                        outputArea.append("Conjoint : " + marriage.getWife().getFirstName() + " " + marriage.getWife().getLastName() + "\n");
                    else
                        outputArea.append("Conjoint : " + marriage.getHusband().getFirstName() + " " + marriage.getHusband().getLastName() + "\n");
                    for (Person children : marriage.getChildrens()) {
                        outputArea.append("    Enfant : " + children.getFirstName() + " " + children.getLastName() + "\n");
                    }
                }
                outputArea.append("Cousins :  \n");
                for (Person cousin : arbre.getCousins(person)) {
                    outputArea.append("    " + cousin.toString() + "\n");
                }
                outputArea.append("Ancêtres (Pere / Mere): \n");
                for (Marriage marriage : arbre.getAncetres(person)){
                    outputArea.append("    " + marriage.getHusband().getFirstName() + " " + marriage.getHusband().getLastName() + " / " + marriage.getWife().getFirstName() + " " + marriage.getWife().getLastName() + "\n"  );
                }
                outputArea.append("Freres : \n");
                for (Homme f : arbre.getFreres(person)){
                    outputArea.append("    " + f.getFirstName() + " " + f.getLastName() + "\n"  );
                }
                outputArea.append("Soeurs : \n");
                for (Femme s : arbre.getSoeurs(person)){
                    outputArea.append("    " + s.getFirstName() + " " + s.getLastName() + "\n"  );
                }
                outputArea.append("Demi freres : \n");
                for (Homme f : arbre.getDemiFreres(person)){
                    outputArea.append("    " + f.getFirstName() + " " + f.getLastName() + "\n"  );
                }
                outputArea.append("Demi Soeurs : \n");
                for (Femme s : arbre.getDemiSoeurs(person)){
                    outputArea.append("    " + s.getFirstName() + " " + s.getLastName() + "\n"  );
                }                
            }
        });
        
        panel.add(new JScrollPane(tree));
        panel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        return panel;
    }


    private DefaultMutableTreeNode buildTree(Person person){
        List<Marriage> PersonMarriages = person.getMarriages();
        if (PersonMarriages.isEmpty())
            return (new DefaultMutableTreeNode(person));
        DefaultMutableTreeNode e = new DefaultMutableTreeNode(person);
        for (Marriage marriage : PersonMarriages) {
            for (Person p : marriage.getChildrens()) {
                e.add(buildTree(p));
            }
        }        
        return e;
    }
}




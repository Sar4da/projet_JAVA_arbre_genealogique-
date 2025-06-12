import javax.swing.*;
import java.awt.*;

public class GenealogyTreeApp extends JFrame {

    private ArbreGenealogique arbre;

    public GenealogyTreeApp(ArbreGenealogique arbre) {
        this.arbre = arbre;
        setTitle("Arbre Généalogique");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeUI();
    }

    private void initializeUI() {
        // Here you can add components to display the genealogy tree
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Example of adding a label (you can replace this with your tree visualization)
        JLabel label = new JLabel("Bienvenue dans l'application Arbre Généalogique");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        add(panel);
    }
}
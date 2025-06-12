# Arbre Généalogique

Ce projet est une application Java qui permet de gérer un arbre généalogique. Il permet de créer des instances d'hommes et de femmes, de gérer leurs mariages et leurs enfants, et d'afficher l'arbre généalogique à l'aide d'une interface graphique.

## Structure du projet

Le projet est structuré comme suit :

```
arbre-genealogique
├── src
│   ├── Main.java                # Point d'entrée de l'application
│   ├── ArbreGenealogique.java   # Gère l'arbre généalogique
│   ├── Homme.java               # Représente un homme dans l'arbre
│   ├── Femme.java               # Représente une femme dans l'arbre
│   ├── Marriage.java            # Représente un mariage
│   ├── GenealogyTreeApp.java    # Interface graphique de l'application
│   └── utils
│       └── Utils.java           # Méthodes utilitaires
├── .gitignore                   # Fichiers à ignorer par Git
├── pom.xml                      # Configuration Maven
└── README.md                    # Documentation du projet
```

## Installation

1. Clonez le dépôt :
   ```
   git clone <url-du-depot>
   ```
2. Accédez au dossier du projet :
   ```
   cd arbre-genealogique
   ```
3. Compilez le projet avec Maven :
   ```
   mvn clean install
   ```

## Utilisation

Pour exécuter l'application, utilisez la commande suivante :
```
mvn exec:java -Dexec.mainClass="Main"
```

## Contribuer

Les contributions sont les bienvenues ! Veuillez soumettre une demande de tirage pour toute amélioration ou correction.
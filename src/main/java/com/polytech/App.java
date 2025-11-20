package com.polytech;


import com.polytech.tp.Cours;
import com.polytech.tp.CoursBuilder;
import com.polytech.tp.GestionnaireEmploiDuTemps;
import com.polytech.tp.Etudiant;
import com.polytech.tp.Responsable;
import com.polytech.tp.ICours;
import com.polytech.tp.CoursEnLigne;
import com.polytech.tp.CoursEnAnglais;
import com.polytech.tp.CoursMagistral;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

    
Cours cours =  new CoursBuilder()
    .setMatiere("Génie Logiciel")
    .setEnseignant("Dr. Smith")
    .setSalle("A101")
    .setDate("2024-01-15")
    .setHeureDebut("14:00")
    .setEstOptionnel(true)
    .setNiveau("Master")
    .setNecessiteProjecteur(true)
    .build();



    GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();

       
        Etudiant etudiant1 = new Etudiant("Alice");
        Etudiant etudiant2 = new Etudiant("Bob");
        Responsable responsable = new Responsable("Dr. Dupont");

       
        gestionnaire.attach(etudiant1);
        gestionnaire.attach(etudiant2);
        gestionnaire.attach(responsable);

       
        Cours coursMath = Cours.builder()
            .setMatiere("Mathématiques")
            .setEnseignant("Prof. Martin")
            .setSalle("B201")
            .setDate("2024-01-20")
            .setHeureDebut("10:00")
            .build();
           
        Cours coursInfo = Cours.builder()
            .setMatiere("Informatique")
            .setEnseignant("Prof. Durand")
            .setSalle("A101")
            .build();

        
        System.out.println("=== AJOUT DE COURS ===");
        gestionnaire.ajouterCours(coursMath);
        
        System.out.println("\n=== MODIFICATION DE COURS ===");
        gestionnaire.modifierCours(coursMath, "Changement de salle pour A105");
        
        System.out.println("\n=== ANNULATION DE COURS ===");
        gestionnaire.annulerCours(coursMath);
        
        System.out.println("\n=== CHANGEMENT GÉNÉRAL ===");
        gestionnaire.setChangement("Emploi du temps révisé pour le semestre");
        System.out.println("\n=== DÉSABONNEMENT ===");
        gestionnaire.detach(etudiant2);
        gestionnaire.ajouterCours(coursInfo); 



 ICours coursBase = Cours.builder()
            .setMatiere("Génie Logiciel")
            .setEnseignant("Dr. Smith")
            .setSalle("A101")
            .build();

        System.out.println("Cours de base: " + coursBase.getDescription());

        // Application des décorateurs
        ICours coursEnLigne = new CoursEnLigne(coursBase);
        System.out.println("Cours en ligne: " + coursEnLigne.getDescription());

        ICours coursEnAnglais = new CoursEnAnglais(coursBase);
        System.out.println("Cours en anglais: " + coursEnAnglais.getDescription());

        // Combinaison de décorateurs
        ICours coursComplet = new CoursMagistral(
                              new CoursEnAnglais(
                              new CoursEnLigne(coursBase)));
                              System.out.println("Cours complet: " + coursComplet.getDescription());
        // Output: "Cours de Génie Logiciel avec Dr. Smith (A101) (En ligne) (En anglais) (Magistral)"

        // Autre combinaison
        ICours autreCombinaison = new CoursEnLigne(
                                  new CoursMagistral(coursBase));
        System.out.println("Autre combinaison: " + autreCombinaison.getDescription());

    }
    }



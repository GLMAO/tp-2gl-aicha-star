package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> observateurs = new ArrayList<>();
    private String dernierChangement;

   
    @Override
    public void attach(Observer o) {
        observateurs.add(o);
    }

    @Override
    public void detach(Observer o) {
        observateurs.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observateur : observateurs) {
            observateur.update(message);
        }
    }

    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        String message = "Nouveau cours ajouté : " + cours.getDescription();
        System.out.println(message);
        notifyObservers(message);
    }

    public void modifierCours(ICours cours, String modifications) {
       
        String message = "Cours modifié : " + cours.getDescription() + " - " + modifications;
        System.out.println(message);
        notifyObservers(message);
    }

    public void annulerCours(ICours cours) {
        this.listeCours.remove(cours);
        String message = "Cours annulé : " + cours.getDescription();
        System.out.println(message);
        notifyObservers(message);
    }

    
    public void setChangement(String changement) {
        this.dernierChangement = changement;
        
        notifyObservers(changement);
    }
}
 cs (8)[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/rGfOobSC)






PRINCIPES RESPECTÉS
1. SRP (Single Responsibility)
CoursBuilder : seulement la construction

Cours : seulement les données du cours

CoursDecorator : seulement l'ajout de fonctionnalités

GestionnaireEmploiDuTemps : gestion des cours + observateurs

2. OCP (Open/Closed)
Decorator : Nouveaux décorateurs sans modifier l'existant

Observer : Nouveaux observateurs sans modifier le Subject

Builder : Extension de la construction sans modifier Cours
3. LSP (Liskov Substitution)
Tous les décorateurs remplacent ICours

Tous les observateurs implémentent Observer

CoursBuilder retourne toujours un Cours valide

4. ISP (Interface Segregation)
ICours : interface minimale et cohérente

Observer : une seule méthode

Subject : responsabilités claires
5. DIP (Dependency Inversion)
Dépendances sur interfaces (ICours, Observer, Subject)

Injection des dépendances dans les décorateurs.


PRINCIPES VIOLÉS
1. SRP dans GestionnaireEmploiDuTemps
public class GestionnaireEmploiDuTemps {
    // Gère à la fois :
    // - Liste des cours (métier)
    // - Observateurs (pattern)  
    // - Notifications (communication)
}
2. OCP dans Cours
Ajout d'attributs nécessite modification du Builder


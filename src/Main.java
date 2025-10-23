import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestionCollections gestion = new GestionCollections();

        Livre livre1 = new Livre("Le Dernier Voeu", 1993, "Andrzej Sapkowki", 332);
        Livre livre2 = new Livre("La Tour de l'Elu", 1996, "Andrzej Sapkowki", 450);
        Livre livre3 = new Livre("Le Siegneur des anneax", 1954, "J.R.R. Tolkien", 1069);
        Livre livre4 = new Livre("Le Hobbit", 1937, "J.R.R. Tolkien", 310);
        Livre livre5 = new Livre("Sharko", 2017, "Franck Thilliez", 622);

        CD cd1 = new CD("Night Visions", 2012, "Imagine Dragons", 52);
        CD cd2 = new CD("Evolve", 2017, "Imagine Dragons", 47);
        CD cd3 = new CD("Violator", 1990, "Depeche Mode", 47);
        CD cd4 = new CD("Sounds of the Universe", 2009, "Depeche Mode", 58);

        Membre membre1 = new Membre("Adam", 1);
        Membre membre2 = new Membre("Eve", 2);
        Membre membre3 = new Membre("Anne", 3);

        gestion.ajouterMedia(livre1);
        gestion.ajouterMedia(livre2);
        gestion.ajouterMedia(livre3);
        gestion.ajouterMedia(livre4);
        gestion.ajouterMedia(livre5);
        gestion.ajouterMedia(cd1);
        gestion.ajouterMedia(cd2);
        gestion.ajouterMedia(cd3);
        gestion.ajouterMedia(cd4);
        gestion.ajouterMembre(membre1);
        gestion.ajouterMembre(membre2);
        gestion.ajouterMembre(membre3);

        //Version précédente étape 3 du TP
        //gestion.emprunterMedia(membre, livre);
        //gestion.afficherEmprunts();

        System.out.println("=== Tous les médias ===");
        GestionCollections.afficherListe(gestion.getMediasDisponibles());

        System.out.println("\n=== Médias publiés après 2010 ===");
        List<Media> mediasRecents = GestionCollections.filtrer(gestion.getMediasDisponibles(),
                media -> media.getAnneePublication() > 2010);
        GestionCollections.afficherListe(mediasRecents);

        System.out.println("\n=== Membres dont le nom commence par 'A' ===");
        List<Membre> membresA = GestionCollections.filtrer(new ArrayList<>(gestion.getMembres()),
                membre -> membre.getNom().startsWith("A"));
        GestionCollections.afficherListe(membresA);

        // Étape 5: Tri avec comparateurs
        System.out.println("\n=== Tri des médias (année décroissante, puis titre) ===");
        List<Media> mediasTries = new ArrayList<>(gestion.getMediasDisponibles());
        mediasTries.sort(GestionCollections.comparateurMedia());
        GestionCollections.afficherListe(mediasTries);

        System.out.println("\n=== Tri des livres (auteur, puis titre) ===");
        List<Livre> livres = GestionCollections.filtrerLivres(gestion.getMediasDisponibles());
        livres.sort(GestionCollections.comparateurLivre());
        GestionCollections.afficherListe(livres);

        // Étape 6: Tests avancés
        gestion.emprunterMedia(membre1, livre1);
        gestion.emprunterMedia(membre1, livre2);
        gestion.emprunterMedia(membre1, cd1);
        gestion.emprunterMedia(membre1, cd2);
        gestion.emprunterMedia(membre2, livre3);
        gestion.emprunterMedia(membre2, livre4);
        gestion.emprunterMedia(membre2, cd3);
        gestion.emprunterMedia(membre3, livre4);
        gestion.emprunterMedia(membre3, livre5);
        gestion.emprunterMedia(membre3, cd4);

        System.out.println("\n=== Emprunts ===");
        gestion.afficherEmprunts();

        System.out.println("\n=== Médias empruntés (sans doublons) ===");
        GestionCollections.afficherListe(new ArrayList<>(gestion.getMediasEmpruntes()));

        System.out.println("\n=== Copie de collection ===");
        List<Media> copieMedias = new ArrayList<>();
        GestionCollections.copierCollection(gestion.getMediasDisponibles(), copieMedias);
        System.out.println("Copie contient " + copieMedias.size() + " éléments");

        System.out.println("\n=== Uniquement les livres ===");
        GestionCollections.afficherListe(GestionCollections.filtrerLivres(gestion.getMediasDisponibles()));
    }
}
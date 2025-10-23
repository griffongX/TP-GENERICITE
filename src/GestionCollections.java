import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GestionCollections {
    private List<Media> mediasDisponibles = new ArrayList<>();
    private Set<Membre> membres = new HashSet<>();
    private Map<Membre, List<Media>> emprunts = new HashMap<>();

    public void ajouterMedia(Media media) {
        mediasDisponibles.add(media);
    }
    
    public void ajouterMembre(Membre membre) {
        membres.add(membre);
    }
    
    public void emprunterMedia(Membre membre, Media media) {
        membre.emprunterMedia(media);
        emprunts.computeIfAbsent(membre, k -> new ArrayList<>()).add(media);
    }
    
    public void afficherEmprunts() {
        for (Membre membre : emprunts.keySet()) {
            System.out.println(membre + " a emprunté : " + emprunts.get(membre));
        }
    }

    public List<Media> getMediasDisponibles() {
        return mediasDisponibles;
    }

    public Set<Membre> getMembres() {
        return membres;
    }

    // Méthodes génériques
    public static <T> void afficherListe(List<T> liste) {
        for (T element : liste) {
            System.out.println(element);
        }
    }

    public static <T> List<T> filtrer(List<T> liste, Predicate<T> critere) {
        return liste.stream()
                .filter(critere)
                .collect(Collectors.toList());
    }

    // Étape 5: Comparateurs

    /**
     *
     * @return trie les Media par anneePublication décroissante
     */
    public static Comparator<Media> comparateurMedia() {
        return Comparator
                .comparingInt(Media::getAnneePublication).reversed()
                .thenComparing(Media::getTitre);
    }

    /**
     *
     * @return trie les Livre par auteur puis titre
     */
    public static Comparator<Livre> comparateurLivre() {
        return Comparator
                .comparing(Livre::getAuteur)
                .thenComparing(Livre::getTitre);
    }

    // Étape 6: Méthodes avancées

    /**
     *
     * @param source copie les éléments sans perdre le type
     * @param destination
     * @param <T>
     */
    public static <T> void copierCollection(Collection<T> source, Collection<T> destination) {
        destination.addAll(source);
    }

    public Set<Media> getMediasEmpruntes() {
        Set<Media> mediasEmpruntes = new HashSet<>();
        for (List<Media> listeMedias : emprunts.values()) {
            mediasEmpruntes.addAll(listeMedias);
        }
        return mediasEmpruntes;
    }

    /**
     *
     * @param medias
     * @return filtre pour obtenir les objets de type Livre
     */
    public static List<Livre> filtrerLivres(List<Media> medias) {
        return medias.stream()
                .filter(media -> media instanceof Livre)
                .map(media -> (Livre) media)
                .collect(Collectors.toList());
    }
}

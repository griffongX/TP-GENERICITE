public class Livre extends Media {
    private String auteur;
    private int NbPages;

    //Constructeur paramétré
    public Livre(String titre, int anneePublication, String auteur, int NbPages) {
        super(titre, anneePublication);
        this.auteur = auteur;
        this.NbPages = NbPages;
    }

    //Getter pour auteur (tri)
    public String getAuteur() {
        return auteur;
    }

    //Rédefinition getDescription
    @Override
    public String getDescription() {
        return "Livre de" + auteur + "," + NbPages + "pages.";
    }

}

public class CD extends Media {
    private String artist;
    private int duree;

    //Constructeur paramétré
    public CD(String titre, int anneePublication, String artist, int duree) {
        super(titre, anneePublication);
        this.artist = artist;
        this.duree = duree;
    }

    //Rédéfinition getDescription
    @Override
    public String getDescription() {
        return "CD de" + artist + " durée : " + duree + " min. ";
    }
}

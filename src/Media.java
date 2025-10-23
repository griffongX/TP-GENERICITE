public abstract class Media {
    private String titre;
    private int anneePublication;


    //Constructeur par défaut
    public Media() {
        this.titre = "";
        this.anneePublication = 0;
    }

    //Constructeur Paramétré
    public Media(String titre, int anneePublication) {
        this.titre = titre;
        this.anneePublication = anneePublication;
    }

    //Méthodes
    public String getTitre() {
        return this.titre;
    }
    public int getAnneePublication() {
        return this.anneePublication;
    }
    public abstract String getDescription();

    @Override
    public String toString() {
        return titre + " (" + anneePublication + ")";
    }
}

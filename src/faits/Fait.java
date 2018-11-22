package faits;


/**
 * La classe qui contient un fait
 * Un fait est une affirmation qui est soit vraie soit fausse
 */
public class Fait {

    /**
     * ennoncé du fait
     */
    private String libelle;

    public Fait(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public String toString(){
        return this.getLibelle();
    }

    public Boolean isTrue() {
        return null;
    }
}
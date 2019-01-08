package faits;


/**
 * La classe qui contient un fait
 * Un fait est une affirmation qui est soit vraie soit fausse
 */
public abstract class Fait {

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

    public abstract boolean isTrue();

    public boolean equals(Object f){
        Fait cmp = (Fait) f;
        return libelle.equals(cmp.getLibelle());
    }
}
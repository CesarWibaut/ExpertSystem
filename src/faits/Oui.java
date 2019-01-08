package faits;

/**
 * Classe d'un fait vrai
 */
public class Oui extends FaitDecorator{

    public Oui(String libelle){
        super(libelle);
    }

    public boolean isTrue() {
        return true;
    }
}
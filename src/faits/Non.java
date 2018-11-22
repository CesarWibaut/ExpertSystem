package faits;

/**
 * Classe d'un fait faux
 */
public class Non extends FaitDecorator{

    public Non(Fait fait) {
        super(fait);
    }

    public Boolean isTrue() {
        return false;
    }
}
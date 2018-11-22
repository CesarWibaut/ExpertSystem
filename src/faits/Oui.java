package faits;

/**
 * Classe d'un fait vrai
 */
public class Oui extends FaitDecorator{

    public Oui(Fait fait){
        super(fait);
    }

    @Override
    public Boolean isTrue() {
        return true;
    }
}
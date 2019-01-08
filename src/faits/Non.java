package faits;

/**
 * Classe d'un fait faux
 */
public class Non extends FaitDecorator{

    public Non(String libelle){
        super(libelle);
    }

    public Non(Fait fait){
        super(fait);
    }

    @Override
    public boolean isTrue() {
        return !super.isTrue();
    }
}
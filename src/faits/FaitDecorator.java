package faits;

/**
 * Décorateur du Fait, il permet de définir si un fait est
 * vrai ou faux
 */
public abstract class FaitDecorator extends Fait{

    /**
     * Encapsulation du fait original
     */
    protected Fait fait;

    public FaitDecorator(Fait fait){
        super(fait.getLibelle());
        this.fait = fait;
    }

    public abstract Boolean isTrue();

    public String toString(){
        return isTrue() ? "OUI(" + getLibelle() +")" : "NON(" + getLibelle() + ")";
    }
}
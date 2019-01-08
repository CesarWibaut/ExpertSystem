package faits;

/**
 * Décorateur du Fait, il permet de définir si un fait est
 * vrai ou faux
 */
public abstract class FaitDecorator extends Fait{

    private Fait fait;

    public FaitDecorator(String libelle){
        super(libelle);
    }

    public FaitDecorator(Fait f){
        super(f.getLibelle());
        this.fait = f;
    }

    public boolean isTrue() {
        if(fait == null){
            return true;
        }
        return fait.isTrue();
    }

    public String toString(){
        return isTrue() ? getLibelle() : "NON(" + getLibelle() + ")";
    }
}
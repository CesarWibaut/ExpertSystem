package regles;

import java.util.ArrayList;
import java.util.stream.Collectors;

import faits.Fait;

/**
 * Classe d'un règle
 */
public class Regle {

    private ArrayList<Fait> premisses;
    private Fait conclusion;
    private String nom;

    public Regle(){
        this.premisses= new ArrayList<Fait>();
    }

    /**
     * @param conclusion the conclusion to set
     */
    public void setConclusion(Fait conclusion) {
        this.conclusion = conclusion;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Ajouter un fait en condition à une règle
     * @param fait la condition
     */
    public void addPremisse(Fait fait){
        this.premisses.add(fait);
    }

    /**
     * @return the conclusion
     */
    public Fait getConclusion() {
        return conclusion;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the premisses
     */
    public ArrayList<Fait> getPremisses() {
        return premisses;
    }
    
    /**
     * toString method
     */
    public String toString(){
        String prem = getPremisses().stream().map(x -> x.toString() ).collect(Collectors.joining(" et "));
        return getNom() + " : Comme " + prem + " alors " + getConclusion();
    }
}
package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import exception.IncoherentFactsException;
import faits.Fait;
import regles.Regle;

/**
 * Classe permettant le chaînage arrière
 */
public class ChainageArriere {

    /**
     * Méthode principale effectuant toutes les vérifications pour vérifier ou non le fait initial
     * @param fait le fait inconnu à valider ou non
     * @param regles liste des regles
     * @throws IncoherentFactsException
     */
    public static void run(Fait fait, ArrayList<Regle> regles) throws IncoherentFactsException{
        ArrayList<Fait> faits = getEveryFacts(fait, (ArrayList<Regle>) regles.clone());
        removeMultiple(faits);
        askQuestions(faits);
        Moteur.run(faits, regles);
    }

    private static void removeMultiple(ArrayList<Fait> faits) {
        faits = new ArrayList<Fait>(faits.stream().distinct().collect(Collectors.toList()));
    }

    private static void askQuestions(ArrayList<Fait> faits) {
        ArrayList<Fait> factToRemove = new ArrayList<Fait>();
        String res = "";

        Scanner sc = new Scanner(System.in);
        for(Fait f : faits){
            do {
                System.out.println("Est ce que le fait " + f.getLibelle() + " est vrai ? (y/n)");
                res = sc.nextLine();
            }while(!res.equals("y")&&!res.equals("n"));
            if(!isSame(res, f)){
                factToRemove.add(f);
            }
        }
        faits.removeAll(factToRemove);
    }

    private static boolean isSame(String res, Fait f) {
        if(res.equals("y") && (f.isTrue()==null || f.isTrue())) return true;
        if(res.equals("n") && f.isTrue()!=null && !f.isTrue()) return true;
        return false;
    }

    private static ArrayList<Fait> getEveryFacts(Fait fait, ArrayList<Regle> regles) {
        boolean changed;
        ArrayList<Fait> ret = new ArrayList<Fait>();
        ret.add(fait);
        do{
            changed = false;
            ArrayList<Regle> ruleToRemove = new ArrayList<Regle>();
            for(Regle r : regles){
                ArrayList<Fait> factToRemove = new ArrayList<Fait>();
                ArrayList<Fait> factToAdd = new ArrayList<Fait>();

                for(Fait f : ret){
                    if(r.getConclusion().getLibelle().equals(f.getLibelle())){
                        factToRemove.add(f);
                        ruleToRemove.add(r);
                        factToAdd.addAll(r.getPremisses());
                        changed = true;
                    }
                }
                ret.removeAll(factToRemove);
                ret.addAll(factToAdd);
            }
            regles.removeAll(ruleToRemove);

        }while(changed);
        return ret;
    }

}
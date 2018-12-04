package main;

import regles.Regle;

import java.util.ArrayList;

import exception.IncoherentFactsException;
import faits.*;
/**!
 * Moteur du système
 */
public class Moteur {


    /**
     * Méthode principale qui trace toute la route correspondante en fonction des
     * faits et des règles
     * 
     * @param args
     * @throws Exception
     */
    public static void run(ArrayList<Fait> faits, ArrayList<Regle> regles) throws IncoherentFactsException {
        
        for (Fait f : faits) {
            contains(faits, f);
        }
        
        boolean isOver = false;

        while(!isOver){

            Regle regle = searchCompatibleRule(regles, faits);
            if(regle == null){
                isOver = true;
            }else {
                System.out.println(regle);
                regles.remove(regle);
                if(!contains(faits, regle.getConclusion())) faits.add(regle.getConclusion());
            }
        }
    }

    private static Regle searchCompatibleRule(ArrayList<Regle> regles, ArrayList<Fait> faits){
        
        for(Regle r : regles){
            boolean contains = true;
            for(Fait fromRule : r.getPremisses()){
                boolean atLeastOne = false;
                for(Fait fait : faits){
                    if(fait.getLibelle().equals(fromRule.getLibelle()) && (fait.isTrue() == fromRule.isTrue())) atLeastOne = true;
                }
                if(!atLeastOne) contains =false;
            }
            if(contains) return r;
        }
        return null;
    }

    private static boolean contains(ArrayList<Fait> faits, Fait fait) throws IncoherentFactsException {
        for(Fait f : faits){
            if(f.getLibelle().equals(fait.getLibelle())){
                if(f.isTrue() != fait.isTrue()) throw new IncoherentFactsException("Incohérence dans les faits : " + f + " et " + fait);
                return true;
            } 
        }
        return false;
    }

}
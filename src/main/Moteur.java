package main;

import loaders.FaitsLoader;
import loaders.ReglesLoader;
import regles.Regle;

import java.util.ArrayList;

import faits.*;
/**
 * Moteur du système
 */
public class Moteur {


    /**
     * Méthode principale qui trace toute la route correspondante en fonction
     * des faits et des règles
     * @param args
     */
    public static void run(String [] args) {
        ArrayList<Fait> faits = FaitsLoader.getFaitsFromPath("/Users/wibautc/Documents/DA2I/eclipse-workspace/Projet/src/faits.txt");
       

        ArrayList<Regle> regles = ReglesLoader.getReglesFromPath("/Users/wibautc/Documents/DA2I/eclipse-workspace/Projet/src/regles.txt");
       

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
            for(Fait fromrule : r.getPremisses()){
                boolean atLeastOne = false;
                for(Fait fait : faits){
                    if(fait.getLibelle().equals(fromrule.getLibelle()) && (fait.isTrue() == fromrule.isTrue())) atLeastOne = true;
                }
                if(!atLeastOne) contains =false;
            }
            if(contains) return r;
        }
        return null;
    }

    private static boolean contains(ArrayList<Fait> faits, Fait fait){
        for(Fait f : faits){
            if(f.getLibelle().equals(fait.getLibelle())) return true;
        }
        return false;
    }
}
package main;

import java.util.ArrayList;
import java.util.Scanner;

import exception.IncoherentFactsException;
import faits.Fait;
import loaders.FaitsLoader;
import loaders.ReglesLoader;
import regles.Regle;

/**
 * Main class
 */
public class App {

    /**
     * Lance l'application
     * @param args
     */
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Chemin du fichier contenant les faits : ");
    	String factsPath = sc.nextLine();
    	
        ArrayList<Fait> faits = FaitsLoader.getFaitsFromPath(factsPath);
       
        System.out.println("Chemin du fichier contenant les règles : ");
    	String rulesPath = sc.nextLine();
    	
        ArrayList<Regle> regles = ReglesLoader.getReglesFromPath(rulesPath);
       
        sc.close();
        
        try {
			Moteur.run(faits, regles);
		} catch (IncoherentFactsException e) {
			e.printStackTrace();
		}
    }
}
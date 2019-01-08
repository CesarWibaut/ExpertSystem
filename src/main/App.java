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
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Chemin du fichier contenant les faits : ");
        String factsPath = sc.nextLine();
        // String factsPath = "src/faits.txt";
        ArrayList<Fait> faits = FaitsLoader.getFaitsFromPath(factsPath);

        System.out.println("Chemin du fichier contenant les règles : ");
        String rulesPath = sc.nextLine();
        // String rulesPath = "src/regles.txt";

        ArrayList<Regle> regles = ReglesLoader.getReglesFromPath(rulesPath);
        String res = "";
        do {
            System.out.println("Inférence par chaînage arrière ? (y/n)");
            res = sc.nextLine();
        } while (!res.equals("y") && !res.equals("n"));

        if (res.equals("y")) {
            try {
                ChainageArriere.run(faits.get(0), regles);
            } catch (IncoherentFactsException e) {
                e.printStackTrace();
            }
        }else {
            try {
                Moteur.run(faits, regles);
            } catch (IncoherentFactsException e) {
                e.printStackTrace();
            }
        }
        sc.close();
    }
}
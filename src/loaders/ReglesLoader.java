package loaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import utils.FaitParser;
import regles.Regle;

/**
 * Classe permetant de charger les règles depuis un fichier texte
 */
public class ReglesLoader {

    private static Regle regle = null;
    private static int cpt = 0;

    /**
     * Méthode retournant la liste des règles depuis un fichier texte
     * @param path le chemin absolu du fichier contenant les règles
     * @return la liste des règles
     */
    public static ArrayList<Regle> getReglesFromPath(String path) {

        ArrayList<Regle> list = new ArrayList<Regle>();
        
        resetRegle();
        
        try(Stream<String> stream = Files.lines(Paths.get(path))){

            stream.forEach(x -> {

                if(x.isEmpty()) {
                    list.add(cpt, regle);
                    cpt++;
                    resetRegle();
                }else {
                    String firstWord = x.split(" ")[0];

                    switch (firstWord) {
                        case "REGLE":
                            regle.setNom(x.replace("REGLE ", ""));
                            break;
                    
                        case "SI" :
                        case "ET" :
                            regle.addPremisse(FaitParser.parseToFait(x.substring(3)));
                            break;

                        case "ALORS" :
                            regle.setConclusion(FaitParser.parseToFait(x.substring(6)));
                            break;

                        default:
                            break;
                    }

                }
            });
            list.add(cpt, regle);
            return list;


        }catch(IOException e) {
            e.printStackTrace();
        }

        return null;

    }


    private static void resetRegle(){
        regle = new Regle();
    }
}
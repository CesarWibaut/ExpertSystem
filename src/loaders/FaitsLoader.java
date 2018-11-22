package loaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import faits.*;
import utils.FaitParser;

/**
 * Classe permetant de charger les faits depuis un fichier texte
 */
public class FaitsLoader {

    /**
     * Méthode statique retournant une liste de Fait
     * @param path chemin absolu du fichier contenants les faits
     * @return la liste d'objet Fait
     */
    public static ArrayList<Fait> getFaitsFromPath(String path) {

        ArrayList<Fait> list = new ArrayList<Fait>();

        try(Stream<String> sf = Files.lines(Paths.get(path))){

            sf.forEach(x-> {
                list.add(FaitParser.parseToFait(x));
            });

            return list;
        }catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
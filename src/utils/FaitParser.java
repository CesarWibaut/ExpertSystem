package utils;

import faits.*;
/**
 * Classe permetant de transformer un String en Fait
 */
public class FaitParser {

    /**
     * @param x Le String à transformer
     * @return Le fait correspondant
     */
    public static Fait parseToFait(String x){
        if(x.contains("NON(")) {
            x = x.replace("NON(", "");
            return new Non(x.substring(0,x.length()-1));
        }else if(x.contains("OUI(")){
            x = x.replace("OUI(", "");
            return new Oui(x.substring(0,x.length()-1));
        }else {
            return new Oui(x);
        }
    }
}
//packages
package net.ictcampus.rts.model;

import java.util.ArrayList;

//imports

import java.util.List;

/**
 * Klasse SpielFeld,
 * 
 * @author lauwrensw
 *
 */

public class SpielFeld {

    // ---------------------------variable_declaration---------------------------//

//    private List<Mensch> einheiten;
    private List<Armee> armies = new ArrayList<Armee>();
    private List<Stadt> staedte;
    private Feld[][] felder;

    // -------------------------------Constructor--------------------------------//

    public SpielFeld(int xLength, int yLength) {

        felder = new Feld[xLength][yLength];

        for (int j = 0; j <= yLength; j++) {
            for (int i = 0; i <= xLength; i++) {
                Feld feld = new Feld(i, j);
                felder[i][j] = feld;
            }
        }
    }

    // -----------------------------------Main-----------------------------------//

    // ---------------------------------Methods---------------------------------//


    public void stadtBauen(int xPos, int yPos, Player spieler, Stadt stadt, String name) {

        int bezahlt;
        int kosten = 1000;
        Feld thisField = felder[xPos][yPos];
        Stadt thisCity = thisField.getStadt();

        if (thisCity == null && kosten <= stadt.checkVorrat("Geld")) {
            thisField.erzeugeStadt(name, spieler);
            bezahlt = stadt.checkVorrat("Geld") - kosten;
            stadt.vorratVerringern("Geld", bezahlt);
        }
    }

    public void armeeBewegen(int xPos, int yPos, Armee armee) {
        
        armee.armeeBewegen(xPos, yPos);
        
    }

   

    // ------------------------------Getter_Setter------------------------------//
    
    public List<Armee> getArmies() {
        return armies;
    }

    public List<Stadt> getStaedte() {
        return staedte;
    }
    
    
}

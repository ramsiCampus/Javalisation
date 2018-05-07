//packages
package net.ictcampus.rts.model;

//imports

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

import net.ictcampus.rts.view.Testframe;

/**
 * Klasse SpielLogik,
 * 
 * @author lauwrensw
 *
 */

public class SpielLogik {

    // ---------------------------variable_declaration---------------------------//

    private Spiel spiel;

    private SpielFeld spielfeld;
    private Mensch protMensch;
    private List<Player> spieler = new ArrayList<Player>();
    private int max = 5;
    private int min = 1;

    // -------------------------------Constructor--------------------------------//

    public SpielLogik() {

        spieler.add(new Player("Game", 0));
        spieler.add(new Player("Winnie", 1));
        spieler.add(new Player("r�msi", 2));

        this.protMensch = new Mensch(spieler.get(0), 10);

        this.spiel = new Spiel(20, 10, spieler.get(1), spieler.get(2), protMensch);

        this.spielfeld = spiel.getSpielFeld();

    }
    
    /**
     * Hey Ho I hamer mol d Freiheit gno zum afach de Konstruktor schriebe willi vom ServerSpielController mue ch�ne sege wivil Spieler
     * dasses geh mues. Worschinli schribi au no en separate Spiel-Konstruktor, do en Mensch immer en Bsitzer het und alles s�tt
     * neutral initialisiert werde.
     * 
     * Gruess Keya
     * 
     * @param anzahlSpieler
     */
    public SpielLogik(int anzahlSpieler) {
    	for(int i=0; i<anzahlSpieler; i++){
    		spieler.add(new Player("Player_"+i, i));
    	}
    	
    	this.protMensch = new Mensch(new Player("Game", -1), 10);
    	
    	//Zweiter Spieler sollte mal noch ge�ndert werden zu Spieler.get(1)
        this.spiel = new Spiel(20, 10, spieler.get(0), spieler.get(0), protMensch);

        this.spielfeld = spiel.getSpielFeld();
    	
    }
    

    // -----------------------------------Main-----------------------------------//

    public static void main(String[] args) {
        
        SpielLogik sl = new SpielLogik();
        
        int[] command = new int[]{1,2,8,3,8,2,10};

        int[] command2 = new int[]{1,4,8,2,7,2,0};
        int[] command3 = new int[]{1,3,8,3,17,2,0};
//        int[] command3 = new int[]{1,2,8,3,8,2,10};
        

//        Ramsi Testing armeebewegen
//        int[] command = new int[]{1,2,8,3,8,2,10};
//        int[] command2 = new int[]{1,4,8,2,7,2,0};
//        int[] command4 = new int[]{1,4,7,2,6,2,0};
//        sl.commandAusfuehren(command);
//        System.out.println("1 Armee(8,2) (10): "+sl.spielfeld.getFelder()[8][2].getEinheiten().get(0).getArmee().size());
//        sl.commandAusfuehren(command);
//        System.out.println("2 Armeen merged (8,2) (20): "+sl.spielfeld.getFelder()[8][2].getEinheiten().get(0).getArmee().size());
//        System.out.println("Anzahl Armeen(8,2) (1): "+sl.spielfeld.getFelder()[8][2].getEinheiten().size());
//        sl.commandAusfuehren(command2);
//        System.out.println("Armee bewegt(7,2) (20): "+sl.spielfeld.getFelder()[7][2].getEinheiten().get(0).getArmee().size());
//        //sl.commandAusfuehren(command3);        
//        sl.commandAusfuehren(command4);
//        System.out.println("Armee bewegt(6,2) (20): "+sl.spielfeld.getFelder()[6][2].getEinheiten().get(0).getArmee().size());
//        System.out.println("Feld leer(7,2) (0): "+sl.spielfeld.getFelder()[7][2].getEinheiten().size());
//        System.out.println("Feld leer(8,2) (0): "+sl.spielfeld.getFelder()[8][2].getEinheiten().size());
//        //System.out.println("truppen (8,2) (0): "+sl.spielfeld.getFelder()[8][2].getEinheiten().get(0).getArmee().size());
//        
        
        
        System.out.println(sl.spielfeld.getStadt(8, 3).getVolk().size());
       
//        for (Stadt i : sl.spielfeld.getStaedte()) {
//            System.out.println("Stadtname" + i.getName());
//            System.out.println(i.getVorratGUI("Geld"));
//            System.out.println(i.getxPos());
//            System.out.println(i.getyPos());
//
//        }


        Testframe tf = new Testframe(sl);


//        System.out.println("Armee 1: "+sl.spielfeld.getFelder()[8][3].getEinheiten().get(0).getArmee().size());
//        System.out.println("Armee 2: "+sl.spielfeld.getFelder()[7][2].getEinheiten().get(0).getArmee().size());
        
        

    }

    // ---------------------------------Methods---------------------------------//

    public boolean commandAusfuehren(int[] command) {
        
        if(command.length != 7){
            return false;
        }
        
        switch(command[1]){
        
        case(1):
            menschenKaufen(spieler.get(command[0]), spielfeld.getFelder()[command[2]][command[3]].getStadt(), command[6]);
            break;
        case(2):
            armeeErzeugen(command[4], command[5], spieler.get(command[0]), spielfeld.getFelder()[command[2]][command[3]].getStadt(), command[6], "Schweizer Armee");
            break;
        case(3):
            int counter = 0;
            for(Stadt s : spielfeld.getStaedte()){
                if(s.getBesitzer() == spieler.get(command[0])){
                    counter++;
                }
            }
            String anzahl = Integer.toString(counter);
            kaufeStadt(command[4], command[5], spieler.get(command[0]), 500, spielfeld.getFelder()[command[2]][command[3]].getStadt().getName(), anzahl, protMensch);
            break;
        case(4):
            Armee zielArmee = null;
            List<Armee> armeen = spielfeld.getFelder()[command[2]][command[3]].getEinheiten();
            for(Armee a : armeen){
                if(a.getBesitzer() == spieler.get(command[0])){
                    zielArmee = a;                 
                }
            }
            armeeBewegen(command[4], command[5], zielArmee, spieler.get(command[0]));
            break;
        }
        
        return true;

    }

    public void spielerHinzufuegen(Player playingSpieler) {

        spieler.add(playingSpieler);

    }

    public void armeeErzeugen(int xPos, int yPos, Player playingSpieler, Stadt stadt,
            int anzahlMenschen, String name) {
        if (stadt.menschenBewegen(anzahlMenschen, name)) {
            armeeBewegen(xPos, yPos, stadt.getArmee(), playingSpieler);
        }
    }

    public void armeeBewegen(int xPos, int yPos, Armee armee, Player playingSpieler) {

        if (armee.getBesitzer() == playingSpieler) {
            spielfeld.armeeBewegen(xPos, yPos, armee);
        }
    }

    public void menschenKaufen(Player playingSpieler, Stadt stadt, int mengeMenschen) {

        if (stadt.getBesitzer() == playingSpieler) {
            stadt.menschKaufen(protMensch, mengeMenschen);
        }

    }

    public void kaufeStadt(int xPos, int yPos, Player playingSpieler, int startKapital,
            String ursprungsStadtName, String name, Mensch protMensch) {

        spielfeld.stadtKaufen(xPos, yPos, playingSpieler, name, ursprungsStadtName, startKapital,
                protMensch);
    }

    public void ereignisGenerieren() {

        int zufallszahl;
        int staedteLaenge = spielfeld.getStaedte().size();
        int zufallsStadt;

        Random randomZahl = new Random();
        zufallszahl = randomZahl.nextInt(max - min) + min;

        Random randomZahl1 = new Random();
        zufallsStadt = randomZahl1.nextInt(staedteLaenge - 0);
        Ereignis ereignis = new Ereignis("test", spielfeld.getStaedte().get(zufallsStadt),
                zufallszahl);

    }

    // ------------------------------Getter_Setter------------------------------//

    public Spiel getSpiel() {
        return spiel;
    }
}
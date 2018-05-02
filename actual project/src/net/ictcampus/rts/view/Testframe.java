package net.ictcampus.rts.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.font.*;



public class Testframe extends JFrame {

    private JPanel map;
    private JPanel content;
    private JPanel title;
    private ButtonField[][] field;

    /**
     * What was that for?
     */
    // private static final long serialVersionUID = -6325432051352243062L;

    public Testframe() {

        super("Javalisation");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.initContent();
        this.setVisible(true);
    }

    public void initContent() {

        this.setSize(1800, 900);
        this.setLayout(new BorderLayout());
        map = new JPanel();
        content = new JPanel();
        title = new JPanel();

        addFieldButtons(20, 10);
        setContent();
        setTitle();

        this.add(map, "North");
        this.add(title, "Center");
        this.add(content, "South");

    }

    public void addFieldButtons(int xSize, int ySize) {

        map.setLayout(new GridLayout(ySize, xSize));

        field = new ButtonField[xSize][ySize];

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                field[j][i] = new ButtonField(j, i);
                field[j][i].setBackground(new Color(57, 211, 214));
                map.add(field[j][i]);
                // ActionListener added here TODO
            }
        }
    }

    public void setContent() {
        content.setLayout(new GridLayout(1, 3));
        JPanel contentLeft = new JPanel();
        JPanel contentCenter = new JPanel();
        JPanel contentRight = new JPanel();
        JPanel contentBorderCenter = new JPanel();
        JPanel contentBorderRight = new JPanel();
        JPanel contentBorderLeft = new JPanel();

        content.setPreferredSize(new Dimension(300, 300));

        contentLeft.setLayout(new BoxLayout(contentLeft, BoxLayout.Y_AXIS));
        contentCenter.setLayout(new BoxLayout(contentCenter, BoxLayout.Y_AXIS));
        contentRight.setLayout(new BoxLayout(contentRight, BoxLayout.Y_AXIS));

        contentLeft.setBorder(BorderFactory.createLineBorder(getForeground()));
        contentCenter.setBorder(BorderFactory.createLineBorder(getForeground()));
        contentRight.setBorder(BorderFactory.createLineBorder(getForeground()));

        contentLeft.add(contentBorderLeft);
        contentRight.add(contentBorderRight);
        contentCenter.add(contentBorderCenter);

        contentBorderCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentBorderLeft.setBorder(BorderFactory.createEmptyBorder(80, 100, 80, 20));
        contentBorderRight.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 20));

        Font titel = new Font("Calibri",1, 20);
        
        setContentLeft(contentBorderLeft);
        setContentCenter(contentBorderCenter,titel);
        setContentRight(contentBorderRight,titel);

        content.add(contentLeft);
        content.add(contentCenter);
        content.add(contentRight);
    }

    public void setTitle() {
        title.setLayout(new GridLayout(1, 3));
        JLabel titleLeft = new JLabel("Spielerinfo");
        JLabel titleCenter = new JLabel("Ausgew�hltes Feld: ");
        JLabel titleRight = new JLabel();

        Font font = new Font("Calibri", 1, 40);
        titleLeft.setFont(font);
        titleCenter.setFont(font);
        titleRight.setFont(font);

        // titleLeft.setText("Spielerinfo");
        titleRight.setText("....");

        title.add(titleLeft);
        title.add(titleCenter);
        title.add(titleRight);
    }

    private void setContentLeft(JPanel contentBorderLeft) {
        contentBorderLeft.setLayout(new GridLayout(5, 2));

        JLabel menschenAnzahl = new JLabel("800000");
        JLabel ressourcenAnzahl = new JLabel("2022541100");
        JLabel stadtAnzahl = new JLabel("6");
        JLabel sammelAnzahl = new JLabel("600023");
        JLabel menschenInStadtAnzahl = new JLabel("400000");

        contentBorderLeft.add(new JLabel("Menschen:"));
        contentBorderLeft.add(menschenAnzahl);
        contentBorderLeft.add(new JLabel("Ressourcen:"));
        contentBorderLeft.add(ressourcenAnzahl);
        contentBorderLeft.add(new JLabel("Anz. St�dte:"));
        contentBorderLeft.add(stadtAnzahl);
        contentBorderLeft.add(new JLabel("M. am Sammeln:"));
        contentBorderLeft.add(sammelAnzahl);
        contentBorderLeft.add(new JLabel("M. in der Stadt:"));
        contentBorderLeft.add(menschenInStadtAnzahl);

    }

    private void setContentCenter(JPanel p,Font titel) {
        p.setLayout(new GridLayout(7, 3));

        JLabel lblTitel = new JLabel("Aktionen");
        JButton btnCreateP = new JButton("Menschen erstellen");
        JButton btnBuildC = new JButton("Stadt bauen");
        JButton btnCollectR = new JButton("Ressourcen sammenln");
        JButton btnStoreR = new JButton("Ressourcen lagern");
        JButton btnTransportP = new JButton("Menschen transportieren");
        JTextField txtCreateP = new JTextField();
        JTextField txtTransportPkoo = new JTextField();
        JTextField txtTransportPanz = new JTextField();

        
        lblTitel.setFont(titel);
        
        p.add(lblTitel);
        p.add(new JLabel(""));
        p.add(new JLabel(""));
        
        p.add(btnCreateP);
        p.add(txtCreateP);
        p.add(new JLabel("Anzahl"));

        p.add(btnBuildC);
        p.add(new JLabel(""));
        p.add(new JLabel(""));

        p.add(btnCollectR);
        p.add(new JLabel(""));
        p.add(new JLabel(""));

        p.add(btnStoreR);
        p.add(new JLabel(""));
        p.add(new JLabel(""));

        p.add(btnTransportP);
        p.add(txtTransportPkoo);
        p.add(txtTransportPanz);

        p.add(new JLabel(""));
        p.add(new JLabel("Koordinaten"));
        p.add(new JLabel("Anzahl"));

    }

    private void setContentRight(JPanel p,Font titel) {
        p.setLayout(new GridLayout(7, 2));
        p.setBackground(new Color(247, 76, 76));
        JLabel lblInfo = new JLabel("Info");
        JLabel lblFeldart = new JLabel("Stadt");
        JLabel lblBesitzer = new JLabel("Roger");
        JLabel lblKoordinaten = new JLabel("12�N 10�O");
        JLabel lblAnzahlMenschen = new JLabel("100");
        JLabel lblGesammelteR = new JLabel("1000");
        JLabel lblVerfuegbareR = new JLabel("2000");
        
        lblInfo.setFont(titel);
        
        p.add(lblInfo);
        p.add(new JLabel());
        p.add(new JLabel("Feldart"));
        p.add(lblFeldart);
        p.add(new JLabel("Besitzer:"));
        p.add(lblBesitzer);
        p.add(new JLabel("Koordinaten:"));
        p.add(lblKoordinaten);
        p.add(new JLabel("Menschen:"));
        p.add(lblAnzahlMenschen);
        p.add(new JLabel("Gesammelte Ressourcen:"));
        p.add(lblGesammelteR);
        p.add(new JLabel("Verf�gbare Ressourcen:"));
        p.add(lblVerfuegbareR);
    }

}

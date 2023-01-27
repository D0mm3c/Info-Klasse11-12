import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 23.01.2023
 * @author 
 */

public class QuadratischeGleichungen extends JFrame {
  //Var. Eingegebene Zahlen
  double a;
  double b;
  double c;
  //Var. Ergebnisse
  double x1;
  double x2;

  private JLabel lNullstelleQuadratischeGleichung1 = new JLabel();
  private JNumberField jNumberField_a = new JNumberField();
  private JLabel jLabelGleichungx2 = new JLabel();
  private JNumberField jNumberField_b = new JNumberField();
  private JLabel lx1 = new JLabel();
  private JNumberField jNumberField_c = new JNumberField();
  private JLabel l1 = new JLabel();
  private JLabel lx2 = new JLabel();
  private JLabel lx3 = new JLabel();
  private JTextField jTextFieldx1 = new JTextField();
  private JTextField jTextFieldx2 = new JTextField();
  private JButton bBerechnen1 = new JButton();
  private JLabel lAnmerkung1 = new JLabel();
  
  // Ende Attribute
  public QuadratischeGleichungen() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("QuadratischeGleichungen");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    cp.setBackground(Color.WHITE);
    // Anfang Komponenten
    
    lNullstelleQuadratischeGleichung1.setBounds(16, 16, 195, 24);
    lNullstelleQuadratischeGleichung1.setText("Nullstelle Quadratische Gleichung");
    cp.add(lNullstelleQuadratischeGleichung1);
    jNumberField_a.setBounds(48, 48, 48, 24);
    jNumberField_a.setText("");
    cp.add(jNumberField_a);
    jLabelGleichungx2.setBounds(96, 48, 32, 24);
    jLabelGleichungx2.setText("x^2+");
    cp.add(jLabelGleichungx2);
    jNumberField_b.setBounds(128, 48, 48, 24);
    jNumberField_b.setEditable(true);
    cp.add(jNumberField_b);
    lx1.setBounds(176, 48, 32, 24);
    lx1.setText("x+");
    cp.add(lx1);
    jNumberField_c.setBounds(192, 48, 40, 24);
    cp.add(jNumberField_c);
    l1.setBounds(232, 48, 32, 24);
    l1.setText("=0");
    cp.add(l1);
    lx2.setBounds(24, 96, 24, 24);
    lx2.setText("x1=");
    cp.add(lx2);
    lx3.setBounds(24, 128, 24, 24);
    lx3.setText("x2=");
    cp.add(lx3);
    jTextFieldx1.setBounds(48, 96, 200, 24);
    jTextFieldx1.setEditable(false);
    cp.add(jTextFieldx1);
    jTextFieldx2.setBounds(48, 128, 200, 24);
    jTextFieldx2.setEditable(false);
    cp.add(jTextFieldx2);
    bBerechnen1.setBounds(40, 224, 80, 24);
    bBerechnen1.setText("Berechnen");
    bBerechnen1.setMargin(new Insets(2, 2, 2, 2));
    bBerechnen1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBerechnen1_ActionPerformed(evt);
      }
    });
    cp.add(bBerechnen1);
    lAnmerkung1.setBounds(48, 176, 224, 24);
    lAnmerkung1.setText("Anmerkung:");
    cp.add(lAnmerkung1);
    
    // Ende Komponenten
    setVisible(true);
  }
  
  
  public static void main(String[] args) {
    new QuadratischeGleichungen();
  }
  public void bBerechnen1_ActionPerformed(ActionEvent evt) {
    //Scannen Zahlen
    this.a = jNumberField_a.getDouble();
    this.b = jNumberField_b.getDouble();
    this.c = jNumberField_c.getDouble();   
    //Algorhythmus Nullstellen von quadratischen Gleichungen
    if(a == 0 ){
      if(b == 0){
        if(c == 0){
          jTextFieldx1.setText("R");
          jTextFieldx2.setText("---");
          lAnmerkung1.setText("Anmerkung: undendlich viele Nullstellen");
        }else{
          jTextFieldx1.setText("---");
          jTextFieldx2.setText("---");
          lAnmerkung1.setText("Anmerkung: keine Nullstellen");
        }
        
      }else{
        this.x1 = (-this.c/this.b); 
        jTextFieldx1.setText("" + this.x1);
        jTextFieldx2.setText("---");
        lAnmerkung1.setText("Anmerkung: es gibt nur eine Nullstelle"); 
      }
      
      
    }else if((b == 0) &  (c == 0)){
        jTextFieldx1.setText("0.0");
        jTextFieldx2.setText("---");
      lAnmerkung1.setText("Anmerkung: es gibt nur eine Nullstelle");}
        else if((Math.pow(this.b, 2))-4*this.a*this.c < 0){
          jTextFieldx1.setText("---");
          jTextFieldx2.setText("---");
          lAnmerkung1.setText("Anmerkung: keine Nullstellen");
          
        }else{
          this.x1 = ((-1*this.b) + Math.sqrt(Math.pow(this.b, 2) - (4* this.a*this.c)))/(2*this.a);
          this.x2 = ((-1*this.b) - Math.sqrt(Math.pow(this.b, 2) - (4* this.a*this.c)))/(2*this.a);
          
          //ausgabe Ergebnisse + Anmerkungen 
          jTextFieldx1.setText("" + this.x1);
          jTextFieldx2.setText("" + this.x2);
          lAnmerkung1.setText("Anmerkung: es gibt zwei Nullstellen");
          
          
        }
  }
}

     

  

  // Ende Methoden

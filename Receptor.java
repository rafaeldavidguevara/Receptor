/*Elaborado por Rafael Guevara
Ejemplo pestañas swing
*/
package com.rd.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Receptor extends JPanel {
  private static String cadenas[] = {"Head ID", "Type", "Customer","Supplier","Staff","Other"};
  private GridBagConstraints constraints = new GridBagConstraints();	
    
  private JPanel crearPanel(){
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    JLabel etiqueta = new JLabel(cadenas[0] + ": ");  
    setNewConstraints(0, 0, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
    panel.add(etiqueta, constraints);
    setNewConstraints(1, 0, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
    panel.add(new JTextField(), constraints);
    JLabel etiqueta_2 = new JLabel(cadenas[1] + ": ");  
    setNewConstraints(0, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
    panel.add(etiqueta_2, constraints);	
	int k = 2;
	ButtonGroup group = new ButtonGroup();
	for (int i=1; i<=4; i++){
	  setNewConstraints(i, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
      JRadioButton rbutton = new JRadioButton(cadenas[k++]);
	  group.add(rbutton);
	  panel.add(rbutton, constraints); 
	}
	return panel;	
  }
  
  private JPanel crearPanelInf(){
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER));
	JButton button_1 = new JButton("Save");
	JButton button_2 = new JButton("Reset");
	JButton button_3 = new JButton("Close");
	button_1.setPreferredSize(new Dimension(70, 25));
	button_2.setPreferredSize(new Dimension(70, 25));
	button_3.setPreferredSize(new Dimension(70, 25));
	panel.add(button_1);   
	panel.add(button_2);	
	panel.add(button_3);
	return panel;	
  }  
 
  private void setNewConstraints(int gridx, int gridy, int gridwidth,
                           int gridheight, int weightx, int anchor, 
				           int fill){
    constraints.gridx = gridx;				
    constraints.gridy = gridy;
    constraints.gridwidth = gridwidth;
    constraints.gridheight = gridheight;
    constraints.weightx = (double) weightx;
    constraints.anchor = anchor;
    constraints.fill = fill; 
    constraints.insets = new Insets(5,5,0,0);	
  }
  
  public Receptor(){
	try{
      String look = "javax.swing.plaf.nimbus.NimbusLookAndFeel";   	
      UIManager.setLookAndFeel(look);
      setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
      setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
      add(crearPanel());
      add(crearPanelInf());
    } catch( Exception e ){
      System.err.println("No se puede cambiar al LookAndFeel");
    }  
     
    
  }

  public static void main( String args[] ) {
    JFrame frame = new JFrame("Register");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new Receptor(), BorderLayout.CENTER);
    frame.setSize(460,145);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
} 

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.*;


public class ColorPalette extends JPanel implements Observer {

    JButton[] buttons;
    JButton colorPicker;
    int NUM_OF_BUTTONS = 9;
    final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.GRAY, Color.ORANGE, Color.PINK, Color.YELLOW, Color.MAGENTA, Color.CYAN};
    Model model;
    
    public ColorPalette(Model model_) {
        
        this.setLayout(new GridLayout(0,2));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //this.setMaximumSize(new Dimension(100,500));
        model = model_;  
        
        buttons = new JButton[NUM_OF_BUTTONS];
        for (int i = 0; i < NUM_OF_BUTTONS; i++) {           
            buttons[i] = new JButton();
            buttons[i].setBackground(colors[i]);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);             
            this.add(buttons[i]);        
        }
        
        colorPicker = new JButton("custom");

        this.add(colorPicker);
        
            colorPicker.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    model.setCurrentColor(JColorChooser.showDialog(ColorPalette.this, "custom color", model.getCurrentColor()));
                }
            });
        
            buttons[0].addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {                 
                    model.setCurrentColor(colors[0]);            
                } 
            }); 

            buttons[1].addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {                 
                    model.setCurrentColor(colors[1]);            
                } 
            }); 

            buttons[2].addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {                 
                    model.setCurrentColor(colors[2]);            
                } 
            }); 

            buttons[3].addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {                 
                    model.setCurrentColor(colors[3]);            
                } 
            }); 

            buttons[4].addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {                 
                    model.setCurrentColor(colors[4]);            
                } 
            }); 

            buttons[5].addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {                 
                    model.setCurrentColor(colors[5]);            
                } 
            }); 

            buttons[6].addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {                 
                    model.setCurrentColor(colors[6]);            
                } 
            }); 

            buttons[7].addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {                 
                    model.setCurrentColor(colors[7]);            
                } 
            });    

            buttons[8].addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {                 
                    model.setCurrentColor(colors[8]);            
                } 
            });               
                     
    }
    
	// Observer interface 
	@Override
	public void update(Observable arg0, Object arg1) {
        //override code	
        
	}
}
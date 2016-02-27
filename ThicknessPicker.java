import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ThicknessPicker extends JPanel implements Observer {

    //variables
    JButton[] thicknessButtons;
    int NUM_OF_THICKNESS = 4;
    Model model;
    
    public ThicknessPicker(Model model_) {
        
        this.setLayout(new GridLayout(0,2));
        //this.setPreferredSize(new Dimension(50));
        model = model_;
        
        thicknessButtons = new JButton[NUM_OF_THICKNESS];
        for (int i = 0; i <NUM_OF_THICKNESS; i++) {
            thicknessButtons[i] = new JButton(Integer.toString(i + 1));
            this.add(thicknessButtons[i]);
        }
        
        thicknessButtons[0].addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {                 
                model.setCurrentThickness(1);            
            }
        }); 

        thicknessButtons[1].addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {                 
                model.setCurrentThickness(2);            
            } 
        }); 

        thicknessButtons[2].addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {                 
                model.setCurrentThickness(3);            
            } 
        }); 

        thicknessButtons[3].addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {                 
                model.setCurrentThickness(4);            
            } 
        });         
        
    }
         
	// Observer interface 
	@Override
	public void update(Observable arg0, Object arg1) {
        //override code	
	}
}
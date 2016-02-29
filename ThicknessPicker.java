import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ThicknessPicker extends JPanel implements Observer {

    //variables
    JButton[] thicknessButtons;
    int NUM_OF_THICKNESS = 4;
    Model model;
    JSlider tslider;
    int MAX_THICKNESS = 10;
    
    public ThicknessPicker(Model model_) {
        
        this.setPreferredSize(new Dimension(80,100));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        model = model_;
        tslider = new JSlider(JSlider.VERTICAL, 1, MAX_THICKNESS, 1);
        tslider.setPaintTicks(true);
        tslider.setSnapToTicks(true);
        tslider.setMajorTickSpacing(1);
        tslider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                model.setCurrentThickness(tslider.getValue());
            }
        });
        this.add(tslider);
        
    }
         
	// Observer interface 
	@Override
	public void update(Observable arg0, Object arg1) {
        //override code	
	}
}
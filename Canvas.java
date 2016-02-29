import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;	
import java.awt.Color;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Canvas extends JPanel implements Observer {
    
    //variables 
    private Model model;
    private Position prev;
    private Position cur;
    
    //constructors
    public Canvas(Model model_) {

        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        model = model_;
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
                if (model.isPlaying()) return;
                
                Stroke s = new Stroke(model.getCurrentColor(), model.getCurrentThickness() );
                Position p = new Position(e.getX(), e.getY());
                s.addStrokeLinePosition(p);
                model.addStroke(s);
                model.addPlayBackTick();
                model.setCurrentTick(model.getPlayBackTicks());
            }
            public void mouseReleased(MouseEvent e) {
                
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Position p = new Position(e.getX(), e.getY());
                model.addStrokeLinePosition(p);         
            }
        });        
    
    }
    
    @Override 
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        //System.out.println("drawing up to " + model.getCurrentTick());
        Graphics2D g = (Graphics2D) gr;
        for (int i = 0; i < model.getCurrentTick(); i++) {
            g.setStroke(new BasicStroke(model.strokes.get(i).getThickness()));
            g.setColor(model.strokes.get(i).getColor());
            for (int j = 1; j < model.strokes.get(i).line.size(); j++) {
                g.drawLine(model.strokes.get(i).line.get(j-1).getX(), model.strokes.get(i).line.get(j-1).getY(), model.strokes.get(i).line.get(j).getX(), model.strokes.get(i).line.get(j).getY() );
            }
        }
    }
    
	// Observer interface 
	@Override
	public void update(Observable o, Object arg) {
        repaint();		
	}
    
}
import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class PlayBack extends JPanel implements Observer {
    
    private Model model;
    JButton play, start, end;
    JSlider timeline;
    int MAX_N_OF_TICKS = 10000;
    
    class SliderListener implements ChangeListener {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()) {
                     int currentTick = (int)source.getValue(); 
                     currentTick = currentTick/(MAX_N_OF_TICKS/model.getPlayBackTicks());
                     model.setCurrentTick(currentTick); 
                }
            }
    }
    
    public PlayBack(Model model_) {
         
        setLayout(new BorderLayout());
        model = model_;
        
        play = new JButton("play");
        JPanel pl = new JPanel();
        pl.add(play);
        this.add(pl, BorderLayout.LINE_START);
        
        timeline = new JSlider(JSlider.HORIZONTAL, 0, MAX_N_OF_TICKS, MAX_N_OF_TICKS);        
        timeline.setPaintTicks(true);
        timeline.setSnapToTicks(true);
        this.add(timeline, BorderLayout.CENTER);
        
        start = new JButton("start");
        end = new JButton("end");
        JPanel p = new JPanel();
        p.add(start);
        p.add(end);
        
        this.add(p, BorderLayout.LINE_END);
        
        
        play.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                try {
                    playVideo();
                }
                catch (InterruptedException eror) {
                    System.out.println("error");
                }
            }
        });
        
        start.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                timeline.setValue(0);
            }
        });
        
        end.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                timeline.setValue(MAX_N_OF_TICKS);
            }
        });
        
        timeline.addChangeListener(new SliderListener());
        
    }

	@Override
	public void update(Observable o, Object arg) {
        
       if (model.getPlayBackTicks() > 0) {
           timeline.setMajorTickSpacing(MAX_N_OF_TICKS/model.getPlayBackTicks()); 
       }
       
       if (model.getCurrentTick() != 0) {
           timeline.setValue(model.getCurrentTick()*(MAX_N_OF_TICKS/model.getPlayBackTicks()));
       }
       
	}
    
    public void playVideo() throws InterruptedException {
        model.play();
        System.out.println("they pressed me 0_0. dont press me!");
        model.stopPlay();
    }
}
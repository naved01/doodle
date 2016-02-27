import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;

public class Doodle extends JFrame {
    
    JMenuBar menuBar;
    JMenu file, view, submenu;
    JMenuItem menuItem;   
    
    public Doodle() {
        
        Model model = new Model();
        
        Canvas canvas = new Canvas(model);
        model.addObserver(canvas);
        ColorPalette colorPalette = new ColorPalette(model);
        model.addObserver(colorPalette);
        ThicknessPicker thicknessPicker = new ThicknessPicker(model);
        model.addObserver(thicknessPicker);
        PlayBack playBack = new PlayBack(model);
        model.addObserver(playBack);
        
        //model.notifyObservers();
        JPanel customizer = new JPanel(new BorderLayout());
        customizer.add(colorPalette, BorderLayout.PAGE_START);
        customizer.add(thicknessPicker);
        customizer.setPreferredSize(new Dimension(70, 300));
        
        JPanel drawingPanel = new JPanel(new BorderLayout());
        drawingPanel.add(customizer, BorderLayout.LINE_START);
        drawingPanel.add(canvas);
        
        JPanel p = new JPanel(new BorderLayout());
        getContentPane().add(p);

        p.add(drawingPanel, BorderLayout.PAGE_START);
        p.add(playBack);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 400);
        setJMenuBar(getMenu());
        setTitle("doodly doodle");
        setVisible(true);
        
    }
    
   public JMenuBar getMenu() {
       
        menuBar = new JMenuBar();
        
        file = new JMenu("File");
        view = new JMenu("View");

        menuBar.add(file);
        menuBar.add(view);
        
        menuItem = new JMenuItem("New");
        menuItem.getAccessibleContext().setAccessibleDescription("doesnt do much");
        file.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.getAccessibleContext().setAccessibleDescription("doesnt do much");
        file.add(menuItem);

        menuItem = new JMenuItem("Load");
        menuItem.getAccessibleContext().setAccessibleDescription("doesnt do much");
        file.add(menuItem);
        
        file.addSeparator();
        menuItem = new JMenuItem("Exit");
        menuItem.getAccessibleContext().setAccessibleDescription("doesnt do much");
        file.add(menuItem);
        
        menuItem = new JMenuItem("Full");
        menuItem.getAccessibleContext().setAccessibleDescription("doesnt do much");
        view.add(menuItem);        
        
        submenu = new JMenu("Fit");
        menuItem = new JMenuItem("Original Size");
        submenu.add(menuItem);
        menuItem = new JMenuItem("Fit for window");
        submenu.add(menuItem);
        
        view.add(submenu);  
        
        return menuBar;     
   }
    
   public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
          public void run() {
              Doodle doodle = new Doodle();
          } 
       });
   }
    
}
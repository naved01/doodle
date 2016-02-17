import javax.swing.*;
import java.awt.*;

public class Doodle extends JFrame {
    
    JMenuBar menuBar;
    JMenu file, view, submenu;
    JMenuItem menuItem;   
    
    public Doodle() {
        
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
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 400);
        setJMenuBar(menuBar);
        setTitle("doodly doodle");
        setVisible(true);
    }
    
   public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
          public void run() {
              Doodle doodle = new Doodle();
          } 
       });
   }
    
}
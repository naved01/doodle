import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.awt.GridLayout;

public class Doodle extends JFrame {
    
    JMenuBar menuBar;
    JMenu file, view, submenu;
    JMenuItem menuItem;
    JFileChooser loadFileChooser, saveFileChooser;
    Model model;
    
    public Doodle() {
        
        saveFileChooser = new JFileChooser();
        loadFileChooser = new JFileChooser();
        loadFileChooser.addChoosableFileFilter(new BinaryFilter());
        loadFileChooser.addChoosableFileFilter(new TextFilter());
        model = new Model();
        
        Canvas canvas = new Canvas(model);
        model.addObserver(canvas);
        ColorPalette colorPalette = new ColorPalette(model);
        model.addObserver(colorPalette);
        ThicknessPicker thicknessPicker = new ThicknessPicker(model);
        model.addObserver(thicknessPicker);
        PlayBack playBack = new PlayBack(model);
        model.addObserver(playBack);
        
        JPanel customizer = new JPanel();
        customizer.setLayout(new BoxLayout(customizer, BoxLayout.Y_AXIS));
        colorPalette.setAlignmentX(Component.CENTER_ALIGNMENT);
        customizer.add(colorPalette);
        thicknessPicker.setAlignmentX(Component.CENTER_ALIGNMENT);
        customizer.add(thicknessPicker); 

               
        JPanel drawingPanel = new JPanel(new BorderLayout());
        drawingPanel.add(customizer, BorderLayout.LINE_START);
        drawingPanel.add(canvas);
        
        JPanel p = new JPanel(new BorderLayout());
        getContentPane().add(p);

        p.add(drawingPanel);
        p.add(playBack, BorderLayout.PAGE_END);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100, 100);
        setMinimumSize(new Dimension(700, 500));
        setJMenuBar(getMenu());
        setTitle("doodily doodle");
        setVisible(true);
        
    }
    
   public void saveFile()  {
        int returnVal = saveFileChooser.showSaveDialog(saveFileChooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File ourfile = saveFileChooser.getSelectedFile();
                if (!Utils.getExtension(ourfile).equalsIgnoreCase(Utils.txt) && !Utils.getExtension(ourfile).equalsIgnoreCase(Utils.bin) ) {                           
                    ourfile = new File(ourfile.toString() + ".ddbin");
                } 
                ObjectOutputStream obj_out = new ObjectOutputStream (new FileOutputStream(ourfile));
                obj_out.writeObject(model);
                obj_out.close();
                JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);                                                
            } catch (IOException error) {
                error.printStackTrace();
            }                  
        } 
   }
    
   public JMenuBar getMenu() {
       
        menuBar = new JMenuBar();
        
        file = new JMenu("File");
        view = new JMenu("View");

        menuBar.add(file);
        menuBar.add(view);
        
        menuItem = new JMenuItem("New");
        menuItem.addMouseListener(new MouseAdapter() {
            
            public void mouseReleased(MouseEvent e) {
                if (!model.isNew()) {
                    int save = JOptionPane.showConfirmDialog(Doodle.this, "Would you like to save?", "Save", JOptionPane.YES_NO_OPTION);
                    if (save == 0) {
                        saveFile();
                    }
                }
                model.setInitialValues();
            }
        });
        file.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.addMouseListener(new MouseAdapter() {           
            public void mouseReleased(MouseEvent e) {
                saveFile();
            }
        });
        file.add(menuItem);

        menuItem = new JMenuItem("Load");
        menuItem.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int returnVal = loadFileChooser.showOpenDialog(Doodle.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        ObjectInputStream obj_in = new ObjectInputStream ( new FileInputStream(loadFileChooser.getSelectedFile()));
                        Object obj = obj_in.readObject();
                        if (obj instanceof Model) {
                            Model loadedModel = (Model) obj;
                            model.loadModel(loadedModel);                                                    
                        }
                        obj_in.close();  
                    } catch (IOException error) {
                        error.printStackTrace();
                    } catch (ClassNotFoundException error) {
                        error.printStackTrace();
                    }                                 
                }
            }
        });
        file.add(menuItem);
        
        file.addSeparator();
        menuItem = new JMenuItem("Exit");
        menuItem.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                System.exit(0);
            }
        });      
        file.add(menuItem);
        
        menuItem = new JMenuItem("Full");
        view.add(menuItem);        
        
        ButtonGroup group = new ButtonGroup(); //not sure if i need it
        submenu = new JMenu("Fit");
        menuItem = new JRadioButtonMenuItem("Original Size");
        menuItem.setSelected(true);
        group.add(menuItem);
        submenu.add(menuItem);
        menuItem = new JRadioButtonMenuItem("Fit for window");
        group.add(menuItem);
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
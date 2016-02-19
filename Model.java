import java.util.Observable;
import java.util.ArrayList;

public class Model extends Observable {
    
    //variables
    private String currentColor;
    private ArrayList<Stroke> strokes;
    
    //constructors 
    public Model() {
        currentColor = "black";
        strokes = new ArrayList<Stroke>();
    }
    
    //methods
    public void addStroke(Stroke s) {
        strokes.add(s);
    }
    
    public ArrayList<Stroke> getStrokes() {
        return strokes;
    }
    
    public void setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
    }
    
    public String getCurrentColor() {
        return currentColor;
    }
}
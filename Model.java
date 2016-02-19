import java.util.Observable;
import java.util.ArrayList;

public class Model extends Observable {
    
    //variables
    String currentColor;
    ArrayList<Stroke> strokes;
    
    //constructors 
    public Model() {
        currentColor = "black";
        strokes = new ArrayList<Stroke>();
        //setChanged();
    }
    
    //methods
    public void addStroke(Stroke s) {
        strokes.add(s);
        setChanged();
        notifyObservers();
    }
    
    public void addStrokeLinePosition(Position p) {
        if (strokes.size() == 0) {
            System.out.println("trying to modify empty set of strokes");
            return;
        }
        strokes.get(strokes.size() - 1).addStrokeLinePosition(p);
        setChanged();
        notifyObservers();    
    }
    
    public ArrayList<Stroke> getStrokes() {
        return strokes;
    }
    
    public int getStrokesSize() {
        return strokes.size();
    }
    
    public void setCurrentColor(String currentColor) {
        System.out.println("Model: set color to " + currentColor);
        this.currentColor = currentColor;
        setChanged();
        notifyObservers();
    }
    
    public String getCurrentColor() {
        return currentColor;
    }
}
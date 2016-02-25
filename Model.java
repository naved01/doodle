import java.util.Observable;
import java.util.ArrayList;
import java.awt.Color;

public class Model extends Observable {
    
    //variables
    Color currentColor;
    int currentThickness;
    ArrayList<Stroke> strokes;
    
    //constructors 
    public Model() {
        currentColor = Color.BLACK;
        currentThickness = 1;
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
    
    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
        setChanged();
        notifyObservers();
    }
    
    public void setCurrentThickness(int thickness) {
        this.currentThickness = thickness;
        setChanged();
        notifyObservers();
    }
    
    public Color getCurrentColor() {
        return currentColor;
    }
    
    public int getCurrentThickness() {
        return currentThickness;
    }
    
}
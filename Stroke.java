import java.util.ArrayList;
import java.awt.Color;
import java.io.Serializable;

public class Stroke implements Serializable {
    
    //variables
    Color color;
    int thickness;
    private static final long serialVersionUID = 3L;
    ArrayList<Position> line;
    
    //constructors
    public Stroke(Color color, int thickness) {
        this.color = color;
        this.thickness = thickness;
        line = new ArrayList<Position>();
    }
    
    //methods
    public void addStrokeLinePosition(Position p) {
        line.add(p);
    }
    
    public ArrayList<Position> getStrokeline() {
        return line;
    }
    
    public Color getColor() {
        return color;
    }
    
    public int getThickness() {
        return thickness;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setThickness(int thickness) {
        this.thickness = thickness;
    } 
}
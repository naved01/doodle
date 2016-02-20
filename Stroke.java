import java.util.ArrayList;
import java.awt.Color;

public class Stroke {
    
    //variables
    Color color;
    ArrayList<Position> line;
    
    //constructors
    public Stroke(Color color) {
        this.color = color;
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
    
    public void setColor(Color color) {
        this.color = color;
    }
}
import java.util.ArrayList;

public class Stroke {
    
    //variables
    private String color;
    ArrayList<Position> line;
    
    //constructors
    public Stroke(String color) {
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
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
}
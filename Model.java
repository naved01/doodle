import java.util.Observable;
import java.util.ArrayList;
import java.awt.Color;
import java.io.Serializable;

public class Model extends Observable implements Serializable {
    
    //variables
    private static final long serialVersionUID = 1L;
    
    Color currentColor;
    int currentThickness;
    int playbackTicks;
    int currentTick;
    boolean isPlaying;
    ArrayList<Stroke> strokes;
    
    //constructors 
    public Model() {
        setInitialValues();
    }
    
    public void loadModel(Model loadedModel) {
        playbackTicks = loadedModel.playbackTicks;
        currentColor = loadedModel.currentColor;
        strokes = loadedModel.strokes;
        currentTick = loadedModel.currentTick;
        currentThickness = loadedModel.currentThickness;  
        isPlaying = false;
        setChanged();
        notifyObservers();             
    }
    
    public void setInitialValues() {
        playbackTicks = 0;
        currentColor = Color.BLACK;
        currentThickness = 1;
        currentTick = 0;
        isPlaying = false;
        strokes = new ArrayList<Stroke>();
        setChanged();
        notifyObservers();
    }
    
    //methods
    public void addStroke(Stroke s) {
        strokes.add(s);
        setChanged();
        notifyObservers();
    }
    
    public boolean isNew() {
        return (strokes.size() == 0);
    }
    
    public void play() {
        isPlaying = true;
    }
    public void stopPlay() {
        isPlaying = false;
    }
    
    public void cutTheTail() {
        strokes = new ArrayList<Stroke>(strokes.subList(0, currentTick));
        playbackTicks = currentTick;
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
    
    public boolean isPlaying() {
        return isPlaying;
    }
    
    public void setCurrentThickness(int thickness) {
        this.currentThickness = thickness;
        setChanged();
        notifyObservers();
    }
    
    public void addPlayBackTick() {
        playbackTicks++;
        setChanged();
        notifyObservers();
    }
    
    public Color getCurrentColor() {
        return currentColor;
    }
    
    public int getCurrentThickness() {
        return currentThickness;
    }
    
    public int getPlayBackTicks() {
        return playbackTicks;
    }
    
    public void setCurrentTick(int currentTick) {
        this.currentTick = currentTick;
        setChanged();
        notifyObservers();
    }
    
    public int getCurrentTick() {
        return currentTick;
    }
    
}
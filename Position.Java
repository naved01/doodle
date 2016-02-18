
public class Position {
      
      //variables
      private int x;
      private int y;
      
      //constructors
      public Position(int x, int y) {
          this.x = x;
          this.y = y;
      }
      
      //methods
      public boolean equals(Object position) {
          if !(position instanceof Position) return False;
          Position newPosition = (Position) position;
          return (newPosition.x == this.x && newPosition.y == this.y)
      }
      
      public int getX() {
          return x;
      }
      
      public int getY() {
          return y;
      }
      
      public void setX(int X) {
          this.X = X;
      }
      
      public void setY(int Y) {
          this.Y = Y;
      }
}
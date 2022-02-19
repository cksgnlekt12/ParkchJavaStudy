package Step3.j_Example.f;

import java.util.Objects;

public class MazePos {
    public Integer x;
    public Integer y;

    public MazePos(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        MazePos mazePos = (MazePos) o;
        if (this.x == mazePos.x && this.y == mazePos.y) return true;
        return Objects.equals(x, mazePos.x) && Objects.equals(y, mazePos.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

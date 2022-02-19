package Step3.j_Example.g;

public class Maze {

    public int[][] myMaze ={
            {0, 1, 1, 1, 0, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 1, 1, 0, 0, 0, 0},
            {0, 1, 1, 0, 1, 1, 1, 0}

    };
    public String toString(){
        String rtn = "";
        for (int i = 0 ; i < myMaze.length; i++){
            for (int j = 0 ; j < myMaze.length ; j++){
                if (myMaze[i][j] == 1){
                    rtn = rtn + "☐\t";
                }else{
                    rtn = rtn + " \t";
                }
            }
            rtn = rtn + "\n";
        }
        return rtn;
    }
}


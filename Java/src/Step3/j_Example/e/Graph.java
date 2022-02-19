package Step3.j_Example.e;

public class Graph {
    int count = 0;
    int[][] node;

    public Graph ( int count ){
        this.count = count;
        node = new int[count][count];
    }
    public void setNode (int from, int to, int value){
        node[from][to] = value;
        node[to][from] = value;
    }
    public int[][] getNode(){
        return node;
    }
    public void getNodeLog(){
        for ( int i = 0 ; i < count ; i++){
            for ( int j = 0 ; j < count ; j++){
                System.out.print(getNode()[i][j] + "\t");
            }
        System.out.println();
        }
    }
}

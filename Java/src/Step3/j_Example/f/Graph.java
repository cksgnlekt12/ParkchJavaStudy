package Step3.j_Example.f;

import java.sql.Array;
import java.util.ArrayList;

public class Graph {
    int count = 0;
    int[] distance, shortDistance;
    int distanceTemp, minShortDistance;
    int[][] node;
    boolean[] visited;
    ArrayList<Integer> array;

    public Graph(int count ){
        this.count = count;
        node = new int[count][count];
        distance = new int[count];
        visited = new boolean[count];
        array = new ArrayList<>();
    }
    public void setNode (int from, int to, int value){
        if (from == to){
            System.out.println("from과 to가 같습니다.");
            return;
        }
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

    public void setDistance (int from, boolean shortAt){
        array.add(0);
        visited[0] = true;
        while (array.size() != 0 ){
            int removeNode = array.remove(0);
            for ( int i = 0 ; i < count ; i++){
                if (visited[i] != true && i != removeNode){
                    array.add(i);
                    visited[i] = true;
                }
            }
        }

        //나중에 다시 고민좀해보자...
        shortDistance = new int[count];
        for (int i = 0 ; i < count ; i++) {
            for (int j = i; j < count; j++) {
                if (node[i][j] > 0) {
                    if (j > from){
                        shortDistance[j - i] = distance[j - 1] + node[i][j];
                        System.out.println(i + "에서 " + j + "까지 " + node[i][j]);
                    }else if ( j <= from){
                        shortDistance[j - i] = node[i][j];
//                        System.out.println(j + "에서 " + i + "까지 -" + node[i][j]);
                    }
                    if ( shortAt ){
                        minShortDistance = 999;
                        for ( int k = 0 ; k < count ; k++){
                            if (minShortDistance > shortDistance[k] && shortDistance[k] > 0){
                                minShortDistance = shortDistance[k];
                            }
                        }
                        distance[j] = minShortDistance;
                    }else{
                        distance[j] = shortDistance[1];
                    }
                }
            }
        }
    }

    public void showDistance(int from, boolean shortAt){
        setDistance(from, shortAt);
        for ( int i = 0 ; i < count ; i++){
            if (from != i ){
                System.out.println(from + "번째 노드에서 " + i + "번째 노드까지의 거리는 " + distance[i] + "입니다.");
            }
        }
    }
}

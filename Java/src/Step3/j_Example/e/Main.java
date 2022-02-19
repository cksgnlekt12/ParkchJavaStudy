package Step3.j_Example.e;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<Integer>();
    static ArrayList<Integer> queue;
    //Queue 는 클래스로 구현하게 되면 필수 메서드가 많아서 우선 ArrayList 로 대체
    static boolean[] visited;
    static Graph graph;
    public static void dfsTraversal() {
        visited = new boolean[graph.count];

        stack.push(0);
        visited[0] = true;

        while(stack.size() != 0) {
            int node = stack.pop();

            System.out.print(node + "\t");

            //오른쪽부터 조회
            for(int j = 0; j<graph.count; j++) {
                if(graph.getNode()[node][j] != 0 && !visited[j] ) {
                    stack.push(j);
                    visited[j] = true;
                }
            }
            //왼쪽부터 조회
//            for(int j = graph.count - 1; j>=0; j--) {
//                if(graph.getNode()[node][j] != 0 && !visited[j] ) {
//                    stack.push(j);
//                    visited[j] = true;
//                }
//            }

        }
    }
    public static void bfsTraversal() {
        queue = new ArrayList<>();
        visited = new boolean[graph.count];

        queue.add(0);
        visited[0] = true;

        while(queue.size() != 0) {
            int node = queue.remove(0);

            System.out.print(node + "\t");

            for(int j = 0; j<graph.count; j++) {
                if(graph.getNode()[node][j] != 0 && !visited[j] ) {
                    queue.add(j);
                    visited[j] = true;
                }
            }

        }
    }
    public static void main (String[] args){
        /**
        04. DFS(Depth - First Search)와 BFS(Breadth - First Search)

         [1] 그래프를 matrix로 표현하기
        **/
        graph = new Graph(8);
        graph.setNode(0,1,1);
        graph.setNode(0,2,1);
        graph.setNode(1,3,1);
        graph.setNode(1,4,1);
        graph.setNode(2,5,1);
        graph.setNode(2,6,1);
        graph.setNode(4,5,1);
        graph.setNode(3,7,1);

        //매트릭스로 표현된 그래프
        graph.getNodeLog();
        /**
         [2] 깊이 우선 탐색(DFS)
        인접한 노드를 우선 탐색 하는 방식
        "스택"을 활용하여 구현할 수 있음
        DFS 탐색 순서 :
        0 - 1 - 3 - 7 - 4 - 5 - 2 - 6 or
        0 - 2 - 6 - 5 - 4 - 1 - 3 - 7
         **/
        System.out.println("-----------------------------------------");
        dfsTraversal();

        /**
         [3] 너비 우선 탐색(BFS)
        한 노들에 모든 인접한 노드를 탐색하는 방식
        큐를 활용하여 구현할 수 있음
        BFS 탐색 순서 : 0 - 1 - 2 - 3 - 4 - 5 - 6 - 7
         **/
        System.out.println();
        System.out.println("-----------------------------------------");
        bfsTraversal();

    }
}

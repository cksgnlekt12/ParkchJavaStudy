package Step3.j_Example.f;

public class Main {
    public static void main (String[] args){
        /**
        문제 풀이
        모든 노드 중 연결된 최단거리를 가진 노드를 찾아서
        노드 v에 인접한 노드 w 에 대해 다음 조건이 성립하면 w 에 대한 최단 거리를 업데이트 한다
                (즉 원래 w로 가던 거리보다 v를 거쳐 가는 거리가 더 가까우면 w로 가는 거리는 v를 거쳐가는 것으로 최단 거리를 수정)
        Yw = Yv + Cvw if Yv + Cvw < Yw
         **/
        /**
         [1] 매트릭스 그래프 생성
         **/
        Graph graph = new Graph(6);
        graph.setNode(0,1,1);
        graph.setNode(0,2,4);
        graph.setNode(1,2,2);
        graph.setNode(2,3,1);
        graph.setNode(3,4,8);
        graph.setNode(3,5,3);
        graph.setNode(4,5,4);
        //매트릭스로 표현된 그래프
        graph.getNodeLog();
        System.out.println("-----------------------------------------");
//        graph.showDistance(0, false);
        System.out.println("-----------------------------------------");
        graph.showDistance(0, true);
    }
}

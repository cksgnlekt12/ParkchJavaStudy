package Step3.j_Example.g;

import Step3.j_Example.f.MazePos;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static String direction;
    public static Maze maze = new Maze();
    public static MazePos curPos = new MazePos(0, 0);
    public static Stack<MazePos> stack = new Stack<>();
    public static ArrayList<MazePos> arrayList = new ArrayList<>();
    public static boolean move(String direction){
        boolean success = false;
//        System.out.println(stack.lastElement().x + "," + stack.lastElement().y + "," + curPos.x + "," + curPos.y);
        switch (direction){
            case "N": //북
                if (curPos.y > 0 && maze.myMaze[curPos.y - 1][curPos.x] == 0 && !stack.lastElement().y.equals(curPos.y - 1)
                        && !arrayList.contains(new MazePos(curPos.x, curPos.y-1))){
                    stack.push(new MazePos(curPos.x, curPos.y));
                    curPos.y--;
                    success = true;
                }
                return success;
            case "E": //동
                if (curPos.x < 7 && maze.myMaze[curPos.y][curPos.x + 1] == 0 && !stack.lastElement().x.equals(curPos.x + 1)
                        && !arrayList.contains(new MazePos(curPos.x+1, curPos.y))){
                    stack.push(new MazePos(curPos.x, curPos.y));
                    curPos.x++;
                    success = true;
                }
                return success;
            case "S": //남
                if (curPos.y < 7 && maze.myMaze[curPos.y + 1][curPos.x] == 0 && !stack.lastElement().y.equals(curPos.y + 1)
                        && !arrayList.contains(new MazePos(curPos.x, curPos.y+1))){
                    stack.push(new MazePos(curPos.x, curPos.y));
                    curPos.y++;
                    success = true;
                }
                return success;
            case "W": //서
                if (curPos.x > 0 && maze.myMaze[curPos.y][curPos.x - 1] == 0 && !stack.lastElement().x.equals(curPos.x - 1)
                        && !arrayList.contains(new MazePos(curPos.x-1, curPos.y))){
                    stack.push(new MazePos(curPos.x, curPos.y));
                    curPos.x--;
                    success = true;
                }
                return success;
            default:
                return success;
        }
    }
    public static String getCurPos(){
        return "현재 위치 : (" + curPos.x + ", " + curPos.y + ")";
    }
    public static String getPosLog(){
        return stack.toString();

    }
    public static void main (String[] args){
        /**
        06. 미로 찾기 문제
        입구에서 출구로 통하는 길을 찾는 미로 찾기 문제
        스택을 활용하여 문제를 해결할 수 있음
        출구 탐색을 위해 BFS나 DFS로 해결할 수 있음
        아래 그림에서 Enter 에서 Exit을 찾아가는 path의 좌표를 출력하세요
        움직 일 수 있는 방향의 예: ( 2,2 ) 위치에서 볼 수 있는 도달 가능 위치는  N(2,1), E(3,2), S(2,3), W(1,2)
        하나의 위치를 방문할때마다 stack에 위치를 저장한다. (push)
                저장된 위치에서 더 이상 갈 곳이 없는 경우 되돌아 간다. ( pop )
                stack에서 꺼낸 위치에서 가지 않은 곳을 찾아 간다.
         **/
        System.out.println(maze); //미로 출력
        System.out.println("-------------------------------");

        //배치
        //이동은 N,E,S,W (북동남서)
        stack.push(new MazePos(curPos.x, curPos.y));
        System.out.println(getCurPos());
        while (curPos.x != 7 || curPos.y != 7){
            while (true){
                if (move("N")) {
                    direction = "N";
                    arrayList.add(new MazePos(curPos.x, curPos.y));
                    break;
                }
                if (move("E")) {
                    direction = "E";
                    arrayList.add(new MazePos(curPos.x, curPos.y));
                    break;
                }
                if (move("S")) {
                    direction = "S";
                    arrayList.add(new MazePos(curPos.x, curPos.y));
                    break;
                }
                if (move("W")) {
                    direction = "W";
                    arrayList.add(new MazePos(curPos.x, curPos.y));
                    break;
                }
                if (arrayList.contains(new MazePos(curPos.x, curPos.y))){
                    switch(direction){
                        case "N":
                            curPos.y++;
                            break;
                        case "E":
                            curPos.x--;
                            break;
                        case "S":
                            curPos.y--;
                            break;
                        case "W":
                            curPos.x++;
                            break;
                    }
                }
                break;
            }
            System.out.println(getCurPos());
        }
        while (stack.size() != 0){
            System.out.println(stack.pop());
        }
    }
}

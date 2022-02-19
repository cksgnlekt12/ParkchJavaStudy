package Step3.j_Example.h;

public class Main {
    //재귀함수
    public static int func1(int no){
        int rtn;

        switch (no){
            case 0:
                rtn = 0;
                break;
            case 1:
                rtn = 1;
                break;
            default:
                rtn = func1(no - 2) + func1(no - 1);
                break;
        }
        return rtn;
    }
    //반복문
    public static int func2(int no){
        int ppre = 0, pre = 1, tempPre;
        int rtn;

        switch (no){
            case 0:
                rtn = 0;
                break;
            case 1:
                rtn = 1;
                break;
            default:
                for (int i = 0; i < no; i++){
                    tempPre = ppre;
                    ppre = pre;
                    pre = pre + tempPre;
                }
                rtn = ppre;
                break;
        }
        return rtn;
    }
    public static void main (String[] args){
        /** [1] 재귀함수로 피보나치 수열 나열하기 **/
        for (int i = 0; i < 10; i++){
            System.out.print("재귀함수] " + i + "번째 : ");
            System.out.println(func1(i));
        }
        System.out.println("-------------------------");
        /** [2] 반복문으로 피보나치 수열 나열하기 **/
        for (int i = 0; i < 10; i++){
            System.out.print("반복문] " + i + "번째 : ");
            System.out.println(func2(i));
        }
    }
}

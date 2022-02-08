package Step3.j_Example.b;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        /** 1. 나열된 수에서 최솟값과 최댓값 구하기
        문제 정의
        여러 개의 수가 배열에 있을 때 그 중 가장 큰 값과 가장 작은 값을 찾는다.
                배열의 몇 번째에 있는지 순서를 찾는다.
                반복문을 한번만 사용하여 문제를 해결한다.
        수의 예 : [10, 55, 23, 2, 79, 101, 16, 82, 30, 45]
        해결하기
        배열에 있는 수 중 맨 처음에 있는 값을 max와 min으로 가정하고, 배열의 마지막 숫자까지 비교하면서 더 큰 수나 더 작은 수가 나올때 max와 min의 값을 바꾸도록 한다.
                그때의 위치를 변수에 저장한다. **/
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(55);
        arrayList.add(23);
        arrayList.add(2);
        arrayList.add(79);
        arrayList.add(101);
        arrayList.add(16);
        arrayList.add(82);
        arrayList.add(30);
        arrayList.add(45);

        System.out.println(arrayList); //현재는 넣은 순서대로 정렬

        /** [1] 배열의 순서 자체를 바꾸는 방식 **/
        Integer tempVal;
        for ( int i = 0 ; i < arrayList.size(); i++){
            for ( int j = i + 1 ; j < arrayList.size() ; j++){
                if ( arrayList.get(i) > arrayList.get(j)){
                    tempVal = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, tempVal);
                }
            }
        }
        System.out.println(arrayList.get(0) + "," + arrayList.get(arrayList.size() - 1)); //정렬 완료 후 출력

        /** [2] 변수에 최소값, 최대값을 저장 후 바꾸는 방식 **/

        ArrayList<Integer> arrayList2 = new ArrayList<>();

        arrayList2.add(10);
        arrayList2.add(55);
        arrayList2.add(23);
        arrayList2.add(2);
        arrayList2.add(79);
        arrayList2.add(101);
        arrayList2.add(16);
        arrayList2.add(82);
        arrayList2.add(30);
        arrayList2.add(45);

        int minVal = 0, maxVal = 0;
        for ( int i = 0 ; i < arrayList2.size(); i++){
            if ( minVal == 0 ) { minVal = arrayList2.get(i); }
            if ( maxVal == 0 ) { maxVal = arrayList2.get(i); }
            if ( minVal > arrayList2.get(i) ){
                minVal = arrayList2.get(i);
            }
            if ( maxVal < arrayList2.get(i) ){
                maxVal = arrayList2.get(i);
            }
        }
        System.out.println(minVal + "," + maxVal);
    }

}

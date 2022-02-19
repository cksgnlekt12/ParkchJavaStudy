package Step3.j_Example.d;

public class Main {
    public static void main (String[] args){
        /**
        03. 정렬 알고리즘
        평균 수행 시간이 O(n^2)인 알고리즘
        버블 정렬(Bubble Sort), 삽입 정렬(Insertion Sort), 선택 정렬(Selection Sort)
        각 요소가 다른 요소와 평균 한번 이상씩 비교를 하여 정렬 됨

         [1] Insertion Sort 구현해보기
        Insertion Sort의 기본 개념은 이미 정렬된 상태의 요소에 새로운 요소를 추가할 때 정렬하여 추가하는 개념이다.(손안의 카드)
        두 번째 요소 부터 이전 요소들과 비교하면서 insert 될 위치를 찾아가며 정렬하는 알고리즘
         **/
        int[] arr = {80, 50, 70, 10, 60, 20, 40, 30 }; //Insertion Sort 용 배열
        //이미 Example.b 에 있으므로 생략
        /****************************************************************************************/

        /**
        평균 수행 시간이 O(logN)인 알고리즘
        퀵 정렬(Quick Sort), 병합 정렬(Merge Sort), 힙 정렬(Heap Sort)
        한번 수행될 때마다 정렬되어야 하는 수의 범위가 1/2로 줄어드는 경우
        퀵 정렬 이외의 다른 알고리즘은 추가적인 메모리가 필요함

         [2] Heap Sort 구현해보기
         **/
        int[] arr2 = {80, 50, 70, 10, 60, 20, 40, 30 }; //Heap Sort 용 배열

    }
}

package Step3.c_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//문자열 수행을 위한 내부 클래스 지정
class CompareString implements BinaryOperator<String> {

    @Override
    public String apply(String s1, String s2) {
        if (s1.getBytes().length >= s2.getBytes().length) return s1;
        else return s2;
    }
    //BinaryOperator 을 사용할 때는 apply 메서드가 무조건 있어야 함.
}



public class Main {
    public static void main (String[] args){
        /** [1] Stream **/
        /*
        자료의 대상과 관계없이 동일한 연산을 수행
        배열, 컬렉션을 대상으로 연산을 수행 함
        일관성 있는 연산으로 자료의 처리를 쉽고 간단하게 함
        자료 처리에 대한 추상화가 구현되었다고 함

        한번 생성하고 사용한 스트림은 재사용 할 수 없음
        자료에 대한 스트림을 생성하여 연산을 수행하면 스트림은 소모됨
        다른 연산을 수행하기 위해서는 스트림을 다시 생성해야 함

        스트림 연산은 기존 자료를 변경하지 않음
        자료에 대한 스트림을 생성하면 스트림이 사용하는 메모리 공간은 별도로 생성되므로 연산이 수행되도 기존 자료에 대한 변경은 발생하지 않음

        스트림 연산은 중간 연산과 최종 연산으로 구분 됨
        스트림에 대해 중간 연산은 여러 개의 연산이 적용될 수 있지만 최종 연산은 마지막에 한 번만 적용됨
        최종연산이 호출되어야 중간 연산에 대한 수행이 이루어 지고 그 결과가 만들어짐
        따라서 중간 연산에 대한 결과를 연산 중에 알수 없음
        이를 '지연 연산'이라 함
        */
        int[] arr = {1,2,3,4,5};
        //배열의 선언
        List<String> sList = new ArrayList<String>();
        //sList 라는 변수는 String 타입을 받는 List 인터페이스를 사용하며, ArrayList 로도 생성할수도 있다. (List 인터페이스를 사용하니까)

        sList.add("Tomas");
        sList.add("Edward");
        sList.add("Jack");

        Stream<String> stream = sList.stream();
        /* 배열의 경우 Arrays.stream(arr) 에서 메서드 체이닝을 사용 */
        /* List 의 경우 자체적으로 Stream 메서드가 있으니까 그대로 쓰면 됨 */
        /** [2] 최종연산 (sum, count, forEach) **/
        int sumVal = Arrays.stream(arr).sum();
        long count = Arrays.stream(arr).count();
        //이 클래스는 배열을 테스트하므로 Arrays 의 stream 을 가져와서 실행함
        //이미 선언된 배열에 대해서

        System.out.println(sumVal);
        System.out.println(count);
        //위와는 다르게 stream 을 생성하여 List 의 Stream 을 저장
        stream.forEach( s -> System.out.print(s + " "));
        //stream 에 대해 한번 사용하면 못씀. 다시 List 에 대해 stream 선언후 사용
        System.out.println();
        //forEach 는 최종연산. 끝날때까지 반복.
        /** for 구문으로 치면 아래와 같음 그냥 외워 **/
        for ( String s : sList ){
            System.out.print(s + " " );
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");

        /** [3] 중간연산 (sorted, map, filter) **/
        //최종연산과는 다르게 중간에서 연산이 끝남. 모든 반환이 Stream 로 반환됨
        sList.stream().sorted().forEach(s->System.out.print(s+ " "));
        System.out.println();
        sList.stream().map(s->s.length()).forEach(n->System.out.println(n));
        //map도 forEach 와 마찬가지로 람다식 문법 구현이 가능하며 위에서는 s 의 길이를 갖는 stream 반환
        //그리고 길이는 int 형이므로 forEach 돌리면서 n 을 출력
        sList.stream().filter(s->s.length() >= 5).forEach(s->System.out.println(s));

        /**
         ArrayList 안에 배열이 있을땐 FlatMap 을 써서 1차원 배열적으로 가져올 수 있음
         */
        List<List<String>> testList = new ArrayList();

        testList.add(Arrays.asList("1","2","3"));
        testList.add(Arrays.asList("a","b","c"));

        System.out.println("testList : " + testList);

        System.out.println(testList.stream().flatMap(l -> l.stream()).collect(Collectors.toList()));

        stream = sList.stream();
        stream.sorted().forEach(s->System.out.print(s+ " "));
        System.out.println();
        System.out.println("----------------------------------------------------------");
        //위처럼 이미 선언된 Stream 에 대해 재선언하면 다시 사용할 수 있다.

        /** List 를 사용한 int 형태는 아래와 같은 Stream 함수를 사용할 수 있다 **/
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int sum2 = list.stream().mapToInt(n->n.intValue()).sum();
        System.out.println("mapToIntSum : " + sum2);

        /** [4] 연산 수행에 대한 구현을 할 수 있는 reduce() 연산 **/
        /* 개발자가 직접 최종연산을 통해 연산 수행을 지정함 */

        System.out.println(Arrays.stream(arr).reduce(10, (a,b)-> a * b ));
        //10 * 1 -> 10 * 2 -> 20 * 3 -> 60 * 4 -> 240 * 5

        String[] greetings = {"안녕하세요~~~", "hello", "Good morning", "반갑습니다^^"};
        //문자열 생성

        System.out.println(Arrays.stream(greetings).reduce("", (s1, s2)->
        {if (s1.getBytes().length >= s2.getBytes().length)
            return s1;
        else return s2;}));
        //이전꺼가 다음꺼보다 길이가 길때만 반환함

        String str = Arrays.stream(greetings).reduce(new CompareString()).get(); //BinaryOperator를 구현한 클래스 이용.. 문자열만 사용 가능
        //이 내부 클래스는 get 을 통해 가져올 수 있다.
        System.out.println(str);


    }
}

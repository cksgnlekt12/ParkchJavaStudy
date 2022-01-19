package Step3.c_Stream.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    /*
    여행사에 패키지 여행 상품이 있습니다. 여행 비용은 15세 이상은 100만원, 그 미만은 50만원 입니다.
    고객 세 명이 패키지 여행을 떠난다고 했을 때 비용 계산과 고객 명단 검색등에 대한 연산을 스트림을 활용하여 구현해 봅니다.
    고객에 대한 클래스를 만들고 ArrayList로 고객을 관리 합니다.

    고객 정보는 다음과 같습니다.

    CustomerLee
    이름 : 이순신
    나이 : 40
    비용 : 100

    CustomerKim
    이름 : 김유신
    나이 : 20
    비용 : 100

    CustomerHong
    이름 : 홍길동
    나이 :13
    비용 : 50
    */
    public static void main (String[] args){
        List<Customer> customerList = new ArrayList<Customer>();

        customerList.add(new Customer("이순신", 40, 100));
        customerList.add(new Customer("김유신", 20, 100));
        customerList.add(new Customer("홍길동", 13, 50));

        System.out.println(customerList); //toString 출력
        System.out.println("-------------------------------------------");
        /*고객 세 명이 패키지 여행을 떠난다고 했을 때 비용 계산과 고객 명단 검색등에 대한 연산을 스트림을 활용하여 구현해 봅니다.*/
        Stream<Customer> stream = customerList.stream();
        stream.map( s -> s.name ).forEach(s -> System.out.print(s + " "));
        System.out.println(); //이름만 출력
        System.out.println(customerList.stream().map(c -> c.cost).reduce( 0, (a,b) -> a + b )); //reduce 를 통한 합계 계산
        System.out.println(customerList.stream().mapToInt(n->n.cost).sum());
    }
}

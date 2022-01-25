package Step2.d_CollectionFramework;

import java.util.Comparator;
import java.util.TreeSet;

//아래 클래스는 Comparator 의 예제를 구현하기 위한 것으로써,
class myCompare implements Comparator<String>{
    public int compare(String s1, String s2){
        return s1.compareTo(s2) * -1;
    }
}

public class Main {
    public static void main (String[] args){
        /** [1] ArrayList .. 이전에도 많이 다루었던 내용임. **/
        MemberArrayList memberArrayList = new MemberArrayList();

        Member memberLee = new Member(1001,"이순신");
        Member memberKim = new Member(1002,"김유신");
        Member memberKang = new Member(1003,"강감찬");
        Member memberHong = new Member(1004,"홍길동");
        Member memberPark = new Member(1004,"박찬휘");
        Member2 memberLee2 = new Member2(1001,"이순신");
        Member2 memberKim2 = new Member2(1002,"김유신");
        Member2 memberKang2 = new Member2(1003,"강감찬");
        Member2 memberHong2 = new Member2(1004,"홍길동");
        Member2 memberPark2 = new Member2(1004,"박찬휘");


        memberArrayList.addMember(memberLee);
        memberArrayList.addMember(memberKim);
        memberArrayList.addMember(memberKang);
        memberArrayList.addMember(memberHong);

        memberArrayList.showAllMember();
        memberArrayList.removeMember(1001);
        memberArrayList.showAllMember();

        /** [2] Iterator (컬렉션 요소를 순회하는 객체) **/
        /* 보통 Set 인터페이스의 경우 ArrayList 에 있는 get 메써드가 없기 때문에 Iterator 를 통해 순회한다 */
        memberArrayList.removeMember(1002);
        memberArrayList.showAllMember();


        /** [3] HashSet (중복 키를 제거하는 데이터 관리) **/
        MemberHashSet memberHashSet = new MemberHashSet();
        //memberHashSet 변수를 MemberHashSet 클래스의 생성자로 생성

        //memberLee, memberKim, memberKang 변수를 Member 클래스의 생성자로 생성
        //생성자 함수를 통해 각각 Member 클래스 내부의 memberId, memberName 값 지정

        memberHashSet.addMember(memberLee);
        memberHashSet.addMember(memberKim);
        memberHashSet.addMember(memberKang);
        memberHashSet.showAllMember();
        //memberHashSet 클래스의 addMember 함수로 MemberLee, memberKim, memberKang 인수 지정

        memberHashSet.addMember(memberHong);
        memberHashSet.addMember(memberPark);
        memberHashSet.showAllMember();
        //memberHong 변수를 Member 클래스의 생성자로 생성
        //memberHashSet 클래스의 addMember 함수로 MemberHong 인수 지정

        /** [4] TreeSet - 정렬을 위해 Comparable 과 Comparator 인터페이스 구현하기 **/
        /* 객체의 정렬에 사용하는 클래스이며, 내부적으로 이진검색트리 활용 */
        MemberTreeSet memberTreeSet = new MemberTreeSet();
        MemberTreeSet2 memberTreeSet2 = new MemberTreeSet2();

        TreeSet<String> set = new TreeSet<>();
        set.add("홍길동");
        set.add("강감찬");
        set.add("이순신");

        System.out.println("1 : " + set);
        //기본적으로 TreeSet 은 Comparable 인터페이스를 Implements 하고 있기 때문에 자동적으로 비교하여 정렬을 해준다
        //즉, String, int 등은 이미 Comparable (오름차순) 이 구현이 되어 있으나, 객체의 경우는 개발자가 직접 Comparable 을 implements 를 통해 구현해주어야 한다.

        memberTreeSet.addMember(memberHong);
        memberTreeSet.addMember(memberLee);
        memberTreeSet.addMember(memberKang);
        memberTreeSet.addMember(memberPark);

        memberTreeSet.showAllMember();

        //memberTreeSet2 은 Comparable 이 아닌 Comparator 로 구현된 TreeSet 으로써 해당 TreeSet 으로 들어가 보면 생성자 부분에서 또 다른 Member 을 생성자로 두었음을 확인할 수 있다.
        memberTreeSet2.addMember(memberHong2);
        memberTreeSet2.addMember(memberLee2);
        memberTreeSet2.addMember(memberKang2);
        memberTreeSet2.addMember(memberPark2);

        memberTreeSet2.showAllMember();
        //Comparator 의 경우 이미 Comparable 이 구현된 객체나 String, int 등에 대해 변경하고 싶을 때 사용..?

        TreeSet<String> set2 = new TreeSet<>(new myCompare());
        //String 만을 받는 TreeSet 클래스를 생성하되 인자는 myCompare 클래스
        set2.add("홍길동");
        set2.add("강감찬");
        set2.add("이순신");
        System.out.println(set2);

        //https://st-lab.tistory.com/243 사이트는 Comparable 과 Comparator 인터페이스에 대한 차이 및 활용을 정리 잘 해놓은듯.. 한번 보도록해야해
        //Comparable 은 lang 패키지에 있어서 별도로 import 할 필요가 없는데, Comparator 은 util 패키지에 있어서 따로 import 해주어야 한다.
        /** 부가설명
         *
         */

        /** [5] 쌍(Pair)으로 자료를 관리하는 Map 인터페이스를 구현한 클래스와 그 활용 **/

    }
}

package Step2.e_Map;

import java.util.HashMap;

public class Main {
    public static void main (String[] args){
        MemberHashMap memberHashMap = new MemberHashMap();

        Member memberLee = new Member(1001,"이순신");
        Member memberKim = new Member(1002,"김유신");
        Member memberKang = new Member(1003,"강감찬");
        Member memberHong = new Member(1004,"홍길동");
        Member memberPark = new Member(1004,"박찬휘");

        memberHashMap.addMember(memberLee);
        memberHashMap.addMember(memberKim);
        memberHashMap.addMember(memberKang);
        memberHashMap.addMember(memberHong);
        memberHashMap.addMember(memberPark);

        memberHashMap.showAllMember();

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

        hashMap.put(1001,"이순신");
        hashMap.put(1002,"김유신");
        hashMap.put(1003,"강감찬");
        hashMap.put(1004,"홍길동");

        System.out.println(hashMap);
    }
}

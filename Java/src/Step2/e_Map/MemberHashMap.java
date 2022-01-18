package Step2.e_Map;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {
    private HashMap<Integer, Member> hashMap;
    //Integer: Key, Member : Collection

    public MemberHashMap() {
        hashMap = new HashMap<>();
    }

    public void addMember(Member member){
        //HashMap의 경우 컬렉션프레임워크와는 다르게 Put, Get 을 사용
        hashMap.put(member.getMemberId(), member);
    }

    public boolean removeMember(int memberId){
        if ( hashMap.containsKey(memberId)){
            hashMap.remove(memberId);
        }
        System.out.println("없는 Key입니다.");
        return false;
    }

    public void showAllMember(){
        //HashMap의 경우 Iterator 을 가져올 수 있는 방법이 없으므로, Key든 Value든 값을 가져와서 iterator 메서드를 호출
        Iterator<Integer> ir = hashMap.keySet().iterator();

        while (ir.hasNext()){
            int key = ir.next();
            Member member = hashMap.get(key);
            System.out.println(member);
        }
    }
}

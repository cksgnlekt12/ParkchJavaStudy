package Step2.d_CollectionFramework;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.TreeSet;

public class MemberTreeSet {
    private TreeSet<Member> treeSet;
    //treeSet 클래스는 Member 변수만을 갖는 클래스로 지정 (제네릭 메서드)
    //해당 내용은 Cmd + 클릭을 통해 메서드 확인

    public MemberTreeSet(){
        treeSet = new TreeSet<Member>();
    }
    //해당 클래스가 생성됨과 동시에 treeSet 클래스도 생성

    public void addMember(Member member){
        if (treeSet.add(member) == true ){
            System.out.println("추가 완료!");
        }else{
            System.out.println("실패..");
        };
    }
    //treeSet 이라는 클래스에 add 메서드를 통해 member 를 넣음.

    public boolean removeMember(int memberId){

        Iterator<Member> ir = treeSet.iterator();
        //Member 변수만을 받는 Iterator 클래스를 ir 라는 변수로 지정
        //이 함수는, treeSet 의 iterator 와 같은 메모리 주소를 참조한다.

        while( ir.hasNext()){
            //ir 의 hasNext 가 TRUE 일 동안 반복
            Member member = ir.next();
            //지역변수 member 는 ir의 다음 값.
            int tempId = member.getMemberId();
            //tempId 지역변수를 우선 member 의 멤버 아이디
            if( tempId == memberId){
                treeSet.remove(member);
                return true;
                //일치하면 삭제하고 true 반환
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다");
        return false;
    }

    public void showAllMember(){
        for(Member member : treeSet){
            System.out.println(member);
        }
        System.out.println();
    }
}

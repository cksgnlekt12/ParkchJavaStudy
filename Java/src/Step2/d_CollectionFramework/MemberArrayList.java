package Step2.d_CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberArrayList {

    private ArrayList<Member> arrayList;

    public MemberArrayList(){
        arrayList = new ArrayList<Member>();
    }
    public MemberArrayList(int size){
        arrayList = new ArrayList<Member>(size);
    }

    public void addMember(Member member){
        arrayList.add(member);
    }

    public boolean removeMember(int memberId){

        for ( int i = 0 ; i < arrayList.size() ; i++){
            Member member = arrayList.get(i);
            //get 메서드는 ArrayList 의 아이템을 가져오는 메서드

            int tempId = member.getMemberId();
            if (tempId == memberId){
                arrayList.remove(i);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }
    public boolean removeMember2(int memberId){
        Iterator<Member> ir = arrayList.iterator();

        while (ir.hasNext()){
            Member member = ir.next();
            if (member.getMemberId() == memberId){
                arrayList.remove(member);
                return true;
            }
        }
        System.out.println("존재하지 않는 회원번호입니다");
        return false;

    }
    public void showAllMember(){
        for ( Member member : arrayList) {
            System.out.println(member);
        }
        System.out.println();
    }
}

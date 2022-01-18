package Step2.d_CollectionFramework;

import java.util.Comparator;

public class Member2 implements Comparator<Member2> {
    //TreeSet 에 사용될 Member 에 대한 Comparator 을 구현하기 위해 Generic 프로그래밍을 구현

    private int memberId;        //회원 아이디
    private String memberName;   //회원 이름

    public Member2 (){

    }
    public Member2(int memberId, String memberName){ //생성자
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public int getMemberId() {  //
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString(){   //toString 메소드 오버로딩
        return memberName + " 회원님의 아이디는 " + memberId + "입니다";
    }

    @Override
    public int hashCode() {
        return memberId;
    }

    //Set 인터페이스에서 비교할 대상
    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Member2){
            Member2 member = (Member2)obj;
            if( this.memberId == member.memberId )
                return true;
            else
                return false;
        }
        return false;
    }
    @Override
    public int compare(Member2 member1, Member2 member2) {
        //compare는 compareTo 와 다르게 인자가 2개.. 그래서 이 클래스는 최초 생성자로 지정시 인수에 또 다른 생성자 (비교대상) 를 넣어준다.

        return member1.memberId - member2.memberId;
    }
}

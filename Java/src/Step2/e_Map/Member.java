package Step2.e_Map;

public class Member implements Comparable<Member>{
    //TreeSet 에 사용될 Member 에 대한 Comparable 을 구현하기 위해 Generic 프로그래밍을 구현

    private int memberId;        //회원 아이디
    private String memberName;   //회원 이름

    public Member(int memberId, String memberName){ //생성자
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
        if( obj instanceof Member){
            Member member = (Member)obj;
            if( this.memberId == member.memberId )
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public int compareTo(Member member) {
        //Comparable 인터페이스를 implements 하면 반드시 재정의 되어야 할 메써드
        if (this.memberId > member.memberId ){
            return -1;
        }else if (this.memberId < member.memberId) {
            return 1;
        }

        return 0;
        //양수/음수를 Return 함에 따라 오름/내림차순이 가능
    }
}

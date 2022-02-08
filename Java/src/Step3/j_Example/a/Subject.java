package Step3.j_Example.a;

public class Subject {
    /** [5-1] 과목에 대한 정보 (이름, 전공, 학번) 변수 선언 **/
    private String  name;
    private Integer no;
    private Integer  gradeType;

    MyLogger myLogger = MyLogger.getLogger();
    MyLoggerNotSave myLoggerNotSave = MyLoggerNotSave.getLogger();

    /** [5-2] 생성자 그냥 생성될 때는 커스텀 익셉션을 통해 생성을 막음 **/
    public Subject() throws CustomException{
        try{
            /** [5-3] throw 를 할 때 new 구문을 사용해서 커스텀 익셉션 클래스의 명령을 호출한다 **/
            throw new CustomException("정보 생성에 필요한 데이터가 없습니다.");
        }catch (CustomException e){
            /** [5-4] 호출된 명령의 결과로 실행할 catch 구문을 작성한다. 이 때, getMessage() 메서드를 호출하면 String 형태의 에러메세지 호출 **/
            myLoggerNotSave.log("warning",e.getMessage());
        }catch (Exception e){
            /** [5-5] 기타 알 수 없는 에러가 발생할 경우를 대비해 기타 Exception도 작성한다. **/
            myLogger.log("warning","알 수 없는 에러입니다.");
        }
    }
    public Subject (String name, Integer no, Integer gradeType){
        this.name = name;
        this.no = no;
        this.gradeType = gradeType;
    }

    /** [5-6] 중복 제거를 위해 hashCode, equals 메서드를 재정의 한다 **/
    @Override
    public int hashCode(){
        return no ;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Subject){
            Subject subject = (Subject)obj;
            if( this.no == subject.no )
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + "(" + no + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getGradeType() {
        return gradeType;
    }

    public void setGradeType(Integer gradeType) {
        this.gradeType = gradeType;
    }
}

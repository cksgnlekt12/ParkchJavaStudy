package Step3.j_Example.a;

public class Main {
    static boolean showLog = true;
    private static StudentClass studentClass;
    private static SubjectClass subjectClass;
    private static ScoreClass scoreClass;
    private static Score score;
    private static MyLogger myLogger = MyLogger.getLogger();
    private static MyLoggerNotSave myLoggerNotSave = MyLoggerNotSave.getLogger();
    public static void main (String[] args){
        /** 학점 산출 계산기 만들기 **/
        /*
        Good School 학교가 있습니다. 이 학교에는 5명의 학생들이 수업을 듣습니다. 과목은 국어와 수학이 있고, 각 학생은 두 과목을 모두 수강합니다.
        전공은 컴퓨터공학과 국어국문학 두 가지가 있습니다. 컴퓨터공학과 학생은 수학이 필수과목이고, 국어국문학과 학생은 국어가 필수 과목입니다.
        각 학생별로 한 개의 전공을 선택합니다.

        학생별 성적은 아래와 같습니다.
        이름      학번      전공           필수 과목   국어 점수   수학 점수
        강감찬     211213  국어국문학과      국어       95       56
        김유신     212330  컴퓨터공학과      수학       95       98
        신사임당    201518  국어국문학과      국어      100       88
        이순신     202360  국어국문학과      국어       89       95
        홍길동     201290  컴퓨터공학과      수학       83       56

        학점을 부여하는 방벅은 여러 가지가 있습니다. 단순히 A,B,C,D,F를 부여하는 방법, A+, B-처럼 +/-를 사용하는 방법, Pass/Fail 만을 부여하는 방법등이 있습니다.
        여기 각 학생에게 학점을 부여하는 데 사용하는 정책은 두 가지입니다. 일반 과목이라면 A ~ F로, 필수 과목이라면 S ~ F 로 분류합니다. 점수에 따른 학점 부여기준은
        다음과 같습니다


        필수 과목 학점 기준
            S       A        B        C      D         F
        95~100점  90~94점  80~89점  70~79점  60~69점  60점 미만

        일반 과목 학점 기준
            A       B        C        D      F
        90~100점  80~89점  70~79점  55~69점 55점 미만


        만약 똑같이 95점을 받은 경우, 필수 과목이라면 S를 받지만, 일반 과목은 A를 받습니다. 또한 56점을 받으면 필수 과목은 F이지만, 일반 과목은 D를 받습니다.

        이 때 각 과목에 대한 입력값을 받아서 출력하기 원하는 결과를 볼 때의 프로그램을 구현해보세요
        */

        /** [1] 클래스 정의하고 선언하기 **/
        /*
        1. 학생 클래스 (이름, 학번, 전공)
        2. 과목 클래스 (과목코드, 과목명, 평가 기준)
        3. 점수 클래스 (학번, 과목코드, 점수)
        */
        Student studentErrorTest = new Student(); // 생성자 없이 선언할 경우 커스텀 익셉션을 통해 에러 표시

        /** [4] studentClass 라는 이름의 HashSet 클래스를 사용하여 중복 제거를 위해 사용 **/
        studentClass = new StudentClass();

        studentClass.addStudent(new Student("강감찬",211213,"국어국문학과"));
        studentClass.addStudent(new Student("김유신",212330,"컴퓨터공학과"));
        studentClass.addStudent(new Student("신사임당",201518,"국어국문학과"));
        studentClass.addStudent(new Student("이순신",202360,"국어국문학과"));
        studentClass.addStudent(new Student("홍길동",201290,"컴퓨터공학과"));
        studentClass.addStudent(new Student("박찬휘",201290,"전자통신공학과")); //no 변수가 중복되므로 에러 발생.

        /** [5] subjectClass 라는 이름의 HashSet 클래스를 사용하여 중복 제거를 위해 사용 **/
        subjectClass = new SubjectClass();

        subjectClass.addSubject(new Subject("국어",Define.KOREAN,Define.AB_TYPE));
        subjectClass.addSubject(new Subject("수학",Define.MATH,Define.AB_TYPE));


        scoreClass = new ScoreClass();

        setScore(211213,Define.KOREAN,95);
        setScore(211213,Define.MATH,56);
        setScore(212330,Define.KOREAN,95);
        setScore(212330,Define.MATH,98);
        setScore(201518,Define.KOREAN,100);
        setScore(201518,Define.MATH,88);
        setScore(202360,Define.KOREAN,89);
        setScore(202360,Define.MATH,95);
        setScore(201290,Define.KOREAN,83);
        setScore(201290,Define.MATH,56);

        myLoggerNotSave.log(GenerateReport.getReport(studentClass, subjectClass, scoreClass));
    }
    /** [6] 학생/과목 점수를 선언하는 함수 작성. 코드가 없을 경우도 있으므로 예외 처리 **/
    public static void setScore(Integer studentNo, Integer subjectNo, Integer point){
        Student tempStudent;
        Subject tempSubject;

        /** [7] 학생/과목 정보를 가져오는 함수 만들어서 호출 (코드가 없을 경우도 있으므로 예외 처리) **/
        try {
            tempStudent = studentClass.getStudent(studentNo);
            if (tempStudent == null){
                throw new NullPointerException();
            }
        } catch (NullPointerException e){
            myLoggerNotSave.log("존재하지 않는 학생입니다.");
            return;
        }
        try {
            tempSubject = subjectClass.getSubject(subjectNo);
            if (tempSubject == null){
                throw new NullPointerException();
            }
        } catch (NullPointerException e){
            myLoggerNotSave.log("존재하지 않는 과목입니다.");
            return;
        }

        score =  new Score (
                tempStudent,
                tempSubject,
                point);

//        myLoggerNotSave.log(score.toString());
        scoreClass.addScore(score);
    }
}

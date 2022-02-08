package Step3.j_Example.a;

import java.io.IOException;
import java.util.ArrayList;

/** [9] 현재 메모리에 있는 학생/과목/점수 데이터 기반으로 리포트를 출력하는 클래스 **/
public class GenerateReport {
    public static int subjectNo;
    public static final String TITLE = "학생별 학점\n";
    public static final String HEAD = "수강생\t\t\t전공\t\t\t점수\t\t학점\n";
    public static final String LINE = "----------------------------------------\n";
    /** [9-1] StringBuffer 클래스를 통해 레포트를 만들 예정 **/
    private static StringBuffer buffer = new StringBuffer();

    public static String getReport (StudentClass studentClass, SubjectClass subjectClass, ScoreClass scoreClass){
        ArrayList<Student> studentArrayList = new ArrayList<>();
        int i, tempScore;

        studentArrayList = studentClass.returnArrayList();
        System.out.print("과목을 입력하세요 (국어 : 1 / 수학 : 2): ");
        try {
            i = System.in.read();
        } catch (IOException e) {
            return e.getMessage();
        }

        switch ((char)i) {
            case '1' :
                subjectNo = 1;
                break;
            case '2' :
                subjectNo = 2;
                break;
            default :
                return "존재하지 않는 과목입니다.";
        }
        getHeader(subjectClass.getSubject(subjectNo));

        for (Student student : studentArrayList){
            tempScore = scoreClass.getScore(student, subjectClass.getSubject(subjectNo));
            buffer.append(student.toString() + "\t" +
                    student.getMajor() + "\t" +
                    tempScore + "\t\t" +
                    getGrade (student, subjectClass.getSubject(subjectNo), tempScore) +
                    "\n");
        }
        buffer.append(LINE);
        return buffer.toString();
    }

    public static void getHeader (Subject subject) {
        /** [9-2] Buffer 의 경우 append 메서드를 통해 문자열을 추가할 수 있다 **/
        buffer.append("\n" + LINE);
        buffer.append("           " + subject.toString() + " " + TITLE);
        buffer.append(LINE);
        buffer.append(HEAD);
        buffer.append(LINE);
    }
    public static String getGrade(Student student, Subject subject, int score){
        int type;
        switch (student.getMajor()){
            case "국어국문학과":
                if ( subject.getNo() == 1 ){
                    type = Define.SAB_TYPE;
                }else{
                    type = Define.AB_TYPE;
                }
                break;
            case "컴퓨터공학과":
                if ( subject.getNo() == 2 ){
                    type = Define.SAB_TYPE;
                }else{
                    type = Define.AB_TYPE;
                }
                break;
            default:
                return null;
        }
        switch (type){
            case 0:
                return new GetGradeA().getGrade(score);
            case 1:
                return new GetGradeB().getGrade(score);
            case 2:
//                return new GetGradeC().getGrade(score);
            default:
                return null;
        }
    }
}

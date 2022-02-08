package Step3.j_Example.a;

public class Score {
    Student student; //학번
    Subject subject; //과목
    Integer point;   //점수

    public Score () {

    }
    public Score( Student student, Subject subject, Integer point){
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String toString(){
        return student + " 의 " + subject + " 점수는 " + point + "점입니다";
    }


}

package Step3.e_Logger;

public class Student {

    private String studentName;
    MyLogger myLogger = MyLogger.getLogger();

    public Student(String studentName){

        if(studentName == null){

            throw new StudentNameException("name must not be null");
        }
        if( studentName.split(" ").length > 3)
            throw new StudentNameException("이름이 너무 길어요");

        this.studentName = studentName;
    }


    public String getStudentName() {

        myLogger.fine("begin getStudentName()");

        return studentName;
    }
}

package Step3.j_Example.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class StudentClass {
    HashSet<Student> studentClass;
    MyLoggerNotSave myLoggerNotSave = MyLoggerNotSave.getLogger();

    public StudentClass (){
        studentClass = new HashSet<>();
    }

    public void addStudent(Student student){
        if (studentClass.add(student)){
            myLoggerNotSave.log( student + " 추가 완료!");
        }else{
            myLoggerNotSave.log(student + " 실패..");
        };
    }

    public Student getStudent(Integer no){
        Iterator<Student> ir = studentClass.iterator();
        while (ir.hasNext()){
            Student temp = ir.next();
            if (temp.getNo().equals(no)) {
                return temp;
            }
        }
        return null;
    }

    public ArrayList<Student> returnArrayList (){
        ArrayList<Student> tempArrayList = new ArrayList<>();
        Iterator<Student> ir = studentClass.iterator();
        while (ir.hasNext()){
            tempArrayList.add(ir.next());

        }
        return tempArrayList;
    }

}

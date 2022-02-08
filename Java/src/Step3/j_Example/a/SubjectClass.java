package Step3.j_Example.a;

import java.util.HashSet;
import java.util.Iterator;

public class SubjectClass {
    HashSet<Subject> subjectClass;
    MyLoggerNotSave myLoggerNotSave = MyLoggerNotSave.getLogger();

    public SubjectClass (){
        subjectClass = new HashSet<>();
    }

    public void addSubject(Subject subject){
        if (subjectClass.add(subject)){
            myLoggerNotSave.log( subject + " 추가 완료!");
        }else{
            myLoggerNotSave.log(subject + " 실패..");
        };
    }

    public Subject getSubject(Integer no){
        Iterator<Subject> ir = subjectClass.iterator();
        while (ir.hasNext()){
            Subject temp = ir.next();
            if (temp.getNo().equals(no)) {
                return temp;
            }
        }
        return null;
    }
}

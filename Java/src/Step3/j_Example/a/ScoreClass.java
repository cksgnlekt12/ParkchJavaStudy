package Step3.j_Example.a;

import java.util.HashSet;
import java.util.Iterator;

public class ScoreClass {
    HashSet<Score> scoreClass;
    MyLoggerNotSave myLoggerNotSave = MyLoggerNotSave.getLogger();

    public ScoreClass(){
        scoreClass = new HashSet<>();
    }

    public void addScore(Score score){
        if (scoreClass.add(score)){
//            myLoggerNotSave.log( score + " 추가 완료!");
        }else{
//            myLoggerNotSave.log(score + " 실패..");
        };
    }

    public int getScore(Student student, Subject subject){
        Iterator<Score> ir = scoreClass.iterator();
        while (ir.hasNext()){
            Score temp = ir.next();
            if ((temp.getStudent().getNo() + temp.getSubject().getNo()) == (student.getNo() + subject.getNo())) {
                return temp.getPoint();
            }
        }
        return 0;
    }
}

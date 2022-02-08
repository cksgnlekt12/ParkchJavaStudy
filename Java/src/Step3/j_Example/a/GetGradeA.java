package Step3.j_Example.a;

public class GetGradeA implements GetGrade{
    @Override
    public String getGrade(Integer score) {
        String grade;

        if(score >=90 && score <=100)
            grade = "A";
        else if(score >=80 && score <=89)
            grade = "B";
        else if(score >=70 && score <=79)
            grade = "C";
        else if(score >=55 && score <=69)
            grade = "D";
        else
            grade = "F";
        return grade;

    }
}

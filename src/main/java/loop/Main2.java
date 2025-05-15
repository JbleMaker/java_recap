package loop;

import java.util.List;

class Student {
    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore(){
        return score;
    }
}

public class Main2 {
    public static void main(String[] args) {
        // 학생 리스트에서 점수가 85점 이상이 학생들의 이름을 모두 출력
        List<Student> students = List.of(
                new Student("일", 80),
                new Student("이", 94),
                new Student("삼", 75),
                new Student("사", 99),
                new Student("오", 85)
        );

        for(Student student : students){
            if(student.getScore() > 84){
                System.out.println(student.getName());
            }
        }

    }
}

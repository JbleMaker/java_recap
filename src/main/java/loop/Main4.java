package loop;

import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        // 학생들 중 점수가 가장 높은 학생의 이름을 출력.
        List<Student> students = List.of(
                new Student("일", 94),
                new Student("이", 80),
                new Student("삼", 99),
                new Student("사", 75),
                new Student("오", 85)
        );
        Student max = null;

        for(Student s : students){
            if(max == null){
                max = s;
            } else if(max.getScore() < s.getScore()) {
                max = s;
            }
        }
        System.out.println(max.getName());
    }
}

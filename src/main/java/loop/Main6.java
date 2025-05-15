package loop;

import java.util.List;

public class Main6 {
    public static void main(String[] args) {
        // 학생들 전체 평균 점수를 출력
        List<Student> students = List.of(
                new Student("일", 80),
                new Student("이", 94),
                new Student("삼", 75),
                new Student("사", 99),
                new Student("오", 85)
        );
        int avg = 0;
        int total = 0;

        for(Student s : students){
            total += s.getScore();
        }
        avg = total/students.size();
        System.out.println(avg);
    }
}

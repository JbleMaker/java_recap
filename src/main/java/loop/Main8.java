package loop;

import java.util.ArrayList;
import java.util.List;

public class Main8 {
    public static void main(String[] args) {
        // newWords에 1. bread, 2. milk, 3. egg 처럼 앞에 숫자를 붙여서 옮기시오.
        List<String> words = List.of("bread", "milk", "egg");
        List<String> newWords = new ArrayList<>();
        int i = 1;
        for (String word : words){
            StringBuilder builder = new StringBuilder(word);
            builder.insert(0, (i +". "));
            newWords.add(String.valueOf(builder));
            i++;
        }
        System.out.println(newWords);



        // ints 리스트에 Integer 자료형으로 옮기시오.
        List<Double> doubles = List.of(1.12, 2.23, 3.34, 4.45);
        List<Integer> ints = new ArrayList<>();

        for (Double dou : doubles){
            ints.add((int)Math.round(dou));
//            Math.ceil();      up
//            Math.floor();     down
        }

        System.out.println(ints);
    }
}

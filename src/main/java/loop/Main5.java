package loop;

import java.util.ArrayList;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {
        // 단어의 시작이 A 또는 a로 시작하는 단어를 newWords리스트에 담아 출력
        List<String> words = List.of("Apple", "banana", "avocado", "carrot");
        List<String> newWords = new ArrayList<>();

        for(String word : words){
            if(word.startsWith("A") || word.startsWith("a")){
                newWords.add(word);
            }
        }
        System.out.println(newWords);
    }
}

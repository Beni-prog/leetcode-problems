package tries;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {

    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder buildString = new StringBuilder();

        for (String word : words) {
            for (String root : dictionary) {
                if (word.startsWith(root)) {
                    word = root;
                }
            }
            buildString.append(word).append(" ");
        }

        buildString.replace(buildString.length() - 1, buildString.length(), "");

        return buildString.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(replaceWords(Arrays.asList("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
    }
}

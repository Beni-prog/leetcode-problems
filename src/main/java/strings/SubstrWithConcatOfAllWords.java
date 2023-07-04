package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The idea is to take a substring of words.length size and check if it is a word from words array. If so,
 * count it and finally check if counter equals to the words.length. That means we found a permutation in the string s.
 */
public class SubstrWithConcatOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return indices;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int permutationLength = wordLength * totalWords;

        //make sure that the frequency of each word in the substring matches
        //the frequency of the word in the words array
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        //i represents the starting index of the substring in s
        //j represents the index of the word within the words array
        // ensure that there are enough characters in the remaining portion of s
        // to form a substring of length permutationLength (i <= s.length() - permutationLength)
        for (int i = 0; i <= s.length() - permutationLength; i++) {
            Map<String, Integer> currentCount = new HashMap<>();
            int j = 0;

            while (j < totalWords) {
                //extract each word from the s string that corresponds to the words in the words array
                String currentWord = s.substring(i + j * wordLength, i + (j + 1) * wordLength);

                //check if currentWord is actually a word from words array
                if (!wordCount.containsKey(currentWord)) {
                    break;
                }

                currentCount.put(currentWord, currentCount.getOrDefault(currentWord, 0) + 1);

                //if currentWord appears more times in s than in the words array,
                //then currentWord is not a valid permutation
                if (currentCount.get(currentWord) > wordCount.getOrDefault(currentWord, 0)) {
                    break;
                }

                j++;
            }

            if (j == totalWords) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));//[0, 9]
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));//[]
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));//[6, 9, 12]
    }
}

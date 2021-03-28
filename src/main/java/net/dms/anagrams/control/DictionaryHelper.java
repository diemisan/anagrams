package net.dms.anagrams.control;

import java.util.Arrays;

public class DictionaryHelper {
    /**
     * Sort the word alphabetically and convert it to lowercase
     * @param word
     * @return
     */
    public String toKeyWord(String word) {
        if (word == null) {
            return null;
        }
        char wordArray[] = word.toLowerCase().toCharArray();
        Arrays.sort(wordArray);
        return new String(wordArray);
    }
}

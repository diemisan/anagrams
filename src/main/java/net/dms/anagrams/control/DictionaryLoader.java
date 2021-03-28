package net.dms.anagrams.control;

import net.dms.anagrams.exceptions.LoadingDictionaryException;
import net.dms.anagrams.i18n.I18n;
import net.dms.anagrams.i18n.I18nKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DictionaryLoader {
    public DictionaryHelper dictionaryHelper = new DictionaryHelper();

    public Map<String, Set<String>> load(String fileName) {
        final Map<String, Set<String>> words = new HashMap<>();
        try {
            Set<String> wordAnagrams;
            InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new LoadingDictionaryException(I18n.getTranslation(I18nKey.ERROR_FILE_NOT_FOUND, fileName));
            }
            try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(is))) {
                String word;
                String sortedWord;
                while ((word = br.readLine()) != null) {
                    sortedWord = dictionaryHelper.toKeyWord(word);
                    wordAnagrams = words.get(sortedWord);
                    if (wordAnagrams == null) {
                        words.put(sortedWord, new HashSet<String>(Arrays.asList(word)));
                    } else {
                        wordAnagrams.add(word);
                    }
                }
            }
            return words;
        } catch (IOException ex) {
            throw new LoadingDictionaryException(ex.getMessage());
        }
    }
}

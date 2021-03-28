package net.dms.anagrams.business;

import net.dms.anagrams.control.DictionaryHelper;
import net.dms.anagrams.control.DictionaryLoader;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    private Map<String, Set<String>> words;

    /**
     * DictionaryLoader and DictionaryHelper could be candidates to be transformed in static method container classes,
     * however this is not a good practice since static methods cannot be tested in a proper way, for instance, it´s not easy
     * to verify if a static method was invoked.
     * The better solution would be to use some DI approach such as CDI or Spring, though in this small application
     * it would overkill.
     */
    private DictionaryLoader dictionaryLoader = new DictionaryLoader();
    private DictionaryHelper dictionaryHelper = new DictionaryHelper();

    public Dictionary(String fileName) {
        words = dictionaryLoader.load(fileName);
    }


    public Set<String> lookUpAnagram(String word) {
        Set<String> result = words.get(dictionaryHelper.toKeyWord(word));
        return result != null ? result : Collections.<String>emptySet();
    }
}

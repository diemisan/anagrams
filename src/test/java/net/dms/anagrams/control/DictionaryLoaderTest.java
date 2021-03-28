package net.dms.anagrams.control;

import net.dms.anagrams.exceptions.LoadingDictionaryException;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DictionaryLoaderTest {

    private DictionaryLoader underTest;

    @Before
    public void setUp() {
        underTest = new DictionaryLoader();
    }

    @Test(expected = LoadingDictionaryException.class)
    public void load_unknownDictionary_throwsException() {
        // given
        final String dictionaryFileName = "unknowndictionary.txt";

        // when
        underTest.load(dictionaryFileName);

        // then
        // throws exception
    }

    @Test
    public void load_dictionary_success() {
        // given
        final String dictionaryFileName = "wordlist01.txt";

        // when
        Map<String, Set<String>> dictionary = underTest.load(dictionaryFileName);

        // then
        assertThat(dictionary.size(), is(4));
        assertThat(dictionary.get("abepru"), containsInAnyOrder("uebapr", "prueba", "abruep"));
        assertThat(dictionary.get("eeoppy"), containsInAnyOrder("eyepop", "Popeye", "popeye"));
        assertThat(dictionary.get("abcdtu"), containsInAnyOrder("atbcdu"));
        assertThat(dictionary.get("aaaaab"), containsInAnyOrder("aabaaA", "aaaaBA", "abaaaa", "aaABaA"));

    }

}

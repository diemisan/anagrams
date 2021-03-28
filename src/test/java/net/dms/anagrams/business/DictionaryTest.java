package net.dms.anagrams.business;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


public class DictionaryTest {

    private Dictionary underTest;

    @Before
    public void setUp(){
        underTest = new Dictionary("wordlist01.txt");
    }

    @Test
    public void lookUpAnagram_existingAnagrams_returnFindings() {
        // given

        // when
        Set<String> results = underTest.lookUpAnagram("popeye");

        // then
        assertThat(results, containsInAnyOrder("popeye", "Popeye", "eyepop"));
    }

    @Test
    public void lookUpAnagram_nonExistingAnagrams_returnEmpty() {
        // given

        // when
        Set<String> results = underTest.lookUpAnagram("no matching anagrams");

        // then
        assertThat(results.isEmpty(), is(true));
    }

}

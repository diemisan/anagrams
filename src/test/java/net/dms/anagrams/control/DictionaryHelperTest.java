package net.dms.anagrams.control;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DictionaryHelperTest {

    public DictionaryHelper underTest;

    @Before
    public void setUp() {
        underTest = new DictionaryHelper();
    }

    @Test
    public void toKeyWord_unsortedWord_sorted() {
        // given
        String word = "zyxzAv";

        // when
        String result = underTest.toKeyWord(word);

        // then
        assertThat(result, is("avxyzz"));
    }

    @Test
    public void toKeyWord_null_returnNull() {
        // given
        String word = null;

        // when
        String result = underTest.toKeyWord(word);

        // then
        assertThat(result, nullValue());
    }

}

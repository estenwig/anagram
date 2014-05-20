package esben.anagram;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class AnagramContainerTest {

    public static final String[] ALL_WORDS = new String[]{"alle", "ella", "elal", "ell"};
    public static final String[] KEYS = new String[]{"aell", "ell"};
    private AnagramContainer anagramContainer = new AnagramContainer();

    @Before
    public void setUp() throws Exception {
        anagramContainer.addWords(ALL_WORDS);
    }

    @Test
    public void shouldGetAllKeys() throws Exception {
        assertThat(anagramContainer.getKeys(), contains(KEYS));
    }

    @Test
    public void shouldReturnAllWords() throws Exception {
        List<String> words = anagramContainer.getAllWords();
        Arrays.sort(ALL_WORDS);
        assertThat(words, contains(ALL_WORDS));

    }
}
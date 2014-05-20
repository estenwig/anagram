package esben.anagram;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldReadFileWithSimpleAnagrams() throws Exception {
        App app = new App(new File("target/test-classes/anagrams_short.txt"));
        app.printAnagrams();

        assertThat(outContent.toString(), is("anne naen nane\r\nalle lale\r\n"));
    }
}
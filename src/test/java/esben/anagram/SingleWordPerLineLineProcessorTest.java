package esben.anagram;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SingleWordPerLineLineProcessorTest {
    private SingleWordPerLineLineProcessor processor = new SingleWordPerLineLineProcessor();

    @Test
    public void shouldProssessLines() throws Exception {
        processLines("", " a", "a b", "a");
        assertThat(processor.getResult(), arrayContaining("a", "a"));

    }

    private void processLines(String... strings) throws IOException {
        for (String s : strings) {
            processor.processLine(s);
        }
    }
}
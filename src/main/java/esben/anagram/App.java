package esben.anagram;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;

import static com.google.common.base.Joiner.on;
import static com.google.common.io.Files.readLines;

public class App {
    public static final String STRING_SPACE = " ";
    public static final int MINIMUM_SIZE_OF_ANAGRAMS_TO_PRINT = 2;
    private AnagramContainer anagramContainer = new AnagramContainer();

    public App(File file) {
        loadFile(file);
    }

    private void loadFile(File file) {
        try {
            anagramContainer.addWords(readFirstWordOfEachLine(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String[] readFirstWordOfEachLine(File file) throws IOException {
        return readLines(file, Charset.forName("UTF-8"), new SingleWordPerLineLineProcessor());
    }

    public void printAnagrams() {
        Collection<List<String>> allAnagrams = anagramContainer.getAllAnagrams();
        for (List<String> anagrams : allAnagrams) {
            if (anagrams.size() >= MINIMUM_SIZE_OF_ANAGRAMS_TO_PRINT) {
                System.out.println(on(STRING_SPACE).join(anagrams));
            }
        }
    }

    public static void main(String[] args) {
        App app = new App(new File("target/classes/ordbok.txt"));
        app.printAnagrams();
    }
}

package esben.anagram;

import com.google.common.io.LineProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.google.common.base.Predicates.equalTo;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Collections2.filter;

class SingleWordPerLineLineProcessor implements LineProcessor<String[]> {
    private List<String> strings = new ArrayList<String>();

    @Override
    public boolean processLine(String line) throws IOException {
        strings.add(getFirstWord(line));
        return true;
    }

    private String getFirstWord(String string) {
        return string.split(App.STRING_SPACE)[0];
    }

    @Override
    public String[] getResult() {
        Collection<String> nonEmptyStrings = filter(strings, not(equalTo("")));
        return nonEmptyStrings.toArray(new String[nonEmptyStrings.size()]);
    }
}

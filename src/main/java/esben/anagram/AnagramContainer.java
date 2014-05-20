package esben.anagram;

import java.util.*;

import static java.util.Collections.sort;

public class AnagramContainer {
    private Map<String, List<String>> anagramHolder = new LinkedHashMap<String, List<String>>();

    public void addWords(String... words) {
        for (String word : words) {
            addWord(word);
        }
    }

    public Set<String> getKeys() {
        return anagramHolder.keySet();
    }

    private void addWord(String word) {
        String key = asKey(word);
        if (!anagramHolder.containsKey(key)) {
            anagramHolder.put(key, new ArrayList<String>());
        }
        anagramHolder.get(key).add(word);
    }

    private String asKey(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    public List<String> getAllWords() {
        ArrayList<String> resultList = new ArrayList<String>();
        for (List<String> words : anagramHolder.values()) {
            resultList.addAll(words);
        }
        sort(resultList);
        return resultList;
    }

    public Collection<List<String>> getAllAnagrams() {
        return anagramHolder.values();
    }
}

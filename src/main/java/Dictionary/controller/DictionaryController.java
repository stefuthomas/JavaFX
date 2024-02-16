package Dictionary.controller;

import Dictionary.view.DictionaryGUI;
import Dictionary.model.Dictionary;

public class DictionaryController {
    private DictionaryGUI gui;
    private Dictionary dictionary = new Dictionary();

    public DictionaryController(DictionaryGUI gui) {
        this.gui = gui;
    }

    public void addWord() {
        String word = gui.setWord();
        String meaning = gui.setMeaning();
        dictionary.addWord(word, meaning);
    }

    public void searchWord() {
        String word = gui.getWord();
        String meaning = dictionary.getMeaning(word);
        gui.setResult(meaning);
    }

    public static void main(String[] args) {
        DictionaryGUI.launch(DictionaryGUI.class, args);
    }
}

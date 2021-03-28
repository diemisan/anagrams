package net.dms.anagrams.ui;


import net.dms.anagrams.business.Dictionary;
import net.dms.anagrams.i18n.I18nKey;

import java.util.Scanner;
import java.util.Set;

public class AnagramController extends UiController {
    private Dictionary dictionary;

    public void start(String dictionaryName) {
        print(I18nKey.UI_WAIT_FOR_INITIALIZATION);
        dictionary = new Dictionary(dictionaryName);
        print(I18nKey.UI_REQUEST_WORD);
        Scanner in = new Scanner(System.in);
        String word;
        Set<String> result;
        while ((word = in.nextLine()) != null) {
            if (!checkExitCommand(word, in)) {
                result = dictionary.lookUpAnagram(word);
                printResult(result);
            }
            print(I18nKey.UI_REQUEST_WORD);
        }
    }

    private void printResult(Set<String> results) {
        if (results.isEmpty()) {
            print(I18nKey.UI_NOT_FOUND);
        } else {
            print(I18nKey.UI_NUM_RESULTS, results.size());
            print(results.toString());
        }
    }

    private boolean checkExitCommand(String word, Scanner in) {
        if (word.equals("")) {
            print(I18nKey.UI_CONFIRM_QUIT);
            if ("S".equals(in.nextLine().toUpperCase())) {
                System.exit(0);
            }
            return true;
        }else {
            return false;
        }
    }
}


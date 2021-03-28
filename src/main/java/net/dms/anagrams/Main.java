package net.dms.anagrams;

import net.dms.anagrams.ui.AnagramController;

public class Main {

    public static void main(String[] args) {
        AnagramController controller = new AnagramController();
        controller.start("wordlist.txt");
    }
}

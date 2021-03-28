package net.dms.anagrams.ui;

import net.dms.anagrams.i18n.I18n;
import net.dms.anagrams.i18n.I18nKey;

public abstract class UiController {

    public void print(I18nKey templateKey, Object... args) {
        print(I18n.getTranslation(templateKey, args));
    }

    public void print(String message) {
        System.out.println(message);
    }
}

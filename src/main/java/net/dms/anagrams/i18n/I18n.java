package net.dms.anagrams.i18n;

import org.slf4j.helpers.MessageFormatter;

import java.util.ResourceBundle;

public class I18n {
    private static ResourceBundle I18N = ResourceBundle.getBundle("i18n");


    public static String getTranslation(I18nKey key, Object... args){
        String template = I18N.getString(toPropFormat(key));
        return MessageFormatter.arrayFormat(template, args).getMessage();
    }

    private static String toPropFormat(I18nKey key) {
        return key.name().toLowerCase().replace("_", ".");
    }
}

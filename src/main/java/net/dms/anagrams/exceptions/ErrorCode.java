package net.dms.anagrams.exceptions;

import net.dms.anagrams.i18n.I18nKey;

public enum ErrorCode {
    LOADING_DICTIONARY("0001", I18nKey.ERROR_LOADING_DICTIONARY);

    private String code;
    private I18nKey messageKeyTemplate;


    ErrorCode(String code, I18nKey messageKeyTemplate) {
        this.code = code;
        this.messageKeyTemplate = messageKeyTemplate;
    }

    public String getCode() {
        return code;
    }

    public I18nKey getMessageKeyTemplate() {
        return messageKeyTemplate;
    }
}

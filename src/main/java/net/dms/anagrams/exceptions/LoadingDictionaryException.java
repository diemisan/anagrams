package net.dms.anagrams.exceptions;

public class LoadingDictionaryException extends ApplicationException {

    public LoadingDictionaryException(String errorDetail) {
        super(ErrorCode.LOADING_DICTIONARY, errorDetail);
    }
}

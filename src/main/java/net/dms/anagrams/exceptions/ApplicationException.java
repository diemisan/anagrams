package net.dms.anagrams.exceptions;

import net.dms.anagrams.i18n.I18n;
import org.slf4j.helpers.MessageFormatter;

public class ApplicationException extends RuntimeException {
    private ErrorCode errorCode;

    public ApplicationException(ErrorCode errorCode, Object... args) {
        super(MessageFormatter.arrayFormat(I18n.getTranslation(errorCode.getMessageKeyTemplate()), args).getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

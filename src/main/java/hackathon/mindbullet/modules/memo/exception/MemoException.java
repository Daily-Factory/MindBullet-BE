package hackathon.mindbullet.modules.memo.exception;

import hackathon.mindbullet.golbal.base.BaseException;
import hackathon.mindbullet.golbal.base.BaseExceptionType;

public class MemoException extends BaseException {

    private final MemoExceptionType exceptionType;

    public MemoException(final MemoExceptionType exceptionType) {
        super(exceptionType.errorMessage());
        this.exceptionType = exceptionType;
    }

    public MemoException(final MemoExceptionType exceptionType, final String message) {
        super(message);
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}

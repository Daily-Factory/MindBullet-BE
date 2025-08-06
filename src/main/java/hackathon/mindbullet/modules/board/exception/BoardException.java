package hackathon.mindbullet.modules.board.exception;

import hackathon.mindbullet.golbal.base.BaseException;
import hackathon.mindbullet.golbal.base.BaseExceptionType;

public class BoardException extends BaseException {

    private final BoardExceptionType exceptionType;

    public BoardException(final BoardExceptionType exceptionType) {
        super(exceptionType.errorMessage());
        this.exceptionType = exceptionType;
    }

    public BoardException(final BoardExceptionType exceptionType, final String errorMessage) {
        super(errorMessage);
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}

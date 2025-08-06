package hackathon.mindbullet.modules.memo.exception;

import hackathon.mindbullet.golbal.base.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum MemoExceptionType implements BaseExceptionType {
    NOT_EXISTS_ID(HttpStatus.NOT_FOUND, "존재하지 않는 메모 id입니다.")
    ;

    private final HttpStatus httpStatus;
    private final String message;

    MemoExceptionType(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public HttpStatus httpStatus() {
        return httpStatus;
    }

    @Override
    public String errorMessage() {
        return message;
    }
}

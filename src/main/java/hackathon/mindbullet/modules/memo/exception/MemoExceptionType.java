package hackathon.mindbullet.modules.memo.exception;

import hackathon.mindbullet.golbal.base.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum MemoExceptionType implements BaseExceptionType {
    NOT_EXISTS_ID(HttpStatus.NOT_FOUND, "존재하지 않는 메모 id입니다."),
    NOT_MATCH_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.")
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

package hackathon.mindbullet.modules.board.exception;

import hackathon.mindbullet.golbal.base.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum BoardExceptionType implements BaseExceptionType {
    NOT_EXISTS_BOARD_ID(HttpStatus.NOT_FOUND, "존재하지 않는 게시판 id 입니다"),
    ;

    private final HttpStatus httpStatus;
    private final String errorMessage;

    BoardExceptionType(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public HttpStatus httpStatus() {
        return httpStatus;
    }

    @Override
    public String errorMessage() {
        return errorMessage;
    }
}

package hackathon.mindbullet.modules.memo.domain;

import hackathon.mindbullet.golbal.base.BaseEntity;
import hackathon.mindbullet.modules.board.domain.Board;
import hackathon.mindbullet.modules.memo.dto.MemoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "제목을 비울 수 없습니다.")
    private String title;

    @NotEmpty(message = "타입을 비울 수 없습니다.")
    @Enumerated(EnumType.STRING)
    private MemoType type;

    @NotEmpty(message = "내용을 비울 수 없습니다.")
    private String content;

    @NotEmpty(message = "비밀번호를 비울 수 없습니다.")
    private String password;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Memo(String title, MemoType type, String content, String password, Board board) {
        this.title = title;
        this.type = type;
        this.content = content;
        this.password = password;
        this.board = board;
    }

    public void updateAllInfo(MemoRequest memoRequest) {
        this.title = memoRequest.title();
        this.content = memoRequest.content();
        this.password = memoRequest.password();
        this.type = memoRequest.type();
    }

    public void updateBoard(Board board) {
        this.board = board;
    }
}

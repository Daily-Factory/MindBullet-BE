package hackathon.mindbullet.modules.memo.service;

import static hackathon.mindbullet.modules.board.exception.BoardExceptionType.NOT_EXISTS_BOARD_ID;
import static hackathon.mindbullet.modules.memo.exception.MemoExceptionType.NOT_EXISTS_ID;

import hackathon.mindbullet.modules.board.dao.BoardRepository;
import hackathon.mindbullet.modules.board.domain.Board;
import hackathon.mindbullet.modules.board.dto.MemoResponse;
import hackathon.mindbullet.modules.board.exception.BoardException;
import hackathon.mindbullet.modules.memo.dao.MemoRepository;
import hackathon.mindbullet.modules.memo.domain.Memo;
import hackathon.mindbullet.modules.memo.dto.MemoRequest;
import hackathon.mindbullet.modules.memo.exception.MemoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemoService {

    private final MemoRepository memoRepository;
    private final BoardRepository boardRepository;

    public MemoResponse getMemo(Long memoId) {
        Memo findMemo = memoRepository.findById(memoId)
                .orElseThrow(() -> new MemoException(NOT_EXISTS_ID));
        return MemoResponse.builder()
                .title(findMemo.getTitle())
                .type(findMemo.getType())
                .content(findMemo.getContent())
                .build();
    }

    public void createMemo(MemoRequest memoRequest) {
        Board findBoard = boardRepository.findById(memoRequest.boardId())
                .orElseThrow(() -> new BoardException(NOT_EXISTS_BOARD_ID));
        findBoard.addMemo(Memo.builder()
                .title(memoRequest.title())
                .type(memoRequest.type())
                .content(memoRequest.content())
                .password(memoRequest.password())
                .build());
    }
}

package hackathon.mindbullet.modules.board.service;

import static hackathon.mindbullet.modules.board.exception.BoardExceptionType.*;

import hackathon.mindbullet.modules.board.dao.BoardRepository;
import hackathon.mindbullet.modules.board.domain.Board;
import hackathon.mindbullet.modules.board.dto.BoardResponse;
import hackathon.mindbullet.modules.board.dto.MemoTitleResponse;
import hackathon.mindbullet.modules.board.exception.BoardException;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public List<MemoTitleResponse> getTitles(Long boardId) {
        Board findBoard = boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardException(NOT_EXISTS_BOARD_ID));

        return findBoard.getMemos().stream()
                .map(memo -> MemoTitleResponse.builder()
                        .id(memo.getId())
                        .title(memo.getTitle())
                        .type(memo.getType())
                        .build())
                .toList();
    }

    public BoardResponse getBoardInfo(String year, String month, String day) {
        LocalDate date = parseToLocalDate(year, month, day);
        Board findBoard = boardRepository.findByDate(date)
                .orElseThrow(() -> new BoardException(NOT_EXISTS_BOARD_TODAY));
        return new BoardResponse(findBoard.getId());
    }

    public BoardResponse createBoard(String year, String month, String day) {
        LocalDate date = parseToLocalDate(year, month, day);
        boardRepository.findByDate(date).ifPresent(board -> {throw new BoardException(ALREADY_EXISTS_BOARD_TODAY);});
        Board board = new Board(date);
        Board savedBoard = boardRepository.save(board);
        return new BoardResponse(savedBoard.getId());
    }

    private LocalDate parseToLocalDate(String year, String month, String day) {
        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        int dayInt = Integer.parseInt(day);
        return LocalDate.of(yearInt, monthInt, dayInt);
    }
}

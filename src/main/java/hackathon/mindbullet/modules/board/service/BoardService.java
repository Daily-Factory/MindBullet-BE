package hackathon.mindbullet.modules.board.service;

import hackathon.mindbullet.modules.board.dao.BoardRepository;
import hackathon.mindbullet.modules.board.domain.Board;
import hackathon.mindbullet.modules.board.dto.BoardResponse;
import hackathon.mindbullet.modules.board.dto.MemoTitleResponse;
import hackathon.mindbullet.modules.board.exception.BoardException;
import hackathon.mindbullet.modules.board.exception.BoardExceptionType;
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

    public List<MemoTitleResponse> getTitles(String year, String month, String day) {
        LocalDate date = parseToLocalDate(year, month, day);
        Board findBoard = boardRepository.findByDate(date)
                .orElseThrow(() -> new BoardException(BoardExceptionType.NOT_EXISTS_BOARD_ID));

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
                .orElseThrow(() -> new BoardException(BoardExceptionType.NOT_EXISTS_BOARD_ID));

        return new BoardResponse(findBoard.getId());
    }

    private LocalDate parseToLocalDate(String year, String month, String day) {
        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        int dayInt = Integer.parseInt(day);
        return LocalDate.of(yearInt, monthInt, dayInt);
    }
}

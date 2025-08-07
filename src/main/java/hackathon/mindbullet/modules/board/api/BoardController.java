package hackathon.mindbullet.modules.board.api;

import hackathon.mindbullet.modules.board.dto.BoardResponse;
import hackathon.mindbullet.modules.board.dto.MemoTitleResponse;
import hackathon.mindbullet.modules.board.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardId}/memos")
    public List<MemoTitleResponse> getTitles(@PathVariable Long boardId) {
        return boardService.getTitles(boardId);
    }

    @GetMapping("/{year}/{month}/{day}")
    public BoardResponse getBoardInfo(@PathVariable String year, @PathVariable String month, @PathVariable String day) {
        return boardService.getBoardInfo(year, month, day);
    }

    @PostMapping("/{year}/{month}/{day}")
    public ResponseEntity<BoardResponse> createBoard(@PathVariable String year, @PathVariable String month,
                                            @PathVariable String day) {
        BoardResponse response = boardService.createBoard(year, month, day);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

package hackathon.mindbullet.modules.board.api;

import static org.springframework.http.HttpStatus.CREATED;

import hackathon.mindbullet.modules.board.dto.BoardResponse;
import hackathon.mindbullet.modules.board.dto.MemoResponse;
import hackathon.mindbullet.modules.board.dto.MemoTitleResponse;
import hackathon.mindbullet.modules.board.service.BoardService;
import hackathon.mindbullet.modules.memo.dto.MemoRequest;
import hackathon.mindbullet.modules.memo.service.MemoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final MemoService memoService;

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

    @GetMapping("/{boardId}/memos/{memoId}")
    public MemoResponse getMemo(@PathVariable Long memoId) {
        return memoService.getMemo(memoId);
    }

    @PostMapping("/{boardId}/memos")
    public ResponseEntity<Void> createMemo(@RequestBody MemoRequest memoRequest) {
        memoService.createMemo(memoRequest);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{boardId}/memos/{memoId}")
    public ResponseEntity<Void> updateMemo(@PathVariable Long memoId, @RequestBody MemoRequest memoRequest) {
        memoService.updateMemo(memoId, memoRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{boardId}/memos/{memoId}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long memoId, @RequestBody String password) {
        memoService.deleteMemo(memoId, password);
        return ResponseEntity.noContent().build();
    }
}

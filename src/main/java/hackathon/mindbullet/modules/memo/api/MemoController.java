package hackathon.mindbullet.modules.memo.api;

import static org.springframework.http.HttpStatus.CREATED;

import hackathon.mindbullet.modules.board.dto.MemoResponse;
import hackathon.mindbullet.modules.memo.dto.MemoRequest;
import hackathon.mindbullet.modules.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memos")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/{memoId}")
    public MemoResponse getMemo(@PathVariable Long memoId) {
        return memoService.getMemo(memoId);
    }

    @PostMapping
    public ResponseEntity<Void> createMemo(@RequestBody MemoRequest memoRequest) {
        memoService.createMemo(memoRequest);
        return ResponseEntity.status(CREATED).build();
    }
}

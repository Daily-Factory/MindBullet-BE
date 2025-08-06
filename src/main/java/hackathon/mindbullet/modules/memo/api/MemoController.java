package hackathon.mindbullet.modules.memo.api;

import hackathon.mindbullet.modules.board.dto.MemoResponse;
import hackathon.mindbullet.modules.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}

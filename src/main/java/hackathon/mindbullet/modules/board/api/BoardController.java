package hackathon.mindbullet.modules.board.api;

import hackathon.mindbullet.modules.board.dto.MemoTitleResponse;
import hackathon.mindbullet.modules.board.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{year}/{month}/{day}/memos")
    public List<MemoTitleResponse> getTitles(@PathVariable String year, @PathVariable String month, @PathVariable String day) {
        return boardService.getTitles(year, month, day);
    }
}

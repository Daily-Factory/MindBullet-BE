package hackathon.mindbullet.modules.board.dto;

import hackathon.mindbullet.modules.memo.domain.MemoType;
import lombok.Builder;

@Builder
public record MemoResponse(
        String title,
        MemoType type,
        String content
) {
}

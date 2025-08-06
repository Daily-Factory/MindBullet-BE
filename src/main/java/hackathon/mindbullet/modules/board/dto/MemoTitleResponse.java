package hackathon.mindbullet.modules.board.dto;

import hackathon.mindbullet.modules.memo.domain.MemoType;
import lombok.Builder;

@Builder
public record MemoTitleResponse(
        Long id,
        MemoType type,
        String title
) {
}

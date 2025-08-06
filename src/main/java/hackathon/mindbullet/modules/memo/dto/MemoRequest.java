package hackathon.mindbullet.modules.memo.dto;

import hackathon.mindbullet.modules.memo.domain.MemoType;

public record MemoRequest(
        Long boardId,
        String title,
        MemoType type,
        String content,
        String password
) {
}

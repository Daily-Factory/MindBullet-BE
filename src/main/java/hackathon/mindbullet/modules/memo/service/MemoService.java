package hackathon.mindbullet.modules.memo.service;

import hackathon.mindbullet.modules.board.dto.MemoResponse;
import hackathon.mindbullet.modules.memo.dao.MemoRepository;
import hackathon.mindbullet.modules.memo.domain.Memo;
import hackathon.mindbullet.modules.memo.exception.MemoException;
import hackathon.mindbullet.modules.memo.exception.MemoExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoResponse getMemo(Long memoId) {
        Memo findMemo = memoRepository.findById(memoId)
                .orElseThrow(() -> new MemoException(MemoExceptionType.NOT_EXISTS_ID));
        return MemoResponse.builder()
                .title(findMemo.getTitle())
                .type(findMemo.getType())
                .content(findMemo.getContent())
                .build();
    }
}

package hackathon.mindbullet.modules.memo.dao;

import hackathon.mindbullet.modules.memo.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}

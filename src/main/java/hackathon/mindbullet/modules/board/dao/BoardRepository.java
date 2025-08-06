package hackathon.mindbullet.modules.board.dao;

import hackathon.mindbullet.modules.board.domain.Board;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select b from Board b join fetch b.memos")
    Optional<Board> findByDate(LocalDate date);
}

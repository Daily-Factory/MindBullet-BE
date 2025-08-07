package hackathon.mindbullet.modules.board.dao;

import hackathon.mindbullet.modules.board.domain.Board;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select b from Board b left join fetch b.memos where b.id = :id")
    Optional<Board> findByIdWithMemo(@Param("id") Long id);
    Optional<Board> findByDate(LocalDate date);
}

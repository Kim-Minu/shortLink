package management.shortLink.domain.link;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, String> {

    @Query("SELECT p FROM Link p ORDER BY p.shortId DESC")
    List<Link> findAllDesc();
}

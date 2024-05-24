package tr.edu.medipol.ilerijavafinal.ilerijavafinal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.medipol.ilerijavafinal.ilerijavafinal.Entity.Oyuncak;

@Repository
public interface OyuncakRepository extends JpaRepository<Oyuncak, Long> {
}

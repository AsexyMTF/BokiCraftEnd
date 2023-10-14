package online.boki.backend.Repository;

import online.boki.backend.Model.Contribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributeRepository extends JpaRepository<Contribute,Long> {

    List<Contribute> findContributesByHasPicture(boolean hasPicture);
}

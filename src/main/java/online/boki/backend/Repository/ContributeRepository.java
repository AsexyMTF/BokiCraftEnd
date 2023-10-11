package online.boki.backend.Repository;

import online.boki.backend.Model.Contribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributeRepository extends JpaRepository<Contribute,Long> {

}

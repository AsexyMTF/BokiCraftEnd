package online.boki.backend.Repository;

import online.boki.backend.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public Account findAccountByUserID(String UserID);
}

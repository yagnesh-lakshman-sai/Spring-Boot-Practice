package in.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.com.entity.Account;
import in.com.entity.AccountPK;

public interface AccountRepo
		extends JpaRepository<Account, AccountPK>{
}

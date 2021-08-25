package web.data;

import org.springframework.data.repository.CrudRepository;

import web.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{

	Account getAccountByUserName(String userName);
	
}

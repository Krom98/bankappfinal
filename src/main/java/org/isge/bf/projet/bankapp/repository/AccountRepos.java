package org.isge.bf.projet.bankapp.repository;

import org.isge.bf.projet.bankapp.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepos extends CrudRepository<Account, Integer> {
    Account findByCountNum(int countNum);
}

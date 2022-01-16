package org.isge.bf.projet.bankapp.service;

import org.isge.bf.projet.bankapp.model.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findById(int id);
    Account addAccount(Account account);
    Account updateAccount(Account account);
    Account findByAccountNumb(int countNum);
}

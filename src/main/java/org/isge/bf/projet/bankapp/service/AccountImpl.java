package org.isge.bf.projet.bankapp.service;

import org.isge.bf.projet.bankapp.model.Account;
import org.isge.bf.projet.bankapp.repository.AccountRepos;
import org.isge.bf.projet.bankapp.repository.RepositoryAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
@Service
public class AccountImpl implements AccountService {
    @Autowired
    public AccountRepos accountRepos;
    @Autowired
    public RepositoryAccount repositoryAccount;

    @Override
    public Optional<Account> findById(int id) {
        return Optional.empty();
    }

    public Iterable<Account> findAllAccount() {
        return repositoryAccount.findAll();    }

    public int numberGenerator(){
        int number = 100000;
        Random rnd = new Random();
        boolean isAllowed = true;
        Iterable<Account> accounts = this.findAllAccount();

        while (isAllowed){
            isAllowed=false;
            number = rnd.nextInt(899999) + 100000;
            for(Account compte:accounts){
                if(compte.getCountNum()==number) isAllowed=true;
            }

        }
        return number;
    }
    @Override
    public Account addAccount(Account account) {
        return repositoryAccount.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return repositoryAccount.save(account);
    }

    @Override
    public Account findByAccountNumb(int countNum) {
        return accountRepos.findByCountNum(countNum);
    }

    public Account findAccount(int id)
    {
        Iterable<Account> accounts=findAllAccount();
        Account cmpt=new Account();
        for(Account account: accounts) {
            if (account.getUsers().getId()==id)
            {
                cmpt=account;
            }

        }
        return cmpt;
    }
}

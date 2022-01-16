package org.isge.bf.projet.bankapp.repository;

import org.isge.bf.projet.bankapp.model.Bankusers;
import org.springframework.data.repository.CrudRepository;

public interface BankusersRepo extends CrudRepository<Bankusers, Integer> {
    Bankusers findByMail(String mail);
    Bankusers findByMailAndPassword(String mail, String password);
}

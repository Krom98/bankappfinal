package org.isge.bf.projet.bankapp.service;

import org.isge.bf.projet.bankapp.dto.BankusersDto;
import org.isge.bf.projet.bankapp.model.Bankusers;
import org.isge.bf.projet.bankapp.model.Transaction;

import java.util.Optional;

public interface BankusersService {

    Optional<Bankusers> findById(int id);
    Bankusers addUser(BankusersDto bankusersDto);
    Bankusers findByFirstname(String firstname);
    Bankusers findByLastname(String lastname);
    Bankusers findByMail(String mail);

}

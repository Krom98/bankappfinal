package org.isge.bf.projet.bankapp.repository;

import org.isge.bf.projet.bankapp.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepo extends CrudRepository<Transaction, Integer> {

}

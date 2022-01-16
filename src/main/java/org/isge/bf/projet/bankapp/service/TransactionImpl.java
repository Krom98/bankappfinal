package org.isge.bf.projet.bankapp.service;

import org.isge.bf.projet.bankapp.model.Transaction;
import org.isge.bf.projet.bankapp.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionImpl implements TransactionService{
    @Autowired
    TransactionRepo transactionRepo;
    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }
}

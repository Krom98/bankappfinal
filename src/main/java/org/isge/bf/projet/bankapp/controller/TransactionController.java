package org.isge.bf.projet.bankapp.controller;

import org.isge.bf.projet.bankapp.model.Account;
import org.isge.bf.projet.bankapp.model.Transaction;
import org.isge.bf.projet.bankapp.service.AccountService;
import org.isge.bf.projet.bankapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class TransactionController {
    @Autowired
    TransactionService transacService;
    @Autowired
    AccountService countservice;

    Transaction dateSetter;

    @PostMapping(value = {"/virement"})//, method = RequestMethod.POST)
    public String virement (Model model, @ModelAttribute("transaction") Transaction transaction, HttpSession httpSession){
        if(countservice.findByAccountNumb(transaction.getDestNum())!=null)
        {
            Account count1 =(Account) httpSession.getAttribute("account");
            Account count2 = countservice.findByAccountNumb(transaction.getDestNum());

            count1.setBalance(count1.getBalance()-transaction.getMontantTran());
            count2.setBalance(count2.getBalance()+transaction.getMontantTran());
            transaction.setDate(LocalDateTime.now());
            countservice.updateAccount(count1);
            countservice.updateAccount(count2);

            transacService.addTransaction(transaction);

        }
        return "transfertvalide";///acceuil

    }
}

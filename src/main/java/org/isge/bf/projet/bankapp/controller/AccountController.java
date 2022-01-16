package org.isge.bf.projet.bankapp.controller;

import org.isge.bf.projet.bankapp.dto.BankusersDto;
import org.isge.bf.projet.bankapp.model.Account;
import org.isge.bf.projet.bankapp.model.Bankusers;
import org.isge.bf.projet.bankapp.service.AccountImpl;
import org.isge.bf.projet.bankapp.service.BankusersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
@Controller
public class AccountController {
    @Autowired
    AccountImpl accountImpl;
    @Autowired
    BankusersImpl usersImpl;

    @RequestMapping(value = "/accounts/save", method = RequestMethod.POST)
    public Account add(@RequestBody Account account){
        this.accountImpl.addAccount(account);
        return null;
    }

    @RequestMapping(value = {"/countNum"}, method = RequestMethod.POST)
    public String countNum (Model model, @ModelAttribute("userDto") BankusersDto bankusersDto, HttpSession httpSession){
        String a=bankusersDto.getPassword();
        bankusersDto=(BankusersDto) httpSession.getAttribute("userDto");
        bankusersDto.setPassword(a);
        Bankusers user=usersImpl.adUser(bankusersDto,model);
        Account account = new Account();
        account.setCountNum(accountImpl.numberGenerator());
        account.setBalance(100000);
        account.setUsers(user);
        accountImpl.addAccount(account);

        httpSession.setAttribute("account", account);
       // model.addAttribute("userDto", bankusersDto);
        model.addAttribute("account", account);


        model.addAttribute("userDto", bankusersDto);
        return afficher(model);
    }

    @RequestMapping(value = {"/A"}, method = RequestMethod.GET)
    public String afficher(Model model){
        return "acceuil";
    }


}

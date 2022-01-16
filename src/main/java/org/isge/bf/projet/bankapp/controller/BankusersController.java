package org.isge.bf.projet.bankapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.isge.bf.projet.bankapp.dto.BankusersDto;
import org.isge.bf.projet.bankapp.model.Bankusers;
import org.isge.bf.projet.bankapp.model.Transaction;
import org.isge.bf.projet.bankapp.service.AccountImpl;
import org.isge.bf.projet.bankapp.service.BankusersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
@Controller
@Slf4j
@AllArgsConstructor
public class BankusersController {

    @Autowired
    BankusersImpl usersImpl;
    @Autowired
    AccountImpl accountImpl;


    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public Bankusers add(@RequestBody BankusersDto userdto){
        Bankusers user = new Bankusers();
        usersImpl.addUser(userdto);
        return null;
    }


    @RequestMapping(value = "/users/getClient", method = RequestMethod.GET)
    public Bankusers getterByMail(@RequestParam("email") String mail){

        return usersImpl.findByMail(mail);
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String adduser (Model model, @RequestBody BankusersDto userDto){
        usersImpl.addUser(userDto);
        return "inscription";
    }

    @RequestMapping(value = {"/enregistrement"}, method = RequestMethod.POST)
    public String adduser (Model model, @ModelAttribute("userDto") BankusersDto userDto, HttpSession httpSession){
        // User user=usersImpl.adUser(userDto,model);
        //userDto.setPassword(user.getPassword());
        model.addAttribute("userDto",userDto);
        httpSession.setAttribute("userDto", userDto);

        return addrecup(model);
    }

    @RequestMapping(value = {"/recup"}, method = RequestMethod.GET)
    public String addrecup (Model model){
        return "indexrecup";
    }



    @RequestMapping(value = {"/authentification"}, method = RequestMethod.POST)
    public String compare (Model model, @ModelAttribute("userDto") BankusersDto userDto, HttpSession httpSession){
        if(usersImpl.findByMailAndPassword(userDto.getMail(),userDto.getPassword())!=null)
        {
            Bankusers user=usersImpl.findByMailAndPassword(userDto.getMail(),userDto.getPassword());
            Transaction transaction=new Transaction();
            model.addAttribute("user",user);
            model.addAttribute("transaction",transaction);
            httpSession.setAttribute("account",accountImpl.findAccount(user.getId()));
            return "acceuil";////page acceuil pour user a creer
        }

        else {return addrecup(model);}
    }
}

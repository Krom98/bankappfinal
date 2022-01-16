package org.isge.bf.projet.bankapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.isge.bf.projet.bankapp.dto.BankusersDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@AllArgsConstructor
public class HomeController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(Model model){
        BankusersDto userDto = new BankusersDto();
        model.addAttribute("userDto", userDto);

        return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)

    public String login(Model model){
        BankusersDto userDto = new BankusersDto();
        model.addAttribute("userDto", userDto);

        return "login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)

    public String register(Model model){
        BankusersDto userDto = new BankusersDto();
        model.addAttribute("userDto", userDto);

        return "register";
    }

    @RequestMapping(value = {"/back"}, method = RequestMethod.GET)
    public String back(Model model){
        BankusersDto userDto = new BankusersDto();
        model.addAttribute("userDto", userDto);

        return "back";
    }

}

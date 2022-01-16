package org.isge.bf.projet.bankapp.RestController;

import org.isge.bf.projet.bankapp.dto.BankusersDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


public class HomeRestControl {
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(Model model) {
        BankusersDto userDto = new BankusersDto();
        model.addAttribute("userDto", userDto);

        return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)

    public String login(Model model) {
        BankusersDto userDto = new BankusersDto();
        model.addAttribute("userDto", userDto);

        return "login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)

    public String register(Model model) {
        BankusersDto userDto = new BankusersDto();
        model.addAttribute("userDto", userDto);

        return "register";
    }

}

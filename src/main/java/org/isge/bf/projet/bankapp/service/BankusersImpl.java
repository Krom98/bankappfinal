package org.isge.bf.projet.bankapp.service;

import org.isge.bf.projet.bankapp.dto.BankusersDto;
import org.isge.bf.projet.bankapp.model.Bankusers;
import org.isge.bf.projet.bankapp.repository.BankusersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;
@Service
public class BankusersImpl implements BankusersService{

    @Autowired
    BankusersRepo bankusersRepo;
    @Override
    public Optional<Bankusers> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Bankusers addUser(BankusersDto bankusersDto) {
        return null;
    }

    public Bankusers adUser(BankusersDto bankusersDto, Model model) {
        Bankusers users= new Bankusers();
        model.addAttribute("userDto");
        users.setFirstname(bankusersDto.getFirstname());
        users.setLastname(bankusersDto.getLastname());
        users.setPassword(bankusersDto.getPassword());
        users.setMail(bankusersDto.getMail());
        users.setBirthday(bankusersDto.getBirthday());
        users.setPhone(bankusersDto.getPhone());
        users.setNationality(bankusersDto.getNationality());
        bankusersRepo.save(users);
        return users;
    }

    @Override
    public Bankusers findByFirstname(String firstname) {
        return null;
    }

    @Override
    public Bankusers findByLastname(String lastname) {
        return null;
    }

    @Override
    public Bankusers findByMail(String mail) {
        return bankusersRepo.findByMail(mail);
    }

    public Bankusers findByMailAndPassword(String mail,String password) {
        return bankusersRepo.findByMailAndPassword(mail, password);
    }

}

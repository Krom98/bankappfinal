package org.isge.bf.projet.bankapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class BankusersDto {

  //  private int id;
    private String firstname;
    private String lastname;
    private String password;
    private String phone;
    private String birthday;
    private String nationality;
    private String mail;

}

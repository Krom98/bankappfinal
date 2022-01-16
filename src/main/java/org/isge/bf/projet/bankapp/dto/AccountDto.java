package org.isge.bf.projet.bankapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.isge.bf.projet.bankapp.model.Bankusers;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
public class AccountDto {

    private int id;
    private int countNum;
    private double balance;

}

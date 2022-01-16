package org.isge.bf.projet.bankapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
@Getter
@Setter
public class TransactionDto {

    private long id;
    private double montantTran;
    private int destNum;
    private LocalDate date;
}

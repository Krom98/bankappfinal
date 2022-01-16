package org.isge.bf.projet.bankapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transaction")
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private long id;
    @Column(name = "montantTran", nullable = false, updatable = false)
    private double montantTran;
    @Column(name = "destNum", nullable = false, updatable = false)
    private int destNum;
    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date;
    @ManyToOne
    private Bankusers user;
}

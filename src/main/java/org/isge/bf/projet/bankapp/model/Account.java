package org.isge.bf.projet.bankapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account")
@Getter
@Setter

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "countNum",length =6, nullable = false, updatable = false)
    private int countNum;

    @Column(name = "balance", nullable = false)
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Bankusers users;
}

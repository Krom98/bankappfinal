package org.isge.bf.projet.bankapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "bankusers")
@Getter
@Setter

public class Bankusers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "password", length =4, nullable = false)
    private String password;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "mail", nullable = false)
    private String mail;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Account> accountList;


    public Bankusers() {

    }
}

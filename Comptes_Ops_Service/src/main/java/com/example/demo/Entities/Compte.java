package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private long clientId ;
    private String code ;
    private double sold ;
    private Date dateCreation ;
    private String type ;
    private boolean active ;
    @Transient
    private Client client ;
    @OneToMany(mappedBy = "compte")
    List<Operation> operationList =  new ArrayList<Operation>();
}

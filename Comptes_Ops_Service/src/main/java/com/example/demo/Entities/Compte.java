package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
    @OneToMany(mappedBy = "compte",fetch = FetchType.EAGER)
    List<Operation> operationList ;
}

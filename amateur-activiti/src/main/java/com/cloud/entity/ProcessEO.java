package com.cloud.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="t_process")
@Setter
@Getter
@NoArgsConstructor
public class ProcessEO implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;


    @Column(name="NAME")
    private String name;


    @Column(name="OPDATE")
    @Temporal(value = TemporalType.DATE)
    private Date opDate;



}

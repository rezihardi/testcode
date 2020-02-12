package com.sml.testcode.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "Karyawan")
public class Karyawan {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long nik;

    private String nama;

    private String alamat;
}

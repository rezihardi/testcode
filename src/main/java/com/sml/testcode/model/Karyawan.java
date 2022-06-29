package com.sml.testcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "Karyawan")
@AllArgsConstructor
@NoArgsConstructor
public class Karyawan {

    @Id
//    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long nik;

    private String nama;

    private String alamat;
}

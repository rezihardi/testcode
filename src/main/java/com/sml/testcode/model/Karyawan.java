package com.sml.testcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data
@Entity
@Table(name = "Karyawan")
@AllArgsConstructor
@NoArgsConstructor
public class Karyawan {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long nik;

    private String nama;

    private String alamat;
}

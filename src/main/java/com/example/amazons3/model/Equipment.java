package com.example.amazons3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "typeEquipment", length = 20, nullable = false)
    private String typeEquipment;

    @Column(name = "model", length = 100, nullable = false)
    private String model;

    @Column(name = "mounth", nullable = false)
    private int mounth;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "linkImage", length = 200, nullable = false)
    private String linkImage;
}

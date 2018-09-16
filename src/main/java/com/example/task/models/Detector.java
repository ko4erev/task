package com.example.task.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "detector")
@Data
@NoArgsConstructor
public class Detector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_equipment")
    private Long idEquipment;

    @Column(name = "attribute")
    private String attribute;
}

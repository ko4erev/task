package com.example.task.models;

import javax.persistence.*;

import lombok.*;

import java.util.List;


@Entity
@Table(name = "factory")
@Data
@NoArgsConstructor
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "attribute")
    private String attribute;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_factory", referencedColumnName = "id", insertable = false, updatable = false)
    private List<Sector> sector;
}

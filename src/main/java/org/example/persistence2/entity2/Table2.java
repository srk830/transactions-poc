package org.example.persistence2.entity2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "table2")
public class Table2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "col1")
    private String col1;

    @Column(name = "col2")
    private String col2;

}
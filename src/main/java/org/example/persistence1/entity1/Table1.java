package org.example.persistence1.entity1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.constants.Constants;
import org.springframework.beans.factory.annotation.Qualifier;

@Getter
@Setter
@Entity
@Table(name = "table1")
@Qualifier(Constants.DATA_SOURCE_1)
public class Table1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "col1")
    private String col1;

    @Column(name = "col2")
    private String col2;

}
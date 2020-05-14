package io.amin.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "OPTIONS")
public class Option {

    @Id
    @GeneratedValue
    @Column(name = "OPTION_ID")
    private int id;

    @Column(name = "OPTION_VALUE")
    private String value;

}

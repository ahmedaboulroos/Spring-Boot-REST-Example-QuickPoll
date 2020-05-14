package io.amin.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VOTES")
public class Vote {

    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    private int id;

    @OneToOne
    @JoinColumn(name = "OPTION_ID")
    private Option option;

}

package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "attemptQuestionList")
@Table(name = "attempt")
public class Attempt {
    @Id @Column(name = "at_id") private int id;
    @Column(name = "at_date") private Date date;
    @Column(name = "at_score") private double score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "at_us_id")
    private User user;

    @OneToMany(mappedBy = "attempt", fetch = FetchType.LAZY)
    private Set<AttemptQuestion> attemptQuestionList;
}

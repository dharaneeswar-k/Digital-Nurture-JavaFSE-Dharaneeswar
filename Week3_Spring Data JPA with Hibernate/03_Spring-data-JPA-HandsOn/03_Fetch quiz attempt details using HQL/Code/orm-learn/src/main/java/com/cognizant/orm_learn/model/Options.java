package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "question")
@Table(name = "options")
public class Options {
    @Id @Column(name = "op_id") private int id;
    @Column(name = "op_text") private String text;
    @Column(name = "op_score") private double score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "op_qt_id")
    private Question question;
}

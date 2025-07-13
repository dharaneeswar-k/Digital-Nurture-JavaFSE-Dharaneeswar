package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "options")
@Table(name = "question")
public class Question {
    @Id @Column(name = "qt_id") private int id;
    @Column(name = "qt_text") private String text;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private Set<Options> options;
}

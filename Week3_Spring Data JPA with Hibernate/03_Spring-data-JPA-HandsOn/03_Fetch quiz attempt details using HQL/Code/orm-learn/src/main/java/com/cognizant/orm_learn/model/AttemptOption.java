package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "option")
@Table(name = "attempt_option")
public class AttemptOption {
    @Id @Column(name = "ao_id") private int id;
    @Column(name = "ao_selected") private boolean selected;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ao_op_id")
    private Options option;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ao_aq_id")
    private AttemptQuestion attemptQuestion;
}

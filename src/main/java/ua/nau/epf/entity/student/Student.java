package ua.nau.epf.entity.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Person;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student extends Person {
    @Column(nullable = false, unique = true)
    private String studentCode;
    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;
    @OneToOne(fetch = FetchType.LAZY)
    private RecordBook recordBook;
}

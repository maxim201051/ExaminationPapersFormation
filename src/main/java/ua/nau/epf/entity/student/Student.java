package ua.nau.epf.entity.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Person;
import ua.nau.epf.entity.student.recordbook.RecordBookRecord;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(fetch = FetchType.LAZY)
    private List<RecordBookRecord> recordBook;
}

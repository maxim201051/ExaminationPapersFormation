package ua.nau.epf.entity.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Teacher extends Person {
    @Column(nullable = false)
    private Position position;
    @Column(nullable = false)
    private AcademicDegree academicDegree;
    @Column(nullable = false)
    private AcademicStatus academicStatus;
    @Column(nullable = false)
    private LocalDate hiringDate;
    @Column(nullable = false)
    private boolean dismissed;
    private LocalDate dismissalDate;
}

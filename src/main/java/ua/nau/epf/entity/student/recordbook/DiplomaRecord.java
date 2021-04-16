package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Person;
import ua.nau.epf.entity.student.EducationalDegree;
import ua.nau.epf.entity.teacher.Teacher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DiplomaRecord extends RecordBookRecord {
    @Column(nullable = false)
    private String diplomaTitle;
    @ManyToOne //todo use teacher or person type?
    private Person supervisor;
    @Column(nullable = false)
    private boolean admittedToDefense;
    @Column(nullable = false)
    private EducationalDegree assignedQualification;
    @ManyToMany
    private List<Teacher> commissionMembers;
}

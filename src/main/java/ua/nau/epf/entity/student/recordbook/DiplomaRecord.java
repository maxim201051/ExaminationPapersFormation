package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.student.EducationalDegree;
import ua.nau.epf.entity.teacher.Teacher;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class DiplomaRecord extends RecordBookRecord {
    @Column(nullable = false)
    private String diplomaTitle;
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher supervisor;
    @Column(nullable = false)
    private Boolean admittedToDefense;
    @Column(nullable = false)
    private EducationalDegree assignedQualification;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Teacher> commissionMembers;
}

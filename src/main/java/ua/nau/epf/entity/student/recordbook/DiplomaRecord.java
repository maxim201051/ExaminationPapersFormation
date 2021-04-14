package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.student.EducationalDegree;
import ua.nau.epf.entity.teacher.Teacher;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiplomaRecord extends RecordBookRecord {
    private String diplomaTitle;
    private Teacher supervisor;
    private boolean admittedToDefense;
    private EducationalDegree assignedQualification;
    private List<Teacher> commissionMembers;
}

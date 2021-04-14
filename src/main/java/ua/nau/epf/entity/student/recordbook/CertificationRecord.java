package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.teacher.Teacher;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificationRecord extends RecordBookRecord {
    private String certificationName;
    private List<Teacher> commissionMembers;
}

package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.teacher.Teacher;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class CertificationRecord extends RecordBookRecord {
    @Column(nullable = false)
    private String certificationName;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Teacher> commissionMembers;
}

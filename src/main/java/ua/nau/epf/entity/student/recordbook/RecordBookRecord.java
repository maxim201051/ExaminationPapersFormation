package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table
public class RecordBookRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private NationalScale nationalScaleMark;
    @Column(nullable = false, columnDefinition = "int check((number_of_points between 60 and 100) or number_of_points=0)")
    private int numberOfPoints;
    @Column(nullable = false)
    private ECTSScale ectsScaleMark;
    @Column(nullable = false)
    private LocalDate recordDate;
}

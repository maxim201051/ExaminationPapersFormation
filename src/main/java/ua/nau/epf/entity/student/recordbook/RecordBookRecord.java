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
public class RecordBookRecord { //todo make all mark scales calculable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private NationalScale nationalScaleMark;
    @Column(columnDefinition = "int check((number_of_points between 60 and 100) or number_of_points=0)")
    private Integer numberOfPoints;
    private ECTSScale ectsScaleMark;
    private LocalDate recordDate;
    @Column(nullable = false)
    private Boolean hasDebt;
}

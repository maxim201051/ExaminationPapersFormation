package ua.nau.epf.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private Long id;
    private String name;
    private SubjectDetails currentSemesterDetails;
    private boolean hasCourseWork;

}

package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupToSubjectRelDTO {
    private Pair<String, Long> group;
    private Pair<String, Long> subject;
    private Integer semester;
}

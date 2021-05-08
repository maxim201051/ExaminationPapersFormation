package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AdminHelpRequestDTO {
    private Long id;
    private Pair<String, Long> sender;
    private String requestText;
    private LocalDate creationDate;
    private Boolean resolved;
}

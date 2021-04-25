package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CertificationRecordDTO extends RecordBookRecordDTO {
    private String certificationName;
    private Map<String, Long> commissionMembers;
}

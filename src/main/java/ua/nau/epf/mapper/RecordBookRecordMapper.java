package ua.nau.epf.mapper;

import ua.nau.epf.dto.RecordBookRecordDTO;
import ua.nau.epf.entity.student.recordbook.ECTSScale;
import ua.nau.epf.entity.student.recordbook.NationalScale;
import ua.nau.epf.entity.student.recordbook.RecordBookRecord;

public class RecordBookRecordMapper {
    private RecordBookRecordMapper() {
    }

    public static void updateRecordEntityWithFieldsFromDto(RecordBookRecord entity, RecordBookRecordDTO dto) {
        dto.setId(entity.getId());
        dto.setNationalScaleMark(entity.getNationalScaleMark().name());
        dto.setNumberOfPoints(entity.getNumberOfPoints());
        dto.setEctsScaleMark(entity.getEctsScaleMark().name());
        dto.setRecordDate(entity.getRecordDate());
    }

    public static void updateRecordDtoWithFieldsFromEntity(RecordBookRecordDTO dto, RecordBookRecord entity) {
        entity.setId(dto.getId());
        entity.setNationalScaleMark(NationalScale.valueOf(dto.getNationalScaleMark()));
        entity.setNumberOfPoints(dto.getNumberOfPoints());
        entity.setEctsScaleMark(ECTSScale.valueOf(dto.getEctsScaleMark()));
        entity.setRecordDate(dto.getRecordDate());
    }
}

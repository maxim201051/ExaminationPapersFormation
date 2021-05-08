package ua.nau.epf.mapper;

import ua.nau.epf.dto.RecordBookRecordDTO;
import ua.nau.epf.entity.student.recordbook.*;

public class RecordBookRecordMapper {
    private RecordBookRecordMapper() {
    }

    public static void updateRecordEntityWithFieldsFromDto(RecordBookRecord entity, RecordBookRecordDTO dto) {
        entity.setId(dto.getId());
        entity.setNationalScaleMark(NationalScale.valueOf(dto.getNationalScaleMark()));
        entity.setNumberOfPoints(dto.getNumberOfPoints());
        entity.setEctsScaleMark(ECTSScale.valueOf(dto.getEctsScaleMark()));
        entity.setRecordDate(dto.getRecordDate());
        entity.setHasDebt(dto.getHasDebt());
    }

    public static void updateRecordDtoWithFieldsFromEntity(RecordBookRecordDTO dto, RecordBookRecord entity) {
        dto.setId(entity.getId());
        dto.setNationalScaleMark(entity.getNationalScaleMark().name());
        dto.setNumberOfPoints(entity.getNumberOfPoints());
        dto.setEctsScaleMark(entity.getEctsScaleMark().name());
        dto.setRecordDate(entity.getRecordDate());
        dto.setHasDebt(entity.getHasDebt());
    }

    public static RecordBookRecordDTO mapEntityToDto(RecordBookRecord entity) {
        RecordBookRecordDTO recordBookRecordDTO = null;
        if (entity instanceof CertificationRecord) {
            recordBookRecordDTO = CertificationRecordMapper.mapEntityToDto((CertificationRecord) entity);
        } else if (entity instanceof DiplomaRecord) {
            recordBookRecordDTO = DiplomaRecordMapper.mapEntityToDto((DiplomaRecord) entity);
        } else if (entity instanceof DisciplineSemesterRecord) {
            recordBookRecordDTO = DisciplineSemesterRecordMapper.mapEntityToDto((DisciplineSemesterRecord) entity);
        } else if (entity instanceof OtherUniversityDisciplineRecord) {
            recordBookRecordDTO = OtherUniversityDisciplineRecordMapper.mapEntityToDto((OtherUniversityDisciplineRecord) entity);
        } else if (entity instanceof PracticeRecord) {
            recordBookRecordDTO = PracticeMapper.mapEntityToDto((PracticeRecord) entity);
        }
        return recordBookRecordDTO;
    }
}

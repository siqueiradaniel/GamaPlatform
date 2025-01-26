package org.gama.platform.service.mapper;

import org.gama.platform.domain.Exam;
import org.gama.platform.domain.Student;
import org.gama.platform.service.dto.ExamDTO;
import org.gama.platform.service.dto.StudentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Student} and its DTO {@link StudentDTO}.
 */
@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {
    @Mapping(target = "exam", source = "exam", qualifiedByName = "examId")
    StudentDTO toDto(Student s);

    @Named("examId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ExamDTO toDtoExamId(Exam exam);
}

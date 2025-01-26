package org.gama.platform.service.mapper;

import org.gama.platform.domain.PendingStudentSubcontent;
import org.gama.platform.domain.Student;
import org.gama.platform.domain.Subcontent;
import org.gama.platform.service.dto.PendingStudentSubcontentDTO;
import org.gama.platform.service.dto.StudentDTO;
import org.gama.platform.service.dto.SubcontentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PendingStudentSubcontent} and its DTO {@link PendingStudentSubcontentDTO}.
 */
@Mapper(componentModel = "spring")
public interface PendingStudentSubcontentMapper extends EntityMapper<PendingStudentSubcontentDTO, PendingStudentSubcontent> {
    @Mapping(target = "subcontent", source = "subcontent", qualifiedByName = "subcontentId")
    @Mapping(target = "student", source = "student", qualifiedByName = "studentId")
    PendingStudentSubcontentDTO toDto(PendingStudentSubcontent s);

    @Named("subcontentId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SubcontentDTO toDtoSubcontentId(Subcontent subcontent);

    @Named("studentId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StudentDTO toDtoStudentId(Student student);
}

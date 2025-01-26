package org.gama.platform.service.mapper;

import org.gama.platform.domain.Exam;
import org.gama.platform.domain.LearningPath;
import org.gama.platform.domain.Subcontent;
import org.gama.platform.service.dto.ExamDTO;
import org.gama.platform.service.dto.LearningPathDTO;
import org.gama.platform.service.dto.SubcontentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link LearningPath} and its DTO {@link LearningPathDTO}.
 */
@Mapper(componentModel = "spring")
public interface LearningPathMapper extends EntityMapper<LearningPathDTO, LearningPath> {
    @Mapping(target = "exam", source = "exam", qualifiedByName = "examId")
    @Mapping(target = "subcontent", source = "subcontent", qualifiedByName = "subcontentId")
    LearningPathDTO toDto(LearningPath s);

    @Named("examId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ExamDTO toDtoExamId(Exam exam);

    @Named("subcontentId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SubcontentDTO toDtoSubcontentId(Subcontent subcontent);
}

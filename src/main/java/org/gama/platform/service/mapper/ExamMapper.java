package org.gama.platform.service.mapper;

import org.gama.platform.domain.Exam;
import org.gama.platform.service.dto.ExamDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Exam} and its DTO {@link ExamDTO}.
 */
@Mapper(componentModel = "spring")
public interface ExamMapper extends EntityMapper<ExamDTO, Exam> {}

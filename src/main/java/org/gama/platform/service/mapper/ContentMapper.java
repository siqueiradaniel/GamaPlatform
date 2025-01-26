package org.gama.platform.service.mapper;

import org.gama.platform.domain.Content;
import org.gama.platform.service.dto.ContentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Content} and its DTO {@link ContentDTO}.
 */
@Mapper(componentModel = "spring")
public interface ContentMapper extends EntityMapper<ContentDTO, Content> {}

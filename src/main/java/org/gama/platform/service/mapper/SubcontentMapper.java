package org.gama.platform.service.mapper;

import org.gama.platform.domain.Content;
import org.gama.platform.domain.Subcontent;
import org.gama.platform.service.dto.ContentDTO;
import org.gama.platform.service.dto.SubcontentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Subcontent} and its DTO {@link SubcontentDTO}.
 */
@Mapper(componentModel = "spring")
public interface SubcontentMapper extends EntityMapper<SubcontentDTO, Subcontent> {
    @Mapping(target = "content", source = "content", qualifiedByName = "contentId")
    SubcontentDTO toDto(Subcontent s);

    @Named("contentId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ContentDTO toDtoContentId(Content content);
}

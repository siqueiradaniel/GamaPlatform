package org.gama.platform.service.mapper;

import org.gama.platform.domain.Dependency;
import org.gama.platform.domain.Subcontent;
import org.gama.platform.service.dto.DependencyDTO;
import org.gama.platform.service.dto.SubcontentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Dependency} and its DTO {@link DependencyDTO}.
 */
@Mapper(componentModel = "spring")
public interface DependencyMapper extends EntityMapper<DependencyDTO, Dependency> {
    @Mapping(target = "subcontent", source = "subcontent", qualifiedByName = "subcontentId")
    DependencyDTO toDto(Dependency s);

    @Named("subcontentId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SubcontentDTO toDtoSubcontentId(Subcontent subcontent);
}

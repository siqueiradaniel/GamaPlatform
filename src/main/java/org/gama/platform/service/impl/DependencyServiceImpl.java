package org.gama.platform.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.gama.platform.domain.Dependency;
import org.gama.platform.repository.DependencyRepository;
import org.gama.platform.service.DependencyService;
import org.gama.platform.service.dto.DependencyDTO;
import org.gama.platform.service.mapper.DependencyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link org.gama.platform.domain.Dependency}.
 */
@Service
@Transactional
public class DependencyServiceImpl implements DependencyService {

    private static final Logger LOG = LoggerFactory.getLogger(DependencyServiceImpl.class);

    private final DependencyRepository dependencyRepository;

    private final DependencyMapper dependencyMapper;

    public DependencyServiceImpl(DependencyRepository dependencyRepository, DependencyMapper dependencyMapper) {
        this.dependencyRepository = dependencyRepository;
        this.dependencyMapper = dependencyMapper;
    }

    @Override
    public DependencyDTO save(DependencyDTO dependencyDTO) {
        LOG.debug("Request to save Dependency : {}", dependencyDTO);
        Dependency dependency = dependencyMapper.toEntity(dependencyDTO);
        dependency = dependencyRepository.save(dependency);
        return dependencyMapper.toDto(dependency);
    }

    @Override
    public DependencyDTO update(DependencyDTO dependencyDTO) {
        LOG.debug("Request to update Dependency : {}", dependencyDTO);
        Dependency dependency = dependencyMapper.toEntity(dependencyDTO);
        dependency = dependencyRepository.save(dependency);
        return dependencyMapper.toDto(dependency);
    }

    @Override
    public Optional<DependencyDTO> partialUpdate(DependencyDTO dependencyDTO) {
        LOG.debug("Request to partially update Dependency : {}", dependencyDTO);

        return dependencyRepository
            .findById(dependencyDTO.getId())
            .map(existingDependency -> {
                dependencyMapper.partialUpdate(existingDependency, dependencyDTO);

                return existingDependency;
            })
            .map(dependencyRepository::save)
            .map(dependencyMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DependencyDTO> findAll() {
        LOG.debug("Request to get all Dependencies");
        return dependencyRepository.findAll().stream().map(dependencyMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DependencyDTO> findOne(Long id) {
        LOG.debug("Request to get Dependency : {}", id);
        return dependencyRepository.findById(id).map(dependencyMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Dependency : {}", id);
        dependencyRepository.deleteById(id);
    }
}

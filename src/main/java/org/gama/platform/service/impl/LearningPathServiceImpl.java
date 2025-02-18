package org.gama.platform.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.gama.platform.domain.LearningPath;
import org.gama.platform.repository.LearningPathRepository;
import org.gama.platform.service.LearningPathService;
import org.gama.platform.service.dto.LearningPathDTO;
import org.gama.platform.service.mapper.LearningPathMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link org.gama.platform.domain.LearningPath}.
 */
@Service
@Transactional
public class LearningPathServiceImpl implements LearningPathService {

    private static final Logger LOG = LoggerFactory.getLogger(LearningPathServiceImpl.class);

    private final LearningPathRepository learningPathRepository;

    private final LearningPathMapper learningPathMapper;

    public LearningPathServiceImpl(LearningPathRepository learningPathRepository, LearningPathMapper learningPathMapper) {
        this.learningPathRepository = learningPathRepository;
        this.learningPathMapper = learningPathMapper;
    }

    @Override
    public LearningPathDTO save(LearningPathDTO learningPathDTO) {
        LOG.debug("Request to save LearningPath : {}", learningPathDTO);
        LearningPath learningPath = learningPathMapper.toEntity(learningPathDTO);
        learningPath = learningPathRepository.save(learningPath);
        return learningPathMapper.toDto(learningPath);
    }

    @Override
    public LearningPathDTO update(LearningPathDTO learningPathDTO) {
        LOG.debug("Request to update LearningPath : {}", learningPathDTO);
        LearningPath learningPath = learningPathMapper.toEntity(learningPathDTO);
        learningPath = learningPathRepository.save(learningPath);
        return learningPathMapper.toDto(learningPath);
    }

    @Override
    public Optional<LearningPathDTO> partialUpdate(LearningPathDTO learningPathDTO) {
        LOG.debug("Request to partially update LearningPath : {}", learningPathDTO);

        return learningPathRepository
            .findById(learningPathDTO.getId())
            .map(existingLearningPath -> {
                learningPathMapper.partialUpdate(existingLearningPath, learningPathDTO);

                return existingLearningPath;
            })
            .map(learningPathRepository::save)
            .map(learningPathMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LearningPathDTO> findAll() {
        LOG.debug("Request to get all LearningPaths");
        return learningPathRepository.findAll().stream().map(learningPathMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LearningPathDTO> findOne(Long id) {
        LOG.debug("Request to get LearningPath : {}", id);
        return learningPathRepository.findById(id).map(learningPathMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete LearningPath : {}", id);
        learningPathRepository.deleteById(id);
    }
}

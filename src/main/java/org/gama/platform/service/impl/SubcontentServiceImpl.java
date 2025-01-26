package org.gama.platform.service.impl;

import java.util.Optional;
import org.gama.platform.domain.Subcontent;
import org.gama.platform.repository.SubcontentRepository;
import org.gama.platform.service.SubcontentService;
import org.gama.platform.service.dto.SubcontentDTO;
import org.gama.platform.service.mapper.SubcontentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link org.gama.platform.domain.Subcontent}.
 */
@Service
@Transactional
public class SubcontentServiceImpl implements SubcontentService {

    private static final Logger LOG = LoggerFactory.getLogger(SubcontentServiceImpl.class);

    private final SubcontentRepository subcontentRepository;

    private final SubcontentMapper subcontentMapper;

    public SubcontentServiceImpl(SubcontentRepository subcontentRepository, SubcontentMapper subcontentMapper) {
        this.subcontentRepository = subcontentRepository;
        this.subcontentMapper = subcontentMapper;
    }

    @Override
    public SubcontentDTO save(SubcontentDTO subcontentDTO) {
        LOG.debug("Request to save Subcontent : {}", subcontentDTO);
        Subcontent subcontent = subcontentMapper.toEntity(subcontentDTO);
        subcontent = subcontentRepository.save(subcontent);
        return subcontentMapper.toDto(subcontent);
    }

    @Override
    public SubcontentDTO update(SubcontentDTO subcontentDTO) {
        LOG.debug("Request to update Subcontent : {}", subcontentDTO);
        Subcontent subcontent = subcontentMapper.toEntity(subcontentDTO);
        subcontent = subcontentRepository.save(subcontent);
        return subcontentMapper.toDto(subcontent);
    }

    @Override
    public Optional<SubcontentDTO> partialUpdate(SubcontentDTO subcontentDTO) {
        LOG.debug("Request to partially update Subcontent : {}", subcontentDTO);

        return subcontentRepository
            .findById(subcontentDTO.getId())
            .map(existingSubcontent -> {
                subcontentMapper.partialUpdate(existingSubcontent, subcontentDTO);

                return existingSubcontent;
            })
            .map(subcontentRepository::save)
            .map(subcontentMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SubcontentDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Subcontents");
        return subcontentRepository.findAll(pageable).map(subcontentMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SubcontentDTO> findOne(Long id) {
        LOG.debug("Request to get Subcontent : {}", id);
        return subcontentRepository.findById(id).map(subcontentMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Subcontent : {}", id);
        subcontentRepository.deleteById(id);
    }
}

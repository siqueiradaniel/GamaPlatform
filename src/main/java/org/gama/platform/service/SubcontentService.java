package org.gama.platform.service;

import java.util.Optional;
import org.gama.platform.service.dto.SubcontentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link org.gama.platform.domain.Subcontent}.
 */
public interface SubcontentService {
    /**
     * Save a subcontent.
     *
     * @param subcontentDTO the entity to save.
     * @return the persisted entity.
     */
    SubcontentDTO save(SubcontentDTO subcontentDTO);

    /**
     * Updates a subcontent.
     *
     * @param subcontentDTO the entity to update.
     * @return the persisted entity.
     */
    SubcontentDTO update(SubcontentDTO subcontentDTO);

    /**
     * Partially updates a subcontent.
     *
     * @param subcontentDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SubcontentDTO> partialUpdate(SubcontentDTO subcontentDTO);

    /**
     * Get all the subcontents.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SubcontentDTO> findAll(Pageable pageable);

    /**
     * Get the "id" subcontent.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SubcontentDTO> findOne(Long id);

    /**
     * Delete the "id" subcontent.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

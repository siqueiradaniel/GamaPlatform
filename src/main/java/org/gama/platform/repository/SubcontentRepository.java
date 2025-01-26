package org.gama.platform.repository;

import org.gama.platform.domain.Subcontent;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Subcontent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SubcontentRepository extends JpaRepository<Subcontent, Long> {}

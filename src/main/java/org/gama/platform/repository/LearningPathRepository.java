package org.gama.platform.repository;

import org.gama.platform.domain.LearningPath;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the LearningPath entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LearningPathRepository extends JpaRepository<LearningPath, Long> {}

package org.gama.platform.repository;

import org.gama.platform.domain.PendingStudentSubcontent;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PendingStudentSubcontent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PendingStudentSubcontentRepository extends JpaRepository<PendingStudentSubcontent, Long> {}

package org.gama.platform.repository;

import org.gama.platform.domain.Dependency;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Dependency entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DependencyRepository extends JpaRepository<Dependency, Long> {}

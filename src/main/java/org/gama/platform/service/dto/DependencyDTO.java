package org.gama.platform.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.gama.platform.domain.Dependency} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DependencyDTO implements Serializable {

    private Long id;

    private SubcontentDTO subcontent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubcontentDTO getSubcontent() {
        return subcontent;
    }

    public void setSubcontent(SubcontentDTO subcontent) {
        this.subcontent = subcontent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DependencyDTO)) {
            return false;
        }

        DependencyDTO dependencyDTO = (DependencyDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, dependencyDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DependencyDTO{" +
            "id=" + getId() +
            ", subcontent=" + getSubcontent() +
            "}";
    }
}

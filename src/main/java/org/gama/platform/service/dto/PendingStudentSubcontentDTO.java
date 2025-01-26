package org.gama.platform.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.gama.platform.domain.PendingStudentSubcontent} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PendingStudentSubcontentDTO implements Serializable {

    private Long id;

    private String currentStatus;

    private SubcontentDTO subcontent;

    private StudentDTO student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public SubcontentDTO getSubcontent() {
        return subcontent;
    }

    public void setSubcontent(SubcontentDTO subcontent) {
        this.subcontent = subcontent;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PendingStudentSubcontentDTO)) {
            return false;
        }

        PendingStudentSubcontentDTO pendingStudentSubcontentDTO = (PendingStudentSubcontentDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pendingStudentSubcontentDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PendingStudentSubcontentDTO{" +
            "id=" + getId() +
            ", currentStatus='" + getCurrentStatus() + "'" +
            ", subcontent=" + getSubcontent() +
            ", student=" + getStudent() +
            "}";
    }
}

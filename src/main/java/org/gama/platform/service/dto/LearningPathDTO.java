package org.gama.platform.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.gama.platform.domain.LearningPath} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class LearningPathDTO implements Serializable {

    private Long id;

    private Integer order;

    private ExamDTO exam;

    private SubcontentDTO subcontent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO exam) {
        this.exam = exam;
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
        if (!(o instanceof LearningPathDTO)) {
            return false;
        }

        LearningPathDTO learningPathDTO = (LearningPathDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, learningPathDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LearningPathDTO{" +
            "id=" + getId() +
            ", order=" + getOrder() +
            ", exam=" + getExam() +
            ", subcontent=" + getSubcontent() +
            "}";
    }
}

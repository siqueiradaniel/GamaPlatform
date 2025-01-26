package org.gama.platform.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A LearningPath.
 */
@Entity
@Table(name = "learning_path")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class LearningPath implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "jhi_order")
    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "students", "learningPaths" }, allowSetters = true)
    private Exam exam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "learningPaths", "dependencies", "pendingStudentSubcontents", "content" }, allowSetters = true)
    private Subcontent subcontent;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public LearningPath id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrder() {
        return this.order;
    }

    public LearningPath order(Integer order) {
        this.setOrder(order);
        return this;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Exam getExam() {
        return this.exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public LearningPath exam(Exam exam) {
        this.setExam(exam);
        return this;
    }

    public Subcontent getSubcontent() {
        return this.subcontent;
    }

    public void setSubcontent(Subcontent subcontent) {
        this.subcontent = subcontent;
    }

    public LearningPath subcontent(Subcontent subcontent) {
        this.setSubcontent(subcontent);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LearningPath)) {
            return false;
        }
        return getId() != null && getId().equals(((LearningPath) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LearningPath{" +
            "id=" + getId() +
            ", order=" + getOrder() +
            "}";
    }
}

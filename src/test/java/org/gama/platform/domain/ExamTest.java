package org.gama.platform.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gama.platform.domain.ExamTestSamples.*;
import static org.gama.platform.domain.LearningPathTestSamples.*;
import static org.gama.platform.domain.StudentTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.gama.platform.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ExamTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Exam.class);
        Exam exam1 = getExamSample1();
        Exam exam2 = new Exam();
        assertThat(exam1).isNotEqualTo(exam2);

        exam2.setId(exam1.getId());
        assertThat(exam1).isEqualTo(exam2);

        exam2 = getExamSample2();
        assertThat(exam1).isNotEqualTo(exam2);
    }

    @Test
    void studentTest() {
        Exam exam = getExamRandomSampleGenerator();
        Student studentBack = getStudentRandomSampleGenerator();

        exam.addStudent(studentBack);
        assertThat(exam.getStudents()).containsOnly(studentBack);
        assertThat(studentBack.getExam()).isEqualTo(exam);

        exam.removeStudent(studentBack);
        assertThat(exam.getStudents()).doesNotContain(studentBack);
        assertThat(studentBack.getExam()).isNull();

        exam.students(new HashSet<>(Set.of(studentBack)));
        assertThat(exam.getStudents()).containsOnly(studentBack);
        assertThat(studentBack.getExam()).isEqualTo(exam);

        exam.setStudents(new HashSet<>());
        assertThat(exam.getStudents()).doesNotContain(studentBack);
        assertThat(studentBack.getExam()).isNull();
    }

    @Test
    void learningPathTest() {
        Exam exam = getExamRandomSampleGenerator();
        LearningPath learningPathBack = getLearningPathRandomSampleGenerator();

        exam.addLearningPath(learningPathBack);
        assertThat(exam.getLearningPaths()).containsOnly(learningPathBack);
        assertThat(learningPathBack.getExam()).isEqualTo(exam);

        exam.removeLearningPath(learningPathBack);
        assertThat(exam.getLearningPaths()).doesNotContain(learningPathBack);
        assertThat(learningPathBack.getExam()).isNull();

        exam.learningPaths(new HashSet<>(Set.of(learningPathBack)));
        assertThat(exam.getLearningPaths()).containsOnly(learningPathBack);
        assertThat(learningPathBack.getExam()).isEqualTo(exam);

        exam.setLearningPaths(new HashSet<>());
        assertThat(exam.getLearningPaths()).doesNotContain(learningPathBack);
        assertThat(learningPathBack.getExam()).isNull();
    }
}

package org.gama.platform.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gama.platform.domain.PendingStudentSubcontentTestSamples.*;
import static org.gama.platform.domain.StudentTestSamples.*;
import static org.gama.platform.domain.SubcontentTestSamples.*;

import org.gama.platform.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PendingStudentSubcontentTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PendingStudentSubcontent.class);
        PendingStudentSubcontent pendingStudentSubcontent1 = getPendingStudentSubcontentSample1();
        PendingStudentSubcontent pendingStudentSubcontent2 = new PendingStudentSubcontent();
        assertThat(pendingStudentSubcontent1).isNotEqualTo(pendingStudentSubcontent2);

        pendingStudentSubcontent2.setId(pendingStudentSubcontent1.getId());
        assertThat(pendingStudentSubcontent1).isEqualTo(pendingStudentSubcontent2);

        pendingStudentSubcontent2 = getPendingStudentSubcontentSample2();
        assertThat(pendingStudentSubcontent1).isNotEqualTo(pendingStudentSubcontent2);
    }

    @Test
    void subcontentTest() {
        PendingStudentSubcontent pendingStudentSubcontent = getPendingStudentSubcontentRandomSampleGenerator();
        Subcontent subcontentBack = getSubcontentRandomSampleGenerator();

        pendingStudentSubcontent.setSubcontent(subcontentBack);
        assertThat(pendingStudentSubcontent.getSubcontent()).isEqualTo(subcontentBack);

        pendingStudentSubcontent.subcontent(null);
        assertThat(pendingStudentSubcontent.getSubcontent()).isNull();
    }

    @Test
    void studentTest() {
        PendingStudentSubcontent pendingStudentSubcontent = getPendingStudentSubcontentRandomSampleGenerator();
        Student studentBack = getStudentRandomSampleGenerator();

        pendingStudentSubcontent.setStudent(studentBack);
        assertThat(pendingStudentSubcontent.getStudent()).isEqualTo(studentBack);

        pendingStudentSubcontent.student(null);
        assertThat(pendingStudentSubcontent.getStudent()).isNull();
    }
}

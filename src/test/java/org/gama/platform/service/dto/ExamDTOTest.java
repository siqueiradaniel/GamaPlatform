package org.gama.platform.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.gama.platform.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ExamDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ExamDTO.class);
        ExamDTO examDTO1 = new ExamDTO();
        examDTO1.setId(1L);
        ExamDTO examDTO2 = new ExamDTO();
        assertThat(examDTO1).isNotEqualTo(examDTO2);
        examDTO2.setId(examDTO1.getId());
        assertThat(examDTO1).isEqualTo(examDTO2);
        examDTO2.setId(2L);
        assertThat(examDTO1).isNotEqualTo(examDTO2);
        examDTO1.setId(null);
        assertThat(examDTO1).isNotEqualTo(examDTO2);
    }
}

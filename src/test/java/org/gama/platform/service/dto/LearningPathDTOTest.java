package org.gama.platform.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.gama.platform.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class LearningPathDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(LearningPathDTO.class);
        LearningPathDTO learningPathDTO1 = new LearningPathDTO();
        learningPathDTO1.setId(1L);
        LearningPathDTO learningPathDTO2 = new LearningPathDTO();
        assertThat(learningPathDTO1).isNotEqualTo(learningPathDTO2);
        learningPathDTO2.setId(learningPathDTO1.getId());
        assertThat(learningPathDTO1).isEqualTo(learningPathDTO2);
        learningPathDTO2.setId(2L);
        assertThat(learningPathDTO1).isNotEqualTo(learningPathDTO2);
        learningPathDTO1.setId(null);
        assertThat(learningPathDTO1).isNotEqualTo(learningPathDTO2);
    }
}

package org.gama.platform.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.gama.platform.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SubcontentDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SubcontentDTO.class);
        SubcontentDTO subcontentDTO1 = new SubcontentDTO();
        subcontentDTO1.setId(1L);
        SubcontentDTO subcontentDTO2 = new SubcontentDTO();
        assertThat(subcontentDTO1).isNotEqualTo(subcontentDTO2);
        subcontentDTO2.setId(subcontentDTO1.getId());
        assertThat(subcontentDTO1).isEqualTo(subcontentDTO2);
        subcontentDTO2.setId(2L);
        assertThat(subcontentDTO1).isNotEqualTo(subcontentDTO2);
        subcontentDTO1.setId(null);
        assertThat(subcontentDTO1).isNotEqualTo(subcontentDTO2);
    }
}

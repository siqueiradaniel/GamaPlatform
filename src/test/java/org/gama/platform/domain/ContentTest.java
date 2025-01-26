package org.gama.platform.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gama.platform.domain.ContentTestSamples.*;
import static org.gama.platform.domain.SubcontentTestSamples.*;

import java.util.HashSet;
import java.util.Set;
import org.gama.platform.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ContentTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Content.class);
        Content content1 = getContentSample1();
        Content content2 = new Content();
        assertThat(content1).isNotEqualTo(content2);

        content2.setId(content1.getId());
        assertThat(content1).isEqualTo(content2);

        content2 = getContentSample2();
        assertThat(content1).isNotEqualTo(content2);
    }

    @Test
    void subcontentTest() {
        Content content = getContentRandomSampleGenerator();
        Subcontent subcontentBack = getSubcontentRandomSampleGenerator();

        content.addSubcontent(subcontentBack);
        assertThat(content.getSubcontents()).containsOnly(subcontentBack);
        assertThat(subcontentBack.getContent()).isEqualTo(content);

        content.removeSubcontent(subcontentBack);
        assertThat(content.getSubcontents()).doesNotContain(subcontentBack);
        assertThat(subcontentBack.getContent()).isNull();

        content.subcontents(new HashSet<>(Set.of(subcontentBack)));
        assertThat(content.getSubcontents()).containsOnly(subcontentBack);
        assertThat(subcontentBack.getContent()).isEqualTo(content);

        content.setSubcontents(new HashSet<>());
        assertThat(content.getSubcontents()).doesNotContain(subcontentBack);
        assertThat(subcontentBack.getContent()).isNull();
    }
}

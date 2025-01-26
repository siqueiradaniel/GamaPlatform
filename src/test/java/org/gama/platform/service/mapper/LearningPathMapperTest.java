package org.gama.platform.service.mapper;

import static org.gama.platform.domain.LearningPathAsserts.*;
import static org.gama.platform.domain.LearningPathTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LearningPathMapperTest {

    private LearningPathMapper learningPathMapper;

    @BeforeEach
    void setUp() {
        learningPathMapper = new LearningPathMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getLearningPathSample1();
        var actual = learningPathMapper.toEntity(learningPathMapper.toDto(expected));
        assertLearningPathAllPropertiesEquals(expected, actual);
    }
}

package org.gama.platform.service.mapper;

import static org.gama.platform.domain.DependencyAsserts.*;
import static org.gama.platform.domain.DependencyTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DependencyMapperTest {

    private DependencyMapper dependencyMapper;

    @BeforeEach
    void setUp() {
        dependencyMapper = new DependencyMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getDependencySample1();
        var actual = dependencyMapper.toEntity(dependencyMapper.toDto(expected));
        assertDependencyAllPropertiesEquals(expected, actual);
    }
}

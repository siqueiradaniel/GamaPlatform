package org.gama.platform.service.mapper;

import static org.gama.platform.domain.SubcontentAsserts.*;
import static org.gama.platform.domain.SubcontentTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubcontentMapperTest {

    private SubcontentMapper subcontentMapper;

    @BeforeEach
    void setUp() {
        subcontentMapper = new SubcontentMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getSubcontentSample1();
        var actual = subcontentMapper.toEntity(subcontentMapper.toDto(expected));
        assertSubcontentAllPropertiesEquals(expected, actual);
    }
}

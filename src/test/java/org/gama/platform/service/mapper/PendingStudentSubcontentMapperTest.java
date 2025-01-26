package org.gama.platform.service.mapper;

import static org.gama.platform.domain.PendingStudentSubcontentAsserts.*;
import static org.gama.platform.domain.PendingStudentSubcontentTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PendingStudentSubcontentMapperTest {

    private PendingStudentSubcontentMapper pendingStudentSubcontentMapper;

    @BeforeEach
    void setUp() {
        pendingStudentSubcontentMapper = new PendingStudentSubcontentMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPendingStudentSubcontentSample1();
        var actual = pendingStudentSubcontentMapper.toEntity(pendingStudentSubcontentMapper.toDto(expected));
        assertPendingStudentSubcontentAllPropertiesEquals(expected, actual);
    }
}

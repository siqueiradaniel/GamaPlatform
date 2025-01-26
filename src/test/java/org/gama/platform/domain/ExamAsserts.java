package org.gama.platform.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertExamAllPropertiesEquals(Exam expected, Exam actual) {
        assertExamAutoGeneratedPropertiesEquals(expected, actual);
        assertExamAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertExamAllUpdatablePropertiesEquals(Exam expected, Exam actual) {
        assertExamUpdatableFieldsEquals(expected, actual);
        assertExamUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertExamAutoGeneratedPropertiesEquals(Exam expected, Exam actual) {
        assertThat(expected)
            .as("Verify Exam auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertExamUpdatableFieldsEquals(Exam expected, Exam actual) {
        assertThat(expected)
            .as("Verify Exam relevant properties")
            .satisfies(e -> assertThat(e.getName()).as("check name").isEqualTo(actual.getName()))
            .satisfies(e -> assertThat(e.getDescription()).as("check description").isEqualTo(actual.getDescription()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertExamUpdatableRelationshipsEquals(Exam expected, Exam actual) {
        // empty method
    }
}

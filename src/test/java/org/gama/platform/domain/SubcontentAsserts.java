package org.gama.platform.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class SubcontentAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSubcontentAllPropertiesEquals(Subcontent expected, Subcontent actual) {
        assertSubcontentAutoGeneratedPropertiesEquals(expected, actual);
        assertSubcontentAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSubcontentAllUpdatablePropertiesEquals(Subcontent expected, Subcontent actual) {
        assertSubcontentUpdatableFieldsEquals(expected, actual);
        assertSubcontentUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSubcontentAutoGeneratedPropertiesEquals(Subcontent expected, Subcontent actual) {
        assertThat(expected)
            .as("Verify Subcontent auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSubcontentUpdatableFieldsEquals(Subcontent expected, Subcontent actual) {
        assertThat(expected)
            .as("Verify Subcontent relevant properties")
            .satisfies(e -> assertThat(e.getName()).as("check name").isEqualTo(actual.getName()))
            .satisfies(e -> assertThat(e.getDescription()).as("check description").isEqualTo(actual.getDescription()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSubcontentUpdatableRelationshipsEquals(Subcontent expected, Subcontent actual) {
        assertThat(expected)
            .as("Verify Subcontent relationships")
            .satisfies(e -> assertThat(e.getContent()).as("check content").isEqualTo(actual.getContent()));
    }
}

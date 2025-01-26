package org.gama.platform.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gama.platform.domain.DependencyAsserts.*;
import static org.gama.platform.web.rest.TestUtil.createUpdateProxyForBean;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.gama.platform.IntegrationTest;
import org.gama.platform.domain.Dependency;
import org.gama.platform.repository.DependencyRepository;
import org.gama.platform.service.dto.DependencyDTO;
import org.gama.platform.service.mapper.DependencyMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link DependencyResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class DependencyResourceIT {

    private static final String ENTITY_API_URL = "/api/dependencies";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private DependencyRepository dependencyRepository;

    @Autowired
    private DependencyMapper dependencyMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDependencyMockMvc;

    private Dependency dependency;

    private Dependency insertedDependency;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Dependency createEntity() {
        return new Dependency();
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Dependency createUpdatedEntity() {
        return new Dependency();
    }

    @BeforeEach
    public void initTest() {
        dependency = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedDependency != null) {
            dependencyRepository.delete(insertedDependency);
            insertedDependency = null;
        }
    }

    @Test
    @Transactional
    void createDependency() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Dependency
        DependencyDTO dependencyDTO = dependencyMapper.toDto(dependency);
        var returnedDependencyDTO = om.readValue(
            restDependencyMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(dependencyDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            DependencyDTO.class
        );

        // Validate the Dependency in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedDependency = dependencyMapper.toEntity(returnedDependencyDTO);
        assertDependencyUpdatableFieldsEquals(returnedDependency, getPersistedDependency(returnedDependency));

        insertedDependency = returnedDependency;
    }

    @Test
    @Transactional
    void createDependencyWithExistingId() throws Exception {
        // Create the Dependency with an existing ID
        dependency.setId(1L);
        DependencyDTO dependencyDTO = dependencyMapper.toDto(dependency);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restDependencyMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(dependencyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Dependency in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllDependencies() throws Exception {
        // Initialize the database
        insertedDependency = dependencyRepository.saveAndFlush(dependency);

        // Get all the dependencyList
        restDependencyMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dependency.getId().intValue())));
    }

    @Test
    @Transactional
    void getDependency() throws Exception {
        // Initialize the database
        insertedDependency = dependencyRepository.saveAndFlush(dependency);

        // Get the dependency
        restDependencyMockMvc
            .perform(get(ENTITY_API_URL_ID, dependency.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dependency.getId().intValue()));
    }

    @Test
    @Transactional
    void getNonExistingDependency() throws Exception {
        // Get the dependency
        restDependencyMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingDependency() throws Exception {
        // Initialize the database
        insertedDependency = dependencyRepository.saveAndFlush(dependency);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the dependency
        Dependency updatedDependency = dependencyRepository.findById(dependency.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedDependency are not directly saved in db
        em.detach(updatedDependency);
        DependencyDTO dependencyDTO = dependencyMapper.toDto(updatedDependency);

        restDependencyMockMvc
            .perform(
                put(ENTITY_API_URL_ID, dependencyDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(dependencyDTO))
            )
            .andExpect(status().isOk());

        // Validate the Dependency in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedDependencyToMatchAllProperties(updatedDependency);
    }

    @Test
    @Transactional
    void putNonExistingDependency() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        dependency.setId(longCount.incrementAndGet());

        // Create the Dependency
        DependencyDTO dependencyDTO = dependencyMapper.toDto(dependency);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDependencyMockMvc
            .perform(
                put(ENTITY_API_URL_ID, dependencyDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(dependencyDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Dependency in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchDependency() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        dependency.setId(longCount.incrementAndGet());

        // Create the Dependency
        DependencyDTO dependencyDTO = dependencyMapper.toDto(dependency);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDependencyMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(dependencyDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Dependency in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamDependency() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        dependency.setId(longCount.incrementAndGet());

        // Create the Dependency
        DependencyDTO dependencyDTO = dependencyMapper.toDto(dependency);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDependencyMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(dependencyDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Dependency in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateDependencyWithPatch() throws Exception {
        // Initialize the database
        insertedDependency = dependencyRepository.saveAndFlush(dependency);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the dependency using partial update
        Dependency partialUpdatedDependency = new Dependency();
        partialUpdatedDependency.setId(dependency.getId());

        restDependencyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDependency.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedDependency))
            )
            .andExpect(status().isOk());

        // Validate the Dependency in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertDependencyUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedDependency, dependency),
            getPersistedDependency(dependency)
        );
    }

    @Test
    @Transactional
    void fullUpdateDependencyWithPatch() throws Exception {
        // Initialize the database
        insertedDependency = dependencyRepository.saveAndFlush(dependency);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the dependency using partial update
        Dependency partialUpdatedDependency = new Dependency();
        partialUpdatedDependency.setId(dependency.getId());

        restDependencyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDependency.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedDependency))
            )
            .andExpect(status().isOk());

        // Validate the Dependency in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertDependencyUpdatableFieldsEquals(partialUpdatedDependency, getPersistedDependency(partialUpdatedDependency));
    }

    @Test
    @Transactional
    void patchNonExistingDependency() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        dependency.setId(longCount.incrementAndGet());

        // Create the Dependency
        DependencyDTO dependencyDTO = dependencyMapper.toDto(dependency);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDependencyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, dependencyDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(dependencyDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Dependency in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchDependency() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        dependency.setId(longCount.incrementAndGet());

        // Create the Dependency
        DependencyDTO dependencyDTO = dependencyMapper.toDto(dependency);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDependencyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(dependencyDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Dependency in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamDependency() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        dependency.setId(longCount.incrementAndGet());

        // Create the Dependency
        DependencyDTO dependencyDTO = dependencyMapper.toDto(dependency);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDependencyMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(dependencyDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Dependency in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteDependency() throws Exception {
        // Initialize the database
        insertedDependency = dependencyRepository.saveAndFlush(dependency);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the dependency
        restDependencyMockMvc
            .perform(delete(ENTITY_API_URL_ID, dependency.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return dependencyRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected Dependency getPersistedDependency(Dependency dependency) {
        return dependencyRepository.findById(dependency.getId()).orElseThrow();
    }

    protected void assertPersistedDependencyToMatchAllProperties(Dependency expectedDependency) {
        assertDependencyAllPropertiesEquals(expectedDependency, getPersistedDependency(expectedDependency));
    }

    protected void assertPersistedDependencyToMatchUpdatableProperties(Dependency expectedDependency) {
        assertDependencyAllUpdatablePropertiesEquals(expectedDependency, getPersistedDependency(expectedDependency));
    }
}

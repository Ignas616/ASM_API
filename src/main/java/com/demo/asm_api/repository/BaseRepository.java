package com.demo.asm_api.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Base data access object
 */
public interface BaseRepository {
    /**
     * Stores given entity to database
     *
     * @param entity  Some entity object to save
     */
    void save(Object entity);

    /**
     * Stores collection of entities to database
     *
     * @param entities  Some entities objects to save
     */
    void saveAll(Collection<?> entities);


    /**
     * Removes given entity from database
     *
     * @param entity Some entity object to delete
     */
    void delete(Object entity);

    /**
     * Removed collection of entities from database
     *
     * @param entities Some entities objects to delete
     */
    void deleteAll(Collection<?> entities);

    /**
     * Load entity from database by it's ID
     *
     * @param clazz Class of an entity object
     * @param id Entity unique id
     * @return entity object or null if object is not found
     */
    <T> T get(Class<T> clazz, Serializable id);

    /**
     * Load all data by class
     */
    <T> List<T> getAll(Class<T> clazz);

    public void merge(Object entity);
}
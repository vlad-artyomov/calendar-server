package com.artyomov.persistence.repository;

import com.artyomov.persistence.jpa.AbstractEntity;

import java.util.List;

/**
 * Interface for repository classes, that should perform basic CRUD operations.
 *
 * @author <a href="mailto:artyomov.dev@gmail.com">Vlad Artyomov</a>
 *         Date: 23.04.17
 *         Time: 16:31
 */
public interface GenericRepository<T extends AbstractEntity> {

    T findById (Object id, Class<T> entityClass);

    List<T> findAll ();

    T save (T entity);

    void update (T entity);

    void delete (Object id, Class<T> entityClass);

    void flush ();
}

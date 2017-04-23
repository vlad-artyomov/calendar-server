package com.artyomov.persistence.repository;

import com.artyomov.persistence.jpa.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Abstract superclass for repository classes. Has implementation of basic CRUD operations.
 *
 * @author <a href="mailto:artyomov.dev@gmail.com">Vlad Artyomov</a>
 *         Date: 23.04.17
 *         Time: 16:33
 */
public abstract class AbstractGenericRepository<T extends AbstractEntity> implements GenericRepository<T> {

    @PersistenceContext(unitName = "calendar-server")
    protected EntityManager entityManager;

    @Override
    public T findById(Object id, Class<T> entityClass) {
        return entityManager.find(entityClass, id);
    }

    public abstract T findById (Long id);

    public abstract List<T> findAll ();

    @Override
    public T save(T entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return entity;
        } catch (Exception e) {
            String s = "Could not save entity. Error = " + e;
//            logger.error(s);
            throw new RuntimeException(s);
        }
    }

    @Override
    public void update(T entity) {
        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            String s = "Could not update entity. Error=" + e;
//            logger.error(s);
            throw new RuntimeException(s);
        }
    }

    @Override
    public void delete(Object id, Class<T> entityClass) {
        T byId = this.findById(id, entityClass);

        if (null == byId) {
//            logger.warn("Entity with id=" + id + " not found. Cannot delete");
            return;
        }

        try {
            entityManager.remove(byId);
        } catch (Exception e) {
            String s = "Could not delete entity. Error=" + e;
//            logger.error(s);
            throw new RuntimeException(s);
        }
    }

    @Override
    public void flush() {
        entityManager.flush();
    }
}

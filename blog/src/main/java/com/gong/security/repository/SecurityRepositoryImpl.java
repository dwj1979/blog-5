package com.gong.security.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by SNOW on 2018.02.01.
 */
public class SecurityRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID>
        implements SecurityRepository<T, ID> {

    public SecurityRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

}

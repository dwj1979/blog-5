package com.gong.security.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by SNOW on 2018.02.01.
 */
@NoRepositoryBean
public interface SecurityRepository<T, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID> {

}
package com.example.singletable.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.singletable.entity.Species;

/**
 * Of course, we don't want Spring to create a bean of these repositories since
 * we won't inject them anywhere. @NoRepositoryBean does exactly this: when we
 * mark a child interface of org.springframework.data.repository.Repository,
 * Spring won't create a bean out of it.
 * 
 * @author engaly
 *
 */
@NoRepositoryBean
public interface SpeciesRepo extends CrudRepository<Species, Long> {

}

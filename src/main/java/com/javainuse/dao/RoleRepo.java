package com.javainuse.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {

	Role findByRole(String name);
}

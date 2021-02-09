package com.portfolio.passman.repositories;

import com.portfolio.passman.models.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Role to the rest of the application
 */
public interface RoleRepository
    extends CrudRepository<Role, Long>
{
    Role findByName(String thename);
}

package com.portfolio.passman.services;

import com.portfolio.passman.models.Role;
import com.portfolio.passman.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * Implements the RoleService Interface
 */
@Transactional
@Service(value = "roleService")
public class RoleServiceImpl
    implements RoleService
{
    /**
     * Connects this service to the Role Model
     */
    @Autowired
    RoleRepository rolerepos;

    @Override
    public Role findByName(String name)
    {
        Role rr = rolerepos.findByName(name);

        if (rr != null)
        {
            return rr;
        } else
        {
            throw new EntityNotFoundException(name);
        }
    }
    
    @Override public Role save(Role role) throws Exception
    {
        if (role.getUsers().size() > 0)
        {
            throw new Exception("Users not updated through roles");
        }
        return rolerepos.save(role);
    }
    
    @Override public void deleteAllRoles()
    {
        rolerepos.deleteAll();
    }
}

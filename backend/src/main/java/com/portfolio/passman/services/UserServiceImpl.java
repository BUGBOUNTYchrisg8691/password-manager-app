package com.portfolio.passman.services;

import com.portfolio.passman.models.Role;
import com.portfolio.passman.models.User;
import com.portfolio.passman.models.UserRoles;
import com.portfolio.passman.repositories.RoleRepository;
import com.portfolio.passman.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * Implements UserService Interface
 */
@Transactional
@Service(value = "userService")
public class UserServiceImpl
    implements UserService
{
    /**
     * Connects this service to the User table.
     */
    @Autowired
    private UserRepository userrepos;

    @Autowired
    private RoleRepository rolerepos;

    @Override
    public User findByName(String name)
    {
        User uu = userrepos.findByUsername(name.toLowerCase());
        if (uu == null)
        {
            throw new EntityNotFoundException("User name " + name + " not found!");
        }
        return uu;
    }

    @Override
    public User save(User user)
    {
        User newUser = new User();

        if (user.getUserid() != 0)
        {
            userrepos.findById(user.getUserid())
                .orElseThrow(() -> new EntityNotFoundException("User id " + user.getUserid() + " not found!"));
            newUser.setUserid(user.getUserid());
        }

        newUser.setUsername(user.getUsername()
            .toLowerCase());
        newUser.setPasswordNoEncrypt(user.getPassword());

        newUser.getRoles()
            .clear();
        for (UserRoles ur : user.getRoles())
        {
            Role addRole = rolerepos.findById(ur.getRole()
                .getRoleid())
                .orElseThrow(() -> new EntityNotFoundException("Role id " + ur.getRole()
                    .getRoleid() + " not found!"));

            newUser.getRoles()
                .add(new UserRoles(newUser,
                    addRole));
        }

        return userrepos.save(newUser);
    }
    
    @Override public void deleteAllUsers()
    {
        userrepos.deleteAll();
    }
}

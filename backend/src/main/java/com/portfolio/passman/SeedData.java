package com.portfolio.passman;

import com.portfolio.passman.models.Role;
import com.portfolio.passman.models.User;
import com.portfolio.passman.models.UserRoles;
import com.portfolio.passman.services.RoleService;
import com.portfolio.passman.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
@ConditionalOnProperty(prefix = "command.line.runner", value = "enabled", havingValue = "true", matchIfMissing = true)
public class SeedData implements CommandLineRunner
{
	@Autowired private RoleService roleService;
	
	@Autowired private UserService userService;
	
	@Override public void run(String... args) throws Exception
	{
		roleService.deleteAllRoles();
		userService.deleteAllUsers();
		
		Role r1 = new Role("ADMIN");
		r1 = roleService.save(r1);
		
		Role r2 = new Role("USER");
		r2 = roleService.save(r2);
		
		Role r3 = new Role("DATA");
		r3 = roleService.save(r3);
		
		User u1 = new User();
		u1.setUsername("admin");
		u1.setPassword("password");
		u1.getRoles().add(new UserRoles(u1, r1));
		u1.getRoles().add(new UserRoles(u1, r2));
		u1.getRoles().add(new UserRoles(u1, r3));
		u1 = userService.save(u1);
		
		User u2 = new User();
		u2.setUsername("user1");
		u2.setPassword("password");
		u2.getRoles().add(new UserRoles(u2, r2));
		u2 = userService.save(u2);
		
		User u3 = new User();
		u3.setUsername("datauser");
		u3.setPassword("password");
		u3.getRoles().add(new UserRoles(u3, r2));
		u3.getRoles().add(new UserRoles(u3, r3));
		u3 = userService.save(u3);
	}
}

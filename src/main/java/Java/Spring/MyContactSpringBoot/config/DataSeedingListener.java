package Java.Spring.MyContactSpringBoot.config;

import Java.Spring.MyContactSpringBoot.entity.Role;
import Java.Spring.MyContactSpringBoot.entity.User;
import Java.Spring.MyContactSpringBoot.repository.RoleRepository;
import Java.Spring.MyContactSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
//		// Roles
//		if (roleRepository.findByName("ROLE_ADMIN") == null) {
//			Role role = new Role();
//			role.setName("ROLE_ADMIN");
//			roleRepository.save(role);
//		}
//
//		if (roleRepository.findByName("ROLE_MEMBER") == null) {
//			Role role = new Role();
//			role.setName("ROLE_MEMBER");
//			roleRepository.save(role);
//		}
//
//		// Admin account
//		if (userRepository.findByEmail("admin@gmail.com") == null) {
//			User admin = new User();
//			admin.setEmail("admin@gmail.com");
//			admin.setPassword(passwordEncoder.encode("123"));
//			HashSet<Role> roles = new HashSet<>();
//			roles.add(roleRepository.findByName("ROLE_ADMIN"));
//			roles.add(roleRepository.findByName("ROLE_MEMBER"));
//			admin.setRoles(roles);
//			userRepository.save(admin);
//		}
//
//		// Member account
//		if (userRepository.findByEmail("member@gmail.com") == null) {
//			User user = new User();
//			user.setEmail("member@gmail.com");
//			user.setPassword(passwordEncoder.encode("123456"));
//			HashSet<Role> roles = new HashSet<>();
//			roles.add(roleRepository.findByName("ROLE_MEMBER"));
//			user.setRoles(roles);
//			userRepository.save(user);
//		}
	}

}

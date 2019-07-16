package Java.Spring.MyContactSpringBoot.repository;

import Java.Spring.MyContactSpringBoot.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
    Role findByName (String name);
}

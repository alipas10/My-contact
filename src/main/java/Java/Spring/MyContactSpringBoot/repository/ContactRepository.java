package Java.Spring.MyContactSpringBoot.repository;

import Java.Spring.MyContactSpringBoot.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByName(String term);

}

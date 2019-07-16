package Java.Spring.MyContactSpringBoot.service;

import Java.Spring.MyContactSpringBoot.entity.Contact;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService {

//    Page<Contact> page ();

    Iterable<Contact> findAll();

    List<Contact> search(String term);

    Contact findOne(Integer id);

    void save(Contact contact);

    void delete(Integer id);

}

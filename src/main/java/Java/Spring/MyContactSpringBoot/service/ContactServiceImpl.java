package Java.Spring.MyContactSpringBoot.service;

import Java.Spring.MyContactSpringBoot.entity.Contact;
import Java.Spring.MyContactSpringBoot.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

//    @Override
//    public Page<Contact> page() {
//        return contactRepository.findAll(PageRequest.of(0.5));
//    }

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> search(String term) {
        return contactRepository.findByName(term);
    }

    @Override
    public Contact findOne(Integer id) {
        return contactRepository.findOne(id);
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void delete(Integer id) {
        contactRepository.delete(id);
    }
}

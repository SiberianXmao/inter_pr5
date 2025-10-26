package com.training.inter_pr5.services;

import com.training.inter_pr5.models.Contact;
import com.training.inter_pr5.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContactService {

    private final ContactRepository contactRepository;



    public Contact findById(int id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElse(null);
    }

    public Contact findByName(String name) {
        Optional<Contact> contact =  contactRepository.findByName(name);
        return contact.orElse(null);
    }

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    @Transactional
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Transactional
    public void update(int id, Contact contact) {
        contact.setId(id);
        contactRepository.save(contact);
    }

    @Transactional
    public void delete(int id) {
        contactRepository.deleteById(id);
    }





}

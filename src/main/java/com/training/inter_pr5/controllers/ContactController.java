package com.training.inter_pr5.controllers;


import com.training.inter_pr5.models.Contact;
import com.training.inter_pr5.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> findAll() {
        return ResponseEntity.ok(contactService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Contact> findById(@PathVariable int id) {
        return ResponseEntity.ok(contactService.findById(id));
    }


    @PutMapping("/{id}")
    public void update(@PathVariable int id,@RequestBody Contact contact) {
        contactService.update(id, contact);
    }

    @PostMapping
    public void save(@RequestBody Contact contact) {
        contactService.save(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        contactService.delete(id);
    }



}

package com.training.inter_pr5.repositories;

import com.training.inter_pr5.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

    Optional<Contact> findByName(String name);

    Optional<Contact> findAllByName(String name);


}

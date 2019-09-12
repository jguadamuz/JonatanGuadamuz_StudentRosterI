package com.jonatan.studentrosteri.data.repository;

import com.jonatan.studentrosteri.data.entity.Contact;

import org.springframework.data.repository.CrudRepository;

/**
 * ContactRepository
 */
public interface ContactRepository extends CrudRepository<Contact, Long>{

    
}
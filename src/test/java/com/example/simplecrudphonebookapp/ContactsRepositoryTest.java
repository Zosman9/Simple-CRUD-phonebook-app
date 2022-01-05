package com.example.simplecrudphonebookapp;

import com.example.simplecrudphonebookapp.contacts.ContactRepository;
import com.example.simplecrudphonebookapp.contacts.Contacts;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ContactsRepositoryTest {
    @Autowired private ContactRepository repo;

    @Test //New Contact addition test
    public void testAddNew(){
        Contacts contact = new Contacts();
        contact.setEmail("zosman007@gmail.com");
        contact.setPhoneNumber(123);
        contact.setFirstName("Zainab");
        contact.setLastName("Osman");
        contact.setAddress("jahsdahsdka");

        Contacts savedContact= repo.save(contact);

        Assertions.assertThat(savedContact).isNotNull();
        Assertions.assertThat(savedContact.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll(){
        Iterable<Contacts> contacts = repo.findAll();
        Assertions.assertThat(contacts).hasSizeGreaterThan(0);

        for (Contacts contact : contacts) {
            System.out.println(contact);
        }
    }

    @Test
    public void testUpdate(){
        Integer contactID = 1;
        Optional<Contacts> optionalContacts = repo.findById(contactID);
        Contacts contact = optionalContacts.get();
        contact.setAddress("WestSide");
        repo.save(contact);

        Contacts updatedContact = repo.findById(contactID).get();
        Assertions.assertThat(updatedContact.getAddress()).isEqualTo("WestSide");

    }

    @Test
    public void testGet(){
        Integer contactID = 4;
        Optional<Contacts> optionalContacts = repo.findById(contactID);
        Assertions.assertThat(optionalContacts).isPresent();
        System.out.println(optionalContacts.get());
    }

    @Test
    public void testDelete(){
        Integer contactID = 4;
        repo.deleteById(contactID);
        Optional<Contacts> optionalContacts = repo.findById(contactID);
        Assertions.assertThat(optionalContacts).isNotPresent();
    }


}

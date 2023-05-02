package de.jonasrotert.eventplanner.core.repository.contact;

import de.jonasrotert.eventplanner.core.domain.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactRepository  extends JpaRepository<Contact, UUID>, RevisionRepository<Contact, UUID, Integer> {

}

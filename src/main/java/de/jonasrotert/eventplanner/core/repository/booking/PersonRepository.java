package de.jonasrotert.eventplanner.core.repository.booking;

import de.jonasrotert.eventplanner.core.domain.booking.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID>, RevisionRepository<Person, UUID, Integer> {

}

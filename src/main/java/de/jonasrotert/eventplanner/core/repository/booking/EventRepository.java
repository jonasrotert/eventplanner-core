package de.jonasrotert.eventplanner.core.repository.booking;

import de.jonasrotert.eventplanner.core.domain.booking.Event;
import de.jonasrotert.eventplanner.core.domain.booking.EventState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID>, RevisionRepository<Event, UUID, Integer> {

	@Override
	List<Event> findAll();

	List<Event> findByState(EventState state);
}

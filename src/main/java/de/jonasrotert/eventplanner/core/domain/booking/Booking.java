package de.jonasrotert.eventplanner.core.domain.booking;

import de.jonasrotert.eventplanner.core.domain.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Audited
public class Booking extends BaseEntity {

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
	@NotEmpty
	private final List<Person> persons = new ArrayList<>();

	@NotNull
	private LocalDateTime bookingDate;

	@Enumerated(EnumType.STRING)
	@NotNull
	private BookingState state;

	@ManyToOne
	@NotNull
	private Event event;

}

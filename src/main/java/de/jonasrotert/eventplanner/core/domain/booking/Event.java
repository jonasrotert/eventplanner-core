package de.jonasrotert.eventplanner.core.domain.booking;

import de.jonasrotert.eventplanner.core.domain.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Audited
public class Event extends BaseEntity {

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event", orphanRemoval = true)
	private final List<Booking> bookings = new ArrayList<Booking>();

	@NotBlank
	private String title;

	private String intro;

	@NotBlank
	private String description;

	@NotNull
	private LocalDate startDate;

	@NotNull
	private LocalDate endDate;

	@Valid
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
	private Address address;

	@Enumerated(EnumType.STRING)
	private EventState state;

	@Valid
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
	private DeadlineConfiguration deadlineConfiguration;

	@Valid
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
	private CapacityConfiguration capacityConfiguration;

	@Valid
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
	private BookingConfiguration bookingConfiguration;

	@Valid
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
	private PricingConfiguration pricingConfiguration;

}

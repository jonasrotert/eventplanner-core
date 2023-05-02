package de.jonasrotert.eventplanner.core.domain.booking;

import de.jonasrotert.eventplanner.core.domain.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Audited
public class BookingConfiguration extends BaseEntity {


	private Boolean askForBirthday;

	private Boolean askForSex;

	private Boolean askForFurtherBookings;

}

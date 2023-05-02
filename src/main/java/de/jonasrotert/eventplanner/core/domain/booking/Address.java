package de.jonasrotert.eventplanner.core.domain.booking;

import de.jonasrotert.eventplanner.core.domain.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
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
public class Address extends BaseEntity {


	private String description;

	@NotBlank
	private String street;

	@NotBlank
	private String postalCode;

	@NotBlank
	private String village;

	@NotBlank
	private String country;

}

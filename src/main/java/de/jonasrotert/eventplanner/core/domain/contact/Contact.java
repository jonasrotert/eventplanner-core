package de.jonasrotert.eventplanner.core.domain.contact;

import de.jonasrotert.eventplanner.core.domain.booking.Address;
import de.jonasrotert.eventplanner.core.domain.booking.Sex;
import de.jonasrotert.eventplanner.core.domain.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity(name = "Contact")
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Contact extends BaseEntity {

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@Email
	private String email;

	@Enumerated(EnumType.STRING)
	private Status status;

	private LocalDate birthday;

	@Enumerated(EnumType.STRING)
	private Sex sex;

	@Enumerated(EnumType.STRING)
	private FormOfAddress formOfAddress;

	@Enumerated(EnumType.STRING)
	private Salutation salutation;

	@Enumerated(EnumType.STRING)
	private Language language;

	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL, optional = true)
	private Address address;
}

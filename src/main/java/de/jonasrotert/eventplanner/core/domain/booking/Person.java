package de.jonasrotert.eventplanner.core.domain.booking;

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

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity(name = "Person")
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Person extends BaseEntity {

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@Email
	private String email;

	private Date birthday;

	@Enumerated(EnumType.STRING)
	private Sex sex;

	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	private Address address;

	@ManyToOne
	private Booking booking;
}

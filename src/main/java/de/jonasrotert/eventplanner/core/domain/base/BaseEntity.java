package de.jonasrotert.eventplanner.core.domain.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
public abstract class BaseEntity {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "uuid")
	@Getter
	protected UUID id;

	@Getter
	@Setter
	private String createdBy;

	@Version
	@Getter
	@Setter
	private Long version;

	private Logger getLogger() {
		return LogManager.getLogger(this.getClass());
	}

	@PrePersist
	private void prePersist() {
		this.createdBy = "jonas-dev";
		this.getLogger().info("{} wird gespeichert ...", this.getClass().getSimpleName());
	}

	@PostPersist
	private void postPersist() {
		this.getLogger().info("{} wurde mit ID {} und Revision {} gespeichert.", this.getClass().getSimpleName(), this.id, this.version);
	}

	@PreUpdate
	private void preUpdate() {
		this.getLogger().info("{} mit ID {} und Revision {} wird geändert...", this.getClass().getSimpleName(), this.id, this.version);
	}

	@PostUpdate
	private void postUpdate() {
		this.getLogger().info("{} mit ID {} und Revision {} wurde erfolgreich geändert.", this.getClass().getSimpleName(), this.id, this.version);
	}

	@PreRemove
	private void preRemove() {
		this.getLogger().info("{} mit ID {} und Revision {} wird gelöscht...", this.getClass().getSimpleName(), this.id, this.version);
	}

	@PostRemove
	private void postRemove() {
		this.getLogger().info("{} mit ID {} und Revision {} wurde erfolgreich gelöscht.", this.getClass().getSimpleName(), this.id, this.version);
	}
}

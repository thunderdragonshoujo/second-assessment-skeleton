package com.cooksys.secondassessmentskeleton.pojo;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Required;

@Entity
public class Hashtag {
	@Id
	@GeneratedValue
	private Long id;
	private String label;
	private Timestamp firstUsed;
	private Timestamp lastUsed;

	public Hashtag() {
		this.firstUsed = Timestamp.from(Instant.now());
	}

	public Hashtag(String label, Timestamp lastUsed) {
		super();
		this.label = label;
		this.lastUsed = lastUsed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hashtag other = (Hashtag) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	@Required
	public void setLabel(String label) {
		this.label = label;
	}

	public Timestamp getFirstUsed() {
		return firstUsed;
	}

	@Required
	public void setFirstUsed(Timestamp firstUsed) {
		this.firstUsed = firstUsed;
	}

	public Timestamp getLastUsed() {
		return lastUsed;
	}

	@Required
	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

	@Override
	public String toString() {
		return "Hashtag [id=" + id + ", label=" + label + ", firstUsed=" + firstUsed + ", lastUsed=" + lastUsed + "]";
	}

}

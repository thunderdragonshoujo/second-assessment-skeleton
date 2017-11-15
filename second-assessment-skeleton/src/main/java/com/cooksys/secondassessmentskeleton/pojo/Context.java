package com.cooksys.secondassessmentskeleton.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Context {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Tweet target;
	@OneToOne
	private Tweet before;
	@OneToOne
	private Tweet after;

	public Context() {

	}

	public Context(Tweet target,Tweet before, Tweet after) {
		super();
		this.target = target;
		this.before = before;
		this.after = after;
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
		Context other = (Context) obj;
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

	public Tweet getTarget() {
		return target;
	}

	public void setTarget(Tweet target) {
		this.target = target;
	}

	public Tweet getBefore() {
		return before;
	}

	public void setBefore(Tweet before) {
		this.before = before;
	}

	public Tweet getAfter() {
		return after;
	}

	public void setAfter(Tweet after) {
		this.after = after;
	}

}

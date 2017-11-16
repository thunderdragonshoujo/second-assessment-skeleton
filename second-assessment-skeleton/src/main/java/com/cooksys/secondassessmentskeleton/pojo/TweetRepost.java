package com.cooksys.secondassessmentskeleton.pojo;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Required;

@Entity
public class TweetRepost {
	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne
	private User author;
	private Timestamp posted;
	@OneToOne
	private Tweet repostOf;

	public TweetRepost() {
		this.posted = Timestamp.from(Instant.now());
	}

	public TweetRepost(User author,Tweet repostOf) {
		super();
		this.author = author;
		this.repostOf = repostOf;
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
		TweetRepost other = (TweetRepost) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	@Required
	public void setAuthor(User author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

	@Required
	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}

	public Tweet getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(Tweet repostOf) {
		this.repostOf = repostOf;
	}

	@Override
	public String toString() {
		return "TweetRepost [id=" + id + ", author=" + author + ", posted=" + posted + ", repostOf=" + repostOf + "]";
	}

}

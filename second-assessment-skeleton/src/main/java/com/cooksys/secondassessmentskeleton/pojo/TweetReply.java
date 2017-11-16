package com.cooksys.secondassessmentskeleton.pojo;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Required;

@Entity
public class TweetReply {
	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne
	private User author;
	private Timestamp posted;
	private String content;
	@OneToOne
	private Tweet inReplyTo;

	public TweetReply() {
		this.posted = Timestamp.from(Instant.now());
	}

	public TweetReply(User author, String content, Tweet inReplyTo) {
		super();
		this.author = author;
		this.content = content;
		this.inReplyTo = inReplyTo;
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
		TweetReply other = (TweetReply) obj;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Tweet getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(Tweet inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	@Override
	public String toString() {
		return "TweetReply [id=" + id + ", author=" + author + ", posted=" + posted + ", content=" + content
				+ ", inReplyTo=" + inReplyTo + "]";
	}

}

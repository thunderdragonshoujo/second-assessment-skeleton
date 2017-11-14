package com.cooksys.secondassessmentskeleton.dto;

import java.sql.Timestamp;

import com.cooksys.secondassessmentskeleton.pojo.Tweet;
import com.cooksys.secondassessmentskeleton.pojo.User;

public class TweetDto {
	private Integer id;
	private User author;
	private Timestamp posted;
	private String content;
	private Tweet inReplyTo;
	private Tweet repostOf;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

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

	public Tweet getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(Tweet repostOf) {
		this.repostOf = repostOf;
	}

}

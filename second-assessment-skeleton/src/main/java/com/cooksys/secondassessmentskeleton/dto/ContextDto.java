package com.cooksys.secondassessmentskeleton.dto;

import com.cooksys.secondassessmentskeleton.pojo.Tweet;

public class ContextDto {
	private Long id;
	private Tweet target;
	private Tweet before;
	private Tweet after;

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

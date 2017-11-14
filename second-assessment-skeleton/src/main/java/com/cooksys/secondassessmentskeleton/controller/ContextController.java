package com.cooksys.secondassessmentskeleton.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.service.ContextService;

@RestController
@RequestMapping("context")
public class ContextController {
	private ContextService contextService;

	public ContextController(ContextService contextService) {
		super();
		this.contextService = contextService;
	}

}

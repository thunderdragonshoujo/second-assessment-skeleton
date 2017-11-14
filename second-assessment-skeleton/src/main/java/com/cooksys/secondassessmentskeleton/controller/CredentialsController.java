package com.cooksys.secondassessmentskeleton.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.secondassessmentskeleton.service.CredentialsService;
@RestController
@RequestMapping("credentials")
public class CredentialsController {
	
		private CredentialsService credentialsService;

		public CredentialsController(CredentialsService CredentialsService) {
			super();
			this.credentialsService = CredentialsService;

}
}

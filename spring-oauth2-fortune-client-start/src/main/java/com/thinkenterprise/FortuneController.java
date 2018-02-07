package com.thinkenterprise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FortuneController {

	Logger logger = LoggerFactory.getLogger(FortuneController.class);

	@Autowired
	FortuneService service;

	@RequestMapping("/random")
	public Fortune randomFortune() {
		return service.randomFortune();
	}

}

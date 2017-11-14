package com.thinkenterprise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FortuneController {
	
	Logger logger = LoggerFactory.getLogger(FortuneController.class);
	
	private String indexName;
	
	@Autowired
	FortuneRepository fortuneRepository;

	@PreAuthorize("#oauth2.hasScope('random')")
	@RequestMapping("/random")
	public Fortune fortune() {
		logger.info("FortuneController:fortune called ...");
		
		Iterable<Fortune> result = fortuneRepository.randomFortunes();
		
		return result.iterator().next();
	}

}

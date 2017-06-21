package com.thinkenterprise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@EnableConfigurationProperties(FortuneProperties.class)
public class FortuneService {

	Logger logger = LoggerFactory.getLogger(FortuneService.class);

	@Autowired
	FortuneProperties fortuneProperties;

	@Autowired
	RestTemplate restTemplate;

	public Fortune randomFortune() {
		logger.info("CS: calling http://fortunes/random.");
		
		Fortune fortune = restTemplate.getForObject("http://localhost:9001/resource/random", Fortune.class);

		logger.info("CR: received response from http://fortunes/random.");
		return fortune;
	}

	

}

/*
 * Copyright (C) 2016 Thinkenterprise
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * @author Michael Schaefer
 */

package com.thinkenterprise;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
//@RestController
public class ApplicationAuthorizationServer   {

	
		
	public static void main(String[] args) {
        SpringApplication.run(ApplicationAuthorizationServer.class, args);
    }
	
	/*
	@RequestMapping("/authorizationserver")
	public ResponseEntity<String> securedRequest(@RequestParam("code") String code) {
		System.out.println(code);
		return new ResponseEntity<>(code, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/authorizationserver")
	public ResponseEntity<String> securedRequestPost(@RequestParam("code") String code) {
		return new ResponseEntity<>(code, HttpStatus.OK);
	}
	
	@RequestMapping("/securedRequest")
	public String securedRequest() {
		return "securedRequest";	
	}
	
	@RequestMapping("/notSecuredRequest")
	public String notSecuredRequest() {
		return "notSecuredRequest";	
	}
	
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
	  System.out.println("user is called");
	  return user;
	}
	
	*/
	
	
   
}

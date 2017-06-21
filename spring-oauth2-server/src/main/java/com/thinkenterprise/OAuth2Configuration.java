package com.thinkenterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * Configuration of the Authorization Server 
 * 
 * 
 * @author Michael Schäfer 
 * 
 * */


@Configuration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private AuthenticationManager authenticationManager;
	
		
	private AuthorizationServerTokenServices test;
	
	/**
	 * 
	 * Configuration of the clients which stored in memory. It can also be stored in 
	 * a database. The following client attributes has to be configured. 
	 * 
	 * 
	 * @author Michael Schäfer  
	 * */
	
	@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
          clients.inMemory()
                  .withClient("testClient")
                  .secret("testClient")
                  .authorizedGrantTypes("client_credentials", "authorization_code")
                  .scopes("random").
                  accessTokenValiditySeconds(3600).refreshTokenValiditySeconds(3600).
                  autoApprove(true).
                  redirectUris("http://localhost:9999");
      }
	
	
	/**
	 * 
	 * With AuthorizationServerEndpointsConfigurer we can configure the Authorization Server Endpoints. 
	 * For our JWT we can't use the default token store. We need a JWT Store which stores our JWT.
	 * 
	 *  
	 * 
	 * 
	 * @author Michael Schäfer 
	 * */
	
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtTokenConverter()).authenticationManager(authenticationManager);
    }

	/**
	 * 
	 * Create a new JWT Token Store with an JWT Token Converter.  
	 * The Bean will be autowired form some other security infrastructure Beans. 
	 * The Method will also be called form the AuthorizationServerEndpointsConfigurer configuration. 
	 * 
	 * 
	 * @author Michael Schäfer 
	 * */
	
	 @Bean
     TokenStore tokenStore() {
         return new JwtTokenStore(jwtTokenConverter());
     }
	
	 /**
		 * 
		 * Create a new JWT Token Store with an JWT Token Converter.  
		 * The Bean will be autowired form some other security infrastructure Beans. 
		 * The Method will also be called form the AuthorizationServerEndpointsConfigurer configuration. 
		 * 
		 * 
		 * @author Michael Schäfer 
		 * */
	 
	 /**
		 * 
		 * Create an key pair (Public/Private) for JWT Signing an set the keys in th created Toke Converter. 
		 * Create an JWT Token Converter for our IoC Container wich will be autowired 
		 * an used by the AuthorizationServerEndpointsConfigurer. 
		 * 
		 * @author Michael Schäfer 
		 * */
	 
	 @Bean
     protected JwtAccessTokenConverter jwtTokenConverter() {
		 
		 // Load the key store 
         KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory( 
        		 new ClassPathResource("jwt.jks"), "mySecretKey".toCharArray());
         
         JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
         
         // set the key pair in our token converter 
         converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"));
         
         return converter;
         
     }
     
	
}

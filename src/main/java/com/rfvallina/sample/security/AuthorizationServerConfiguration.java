package com.rfvallina.sample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private AuthenticationManager authenticationManager;

	@Autowired
	public AuthorizationServerConfiguration(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) {
		configurer.tokenStore(tokenStore());
		configurer.authenticationManager(authenticationManager);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("spring-sample").secret("{noop}a843jdf8ak").scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token");
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	/**
	 * Enables calling of /oauth/check_token to all, remove to disable
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
		oauthServer.checkTokenAccess("permitAll()");
	}

}

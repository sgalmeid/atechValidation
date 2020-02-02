package br.com.atech.test.flightservice.infra.clients;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Objects;

@Configuration
@Profile("!integrationTest")
public class ConfigureClients {

    @Bean
    public RequestInterceptor getToken(){

        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                Authentication authentication =
                        SecurityContextHolder.getContext().getAuthentication();
                if(Objects.nonNull(authentication)){
                    OAuth2AuthenticationDetails details =
                            ((OAuth2AuthenticationDetails) authentication.getDetails());
                    ;
                    requestTemplate.header("Authorization", "Bearer"+details.getTokenValue());
                }
            }
        };

    }
}

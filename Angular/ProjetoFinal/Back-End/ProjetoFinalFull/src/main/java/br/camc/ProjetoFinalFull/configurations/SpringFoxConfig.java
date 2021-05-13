package br.camc.ProjetoFinalFull.configurations;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.jsonwebtoken.lang.Collections;
import io.swagger.v3.oas.models.security.SecurityScheme;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SpringFoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiKey apiKey() {
		return new ApiKey("Token Access", "Authorization", SecurityScheme.In.HEADER.name());
	}
	
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(securityReference()).build();
		
	}

	private List<SecurityReference> securityReference() {
		AuthorizationScope[] authorizationScopes = {new AuthorizationScope("Unlimited","Full API Permission")};
		return Collections.arrayToList(new SecurityReference("Token Access", authorizationScopes));
	}

}
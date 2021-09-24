package br.com.eicon.leonardo.eicon.util.config;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.tags(new Tag("Clientes", "EndPoint Clientes"))
				.tags(new Tag("Arquivos", "EndPoint Arquivos")).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.eicon.leonardo.eicon.api"))
				.paths(PathSelectors.any())
				.build().apiInfo(metaData()).genericModelSubstitutes(Optional.class)
				.directModelSubstitute(LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(OffsetDateTime.class, java.util.Date.class)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.eicon.leonardo.eicon.api"))
				.paths(PathSelectors.any())
				.build();

	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Eicon Api").description("").version("0.0.1").build();
	}

	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("").version("").license("").description("");
		return builder.build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
          .deepLinking(true)
          .defaultModelRendering(ModelRendering.EXAMPLE)
          .displayRequestDuration(true)
          .docExpansion(DocExpansion.NONE)
          .filter(true)
          .operationsSorter(OperationsSorter.ALPHA)
          .tagsSorter(TagsSorter.ALPHA)
          .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
          .build();
    }
}

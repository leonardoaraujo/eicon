package br.com.eicon.leonardo.eicon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.eicon.leonardo.eicon.util.config.FileStorageConfig;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageConfig.class
})
@EnableAutoConfiguration
public class EiconApplication { 
	public static void main(String[] args) {
		SpringApplication.run(EiconApplication.class, args);
	}

}

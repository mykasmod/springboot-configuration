package org.asmod.microservices.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

// -D and env vars work too!
@SpringBootApplication
@EnableConfigurationProperties //Tells Spring we want to map properties to a POJO
public class SpringbootConfigurationApplication {

	//Using Property Placeholder Resolution Mechanism to inject the value into a method
	@Value("${configuration.projectName}")
	void setProjectname(String projectName) {
		System.out.println("setting project name: " + projectName);
	}
	
	//Inject the global object "Environment"
	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("setting environment: " + env.getProperty("configuration.projectName"));
	}
	
	//Injecting POJO of type ConfigurationProjectProperties
	@Autowired
	void setConfigurationProjectProperties(ConfigurationProjectProperties cp) {
		System.out.println("configurationProjectProperties.projectName: " + cp.getProjectName());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootConfigurationApplication.class, args);
	}
	
	
}
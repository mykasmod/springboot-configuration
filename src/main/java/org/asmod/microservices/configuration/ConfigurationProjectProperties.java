package org.asmod.microservices.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component //regular Spring bean, it's injectable
@ConfigurationProperties("configuration") //this specifies that we want to map all properties that are prefix with "configuration" onto POJO/Java Bean Object
class ConfigurationProjectProperties{
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
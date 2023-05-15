package com.polarbookshop.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "polar")
@Data
public class PolarProperties {

	/*
	 * Precedence of resolving polar.greeting: CLI -> JVM -> ENV variable -> Property file -> Default
	 * 
	 * It can be set from CLI with: java -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar --polar.greeting="Welcome to the catalog from CLI [:%s]"
	 * It can be set from JVM properties with: java -Dpolar.greeting="Welcome to the catalog from JVM [:%s]" -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar
	 * It can be set from ENV variable with: POLAR_GREETING="Welcome to the catalog from ENV [:%s]" java -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar
	*/
	private String greeting;

}

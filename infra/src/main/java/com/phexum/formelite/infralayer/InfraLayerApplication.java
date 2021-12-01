package com.phexum.formelite.infralayer;

import com.phexum.formHandler.domain.common.DomainComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
		includeFilters = {
				@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
		},basePackages ={"com.phexum.formelite.infralayer","com.phexum.formHandler.domain"}
)

public class InfraLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfraLayerApplication.class, args);

	}

}

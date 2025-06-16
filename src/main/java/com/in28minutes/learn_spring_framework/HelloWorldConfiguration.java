package com.in28minutes.learn_spring_framework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};

record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
    @Bean
    String name() {
		return "Demetriusz";
	}
    
    @Bean 
     int age() {
    	return 15;
    }
    
    @Bean
    Person person1() {
    	var person = new Person("Demetriusz", 20,  new Address("First Line", "City"));
    	return person;
    }
    
    @Bean
    Person person2MethodCall() {
    	var person = new Person(name(), age(), address());
    	return person;
    }
    
    @Bean
    @Primary
    Person person3Parameters(String name, int age, Address address3) {
    	var person = new Person(name, age, address3);
    	return person;
    }
    
    

    @Bean
    Person person5ParametersQualifier(String name, int age,@Qualifier("address3Qualifier") Address address) {
    	var person = new Person(name, age, address);
    	return person;
    }
    
    @Bean(name = "address2")
    @Primary
    Address address() {
		var address = new Address("First Line", "City");
		return address;
	}
    
    @Bean(name = "address3")
    @Qualifier("address3Qualifier")
    Address address3() {
		var address = new Address("Second Line", "City");
		return address;
	}
}

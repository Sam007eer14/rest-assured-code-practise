package com.api.utils;

import java.util.Locale;

import net.datafaker.Faker;

public class FakerDemo {
	public static void main(String[] args) {
		
		
		Faker faker = new Faker(new Locale("en-IND"));
		String firstName = faker.name().firstName();
		System.out.println(firstName);
		String addressCity = faker.address().city();
		System.out.println(addressCity);
		System.out.println(faker.number().digits(10));
		System.out.println(faker.numerify("9933######"));
		System.out.println(faker.internet().emailAddress());
	}

}

package com.olooeez.ebank.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {
	private static Person awesomeCustomer;

	@BeforeEach
	void init() {
		awesomeCustomer = new Person("Luiz Felipe", Gender.MALE, 19);
	}

	@Test
	void nameShouldBeLuiz() {
		assertEquals(awesomeCustomer.getName(), "Luiz Felipe");
	}

	@Test
	void genderShouldBeMale() {
		assertEquals(awesomeCustomer.getGender(), Gender.MALE);
	}

	@Test
	void ageShouldBe19() {
		assertEquals(awesomeCustomer.getAge(), 19);
	}

	@Test
	void theNameNowShouldBeRenato() {
		awesomeCustomer.setName("Renato");

		assertEquals(awesomeCustomer.getName(), "Renato");
	}

	@Test
	void theGenderNowShouldBeFemale() {
		awesomeCustomer.setGender(Gender.FEMALE);

		assertEquals(awesomeCustomer.getGender(), Gender.FEMALE);
	}

	@Test
	void theAgeNowShouldBe20() {
		awesomeCustomer.setAge(20);

		assertEquals(awesomeCustomer.getAge(), 20);
	}
}

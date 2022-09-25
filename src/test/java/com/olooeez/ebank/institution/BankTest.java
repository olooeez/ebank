package com.olooeez.ebank.institution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.olooeez.ebank.account.BaseAccount;
import com.olooeez.ebank.customer.Gender;
import com.olooeez.ebank.customer.Person;

public class BankTest {
	private static Bank testBank;

	@BeforeEach
	void init() {
		testBank = new Bank("Minbo");
	}

	@Test
	void bankNameShouldBeMinbo() {
		assertEquals("Minbo", testBank.getName());
	}

	@Test
	void thereShouldBeAwesomeClient() {
		BaseAccount awesomeClient = new BaseAccount(
			new Person("Luiz Felipe", Gender.MALE, 19
		));

		testBank.insertClient(awesomeClient);
		
		assertEquals(awesomeClient, testBank.getClients().get(0));
	}
}

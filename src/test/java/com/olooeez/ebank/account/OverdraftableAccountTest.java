package com.olooeez.ebank.account;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.olooeez.ebank.customer.Gender;
import com.olooeez.ebank.customer.Person;

public class OverdraftableAccountTest {
	private static OverdraftableAccount awesomeOTAccount;
	private static Person awesomeClient;

	@BeforeEach
	void init() {
		awesomeClient = new Person("Luiz Felipe", Gender.MALE, 19);

		awesomeOTAccount = new OverdraftableAccount(awesomeClient);
	}

	@Test
	void shouldWithdrawWithFee() throws Exception {
		awesomeOTAccount.deposit(10);


		assertThrows(UnsupportedOperationException.class, () -> awesomeOTAccount.withdraw(20));
		assertEquals(10 - awesomeOTAccount.getFee(), awesomeOTAccount.getBalance());
	}

	@Test
	void withdrawWithoutFee() throws Exception {
		awesomeOTAccount.deposit(20);

		assertDoesNotThrow(() -> awesomeOTAccount.withdraw(20));
		assertEquals(0, awesomeOTAccount.getBalance());
	}

	@Test
	void ensureAllArgsConstructor() {
		OverdraftableAccount secondOTAccount = new OverdraftableAccount(awesomeClient, 420, 15.0);

		assertEquals(awesomeClient, secondOTAccount.getClient());
		assertEquals(420, secondOTAccount.getAgency());
		assertEquals(15.0, secondOTAccount.getFee());
	}
}

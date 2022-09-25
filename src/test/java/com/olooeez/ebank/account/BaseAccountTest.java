package com.olooeez.ebank.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.olooeez.ebank.customer.Gender;
import com.olooeez.ebank.customer.Person;

public class BaseAccountTest {
	private static BaseAccount coolAccount;
	private static BaseAccount toAccount;
	private static Person awesomeClient;
	private static Person anotherAwesomeClient;

	@Test
	@BeforeEach
	void init() {
		awesomeClient = new Person("Luiz Felipe", Gender.MALE, 19);
		anotherAwesomeClient = new Person("Daniel Orivaldo da Silva", Gender.MALE, 39);

		coolAccount = new BaseAccount(awesomeClient);
		toAccount = new BaseAccount(anotherAwesomeClient);
	}

	@Test
	void accountShouldInitializeCustomAgency() {
		BaseAccount customAgency = new BaseAccount(awesomeClient, 20);

		assertEquals(20, customAgency.getAgency());
	}

	@Test
	void clientShouldBeEqual() {
		assertEquals(awesomeClient, coolAccount.getClient());
	}

	@Test
	void numberShouldBeGreaterThan1() {
		assertTrue(coolAccount.getNumber() > 1);
	}

	@Test
	void shouldWithdraw420() throws Exception {
		coolAccount.deposit(420);
		coolAccount.withdraw(420);

		assertEquals(0, coolAccount.getBalance());
	}

	@Test
	void cantWithdraw420of69() {
		coolAccount.deposit(69);

		assertThrows(UnsupportedOperationException.class, () -> coolAccount.withdraw(420));
	}

	@Test
	void shouldTransferAllTheMoney() throws Exception {
		coolAccount.deposit(5);
		coolAccount.transfer(toAccount);

		assertEquals(0, coolAccount.getBalance());
		assertEquals(5, toAccount.getBalance());
	}

	@Test
	void cantTransferNoMoney() {
		assertThrows(UnsupportedOperationException.class, () -> coolAccount.transfer(toAccount));
	}

	@Test
	void shouldTransfer5() throws Exception {
		coolAccount.deposit(5);
		coolAccount.transfer(toAccount, 5);

		assertEquals(0, coolAccount.getBalance());
		assertEquals(5, toAccount.getBalance());
	}

	@Test
	void cantTransfer0() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> coolAccount.transfer(toAccount, 0));
	}

	@Test
	void cantTransfer5of0() throws Exception {
		assertThrows(UnsupportedOperationException.class, () -> coolAccount.transfer(toAccount, 5));
	}
}

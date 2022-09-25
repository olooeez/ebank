package com.olooeez.ebank.account;

import com.olooeez.ebank.customer.Person;

import lombok.Getter;

@Getter
public class BaseAccount {
	private static final int DEFAULT_AGENCY = 1;
	private static int SEQUENCIAL = 1;

	protected Person client;
	protected int agency;
	protected int number;
	protected double balance;

	public BaseAccount(Person client) {
		this.client = client;
		this.agency = DEFAULT_AGENCY;
		this.number = SEQUENCIAL++;
		this.balance = 0.0;
	}

	public BaseAccount(final Person client, final int customAgency) {
		this.client = client;
		this.agency = customAgency;
		this.number = SEQUENCIAL++;
		this.balance = 0.0;
	}

	public void deposit(final double amount) {
		this.balance += amount;
	}

	public void withdraw(final double amount) throws Exception {
		if (amount > this.balance) {
			throw new UnsupportedOperationException("the total you want to withdraw is greater than your balance");
		}

		this.balance -= amount;
	}

	public void transfer(BaseAccount to) throws Exception {
		if (this.balance == 0.0) {
			throw new UnsupportedOperationException("your account has an empty balance to be able to transfer something");
		}

		to.balance += this.balance;
		this.balance = 0.0;
	}

	public void transfer(BaseAccount to, final double amount) throws Exception {
		if (amount <= 0.0) {
			throw new IllegalArgumentException("the total for transfer must be greater than zero");
		}

		if (amount > this.balance) {
			throw new UnsupportedOperationException("your total balance is less than the amount you want to transfer");
		}

		to.balance += amount;
		this.balance -= amount;
	}
}

package com.olooeez.ebank.account;

import com.olooeez.ebank.customer.Person;

import lombok.Getter;

@Getter
public class OverdraftableAccount extends BaseAccount {
	private double fee = 3.0;

	public OverdraftableAccount(final Person client) {
		super(client);
	}

	public OverdraftableAccount(final Person client, final int customAgency, final double fee) {
		super(client, customAgency);

		this.fee = fee;
	}

	@Override
	public void withdraw(final double amount) throws Exception {
		if (this.balance < amount) {
			this.balance -= this.fee;
			throw new UnsupportedOperationException("the total you want to withdraw is greater than your balance");
		}

		this.balance -= amount;
	}
}

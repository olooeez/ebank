package com.olooeez.ebank.institution;

import java.util.ArrayList;

import com.olooeez.ebank.account.BaseAccount;

import lombok.Getter;

@Getter
public class Bank {
	private String name;
	private ArrayList<BaseAccount> clients;

	public Bank(final String name) {
		this.name = name;

		this.clients = new ArrayList<>();
	}

	public void insertClient(final BaseAccount client) {
		clients.add(client);
	}
}

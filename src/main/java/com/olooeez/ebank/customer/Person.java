package com.olooeez.ebank.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
	private String name;
	private Gender gender;
	private int age;
}

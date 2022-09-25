package com.olooeez.ebank;

import com.olooeez.ebank.customer.Person;
import com.olooeez.ebank.customer.Gender;

public class App {
    public static void main(String [] args) {
        Person newPerson = new Person("Luiz Felipe", Gender.MALE, 19);

        System.out.println(newPerson.hashCode());
    }
}

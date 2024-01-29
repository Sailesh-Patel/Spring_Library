package com.lbg.demo.library.domain;

public class Person {

	private String name;

	private static int count;

	private final int id = ++count;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Person.count = count;
	}

	public int getId() {
		return id;
	}
}

package com.epam.maven;

public class Palkova extends Sweets
{
	public String sweetName() {                    //polymorphism (overriding)
		return "palkova";
	}
	public int sweetPrice()
	{
		return 50;
	}
}
package com.myproject1.testecases;

import org.testng.annotations.Test;

public class Priority {

	@Test(priority = 3)
	public void Amethod1() {

		System.out.println(" AMethod 1 executed");
	}

	@Test(priority = 1)
	public void Bmethod2() {

		System.out.println(" BMethod 2 executed");
	}
    @Test
	public void Cmethod3() {

		System.out.println(" CMethod 3 executed");
	}

}

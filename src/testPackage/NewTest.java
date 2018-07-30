package testPackage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	public int a=10;
	public int b=0;
	public int c=5;
	public int div1;
	public int div2;
	/*@Parameters({ "num1", "num2", "sum" })

	@Test
	public void sum(int num1, int num2, int sum) {
		System.out.println("Sum");
		Assert.assertEquals(sum, num1 + num2);
	}*/
	
	
	@Test
	public void method1() {
		System.out.println("This is method 1");
		div1=a/b;
		System.out.println("div1 = " + div1);
	}
	
	@Test(dependsOnMethods = { "method1" })
	public void method2() {
		System.out.println("This is method 2");
		div2 = div1/c;
		System.out.println("div2 = " + div2);
	}


}

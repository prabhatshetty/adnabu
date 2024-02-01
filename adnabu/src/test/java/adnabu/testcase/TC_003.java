package adnabu.testcase;

import org.testng.annotations.Test;

public class TC_003 {
	
	 @Test	
	  public void a() {
		  System.out.println("Pass a");
	  }
	 
	 //(dependsOnMethods = "z")
	 
	 @Test
	  public void z() {
		  System.out.println("Pass z ");
	  }
	 //(priority = 0)
	 @Test(dependsOnMethods = "z")
	  public void b() {
		  System.out.println("Pass b ");
	  }
	 @Test
	  public void c() {
		  System.out.println("Pass c");
	  }
	 
}

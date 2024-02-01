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
	 @Test(priority = 1)
	  public void b() {
		  System.out.println("Pass b priority=1");
	  }
	 @Test
	  public void c() {
		  System.out.println("Pass c");
	  }
	 
}

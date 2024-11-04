package testNGOnePack;

import org.testng.annotations.Test;

public class ClassOne extends testNGOnePack.BaseClassOne{
 
 //@Test annotation describes this method as a test method
 @Test
  public void testmethodone() {
    String title = driver.getTitle();
    System.out.print("\nCurrent page title is : "+title);
    String Workdir = System.getProperty("user.dir");
    String Classpackname = this.getClass().getName();
    System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testmethodone' has been executed successfully");
  }
}
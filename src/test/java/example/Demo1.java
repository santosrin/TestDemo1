package example;

import org.testng.Assert;
import org.testng.annotations.*;

public class Demo1 {

    @BeforeSuite
    public void bs() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void bt() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void bc() {
        System.out.println("Before Class");
    }

    @BeforeGroups
    public void bg() {
        System.out.println("Before Groups");
    }

    @BeforeMethod
    public void bm(){
        System.out.println("Before Method");
    }

    @DataProvider(name = "dp")
    public Object[][] dp(){
        Object[][] obj = new Object[][] {{"A","Avalue"},{"B","Bvalue"},{"C","Cvalue"}};
        return obj;
    }
    @Test(description = "This is t1",dataProvider ="dp")
    public void t1(String key, String value){
        System.out.println("Test1 and DP check : "+  key + ":"+ value);
        Assert.assertEquals(true,true);
    }

    @Test (groups = {"sanity"},description = "This is t2",dependsOnMethods={"t1"})
    public void t2(){
        System.out.println("Test2");
    }

    @Test(description = "This is t3",enabled = false)
    public void t3(){
        System.out.println("Test3");
    }

    @Test(groups = {"sanity"},description = "This is t4",invocationCount = 1)
    public void t4(){
        System.out.println("Test4 ");
    }

    @Test
    @Parameters("browser")
    public void t5(String browser){
        System.out.println("Test5 "+ browser);
    }

    @AfterMethod
    public void am(){
        System.out.println("After Method");
    }

    @AfterGroups
    public void ag() {
        System.out.println("After Groups");
    }

    @AfterClass
    public void ac() {
        System.out.println("After Class");
    }

    @AfterTest
    public void at() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void as() {
        System.out.println("After Suite");
    }
}

package com.cal.Test;



import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import com.epam.tat.module4.Calculator;

public class MainTest {
	
	
	private static final double PI =Math.PI;
    private Calculator objCal;
    @BeforeSuite
    public void beforeSuite(ITestContext suiteTest)
    {
        System.out.println("Before TestSuite : "+suiteTest.getSuite().getName());
    }
    @BeforeClass()
    public void setUp()
    {
        objCal = new Calculator();
        System.out.println("BeforeClass");
    }

    @BeforeGroups(value ={"mathsTest"})
    public void beforeGroup()
    {
        objCal = new Calculator();
        System.out.println("Before Groups");
    }

    @BeforeMethod
    public void beforeMethod(Method method)
    {
        System.out.println(method.getName()+"Executing");
    }
    @Test(groups = {"positiveTest","mathsTest"})
    public void AdditionTest()
    {
        long iTotal;
        iTotal = objCal.sum(234567890L,987654321L);
        Assert.assertEquals(iTotal,1222222211);
    }

    


    @Test(groups = {"positiveTest","mathsTest"})
    public void Division()
    {
        double dTotal;
        dTotal = objCal.div(5.5,0.0);
        Assert.assertEquals(dTotal,Double.POSITIVE_INFINITY);
    }

    
    @Test(groups = {"positiveTest","mathsTest"})
    public void PowerTest()
    {
        double dTotal;
        dTotal = objCal.pow(3.9,2);
        Assert.assertEquals(dTotal,15.21);
    }

    @Test(groups = {"negetiveTest","mathsTest"})
    public void squareTest()
    {
        double dTotal;
        dTotal = objCal.sqrt(160);
        Assert.assertNotEquals(dTotal,12);
    }

    @Test(groups = {"negetiveTest","anglesTest"})
    public void sin30Test()
    {
        double dTotal;
        dTotal = objCal.sin(PI/6);
        Assert.assertNotEquals(dTotal,Math.sin(1));
    }
 // double multiplication  
    @Test(groups = {"positiveTest","mathsTest"})
    public void Multiplication()
    {
        double dTotal;
        dTotal = objCal.mult(4.8,3.5);
        Assert.assertEquals(dTotal,16.);
    }

    @Test(groups = {"positiveTest","mathsTest"})
    public void Subtraction()
    {
        double dTotal;
        dTotal = objCal.sub(2.3,5.1);
        Assert.assertEquals(dTotal,-4.5);
    }
    @Test(groups = {"negetiveTest","anglesTest"})
    public void cosNegativeTest()
    {
        double dResult;
        dResult = objCal.cos(0);
        Assert.assertNotEquals(dResult,2);
    }

    @Test(groups = {"negetiveTest","anglesTest"})
    public void AddNegativeTests()
    {
        double dResult;
        dResult = objCal.sub(6.5,9.8);
        Assert.assertNotEquals(dResult,16.);
    }

    @Test(groups = {"negetiveTest","mathsTest"})
    public void isNegetiveNegativeTest()
    {
        boolean blnTotal;
        blnTotal = objCal.isNegative(0);
        Assert.assertFalse(blnTotal);
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("AfterClass");
    }

    @AfterSuite
    public void afterSuite(ITestContext suiteTest)
    {
        System.out.println("After TestSuite : "+suiteTest.getSuite().getName());
    }
    
    @AfterMethod
    public void AfterMethod(ITestResult testResult,Method method)
    {
        System.out.println("Test :"+method.getName()+" , Result :"+testResult.isSuccess());
    }

    @AfterGroups(value ={"positiveTest"})
    public void afterGroup()
    {
        System.out.println("after Groups positiveTest");
    }

   
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}// Class

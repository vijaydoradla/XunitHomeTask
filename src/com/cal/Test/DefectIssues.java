package com.cal.Test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.epam.tat.module4.Calculator;

public class DefectIssues {
	
	
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

    @BeforeMethod
    public void beforeMethod(Method method)
    {
        System.out.println(method.getName()+"Executing");
    }

   

    //Pow double
    @Test
    public void ExponentTest()
    {
        double dTotal;
        dTotal = objCal.pow(4,4.69);
        Assert.assertEquals(dTotal,Math.pow(4,4.69));
    }

    //divison
    @Test(expectedExceptions = NumberFormatException.class)
    public void divideByZero()
    {
        objCal.div(6.6,0);

    }
    //Multiplication double
    @Test
    public void Multiplication()
    {
        double dTotal;
        dTotal = objCal.mult(3.6,5.4);
        Assert.assertEquals(dTotal,19.6);
    }
    //cos
    @Test
    public void cosTest()
    {
        double dTotal;
        dTotal = objCal.cos(Math.toRadians(90.0));
        Assert.assertEquals(dTotal,0.);
    }

    //tan
    @Test
    public void tanTest()
    {
        double dTotal;
        dTotal = objCal.tg(Math.toRadians(0.0));
        Assert.assertEquals(dTotal,0.);
    }
    @AfterSuite
    public void afterSuite(ITestContext testSuite)
    {
        System.out.println("After TestSuite : "+testSuite.getSuite().getName());
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("AfterClass");
    }
    @AfterMethod
    public void AfterMethod(ITestResult resultTest, Method method)
    {
        System.out.println(method.getName()+" , Result :"+resultTest.isSuccess());
    }
   

  
	
	
	
	
	

}//Class

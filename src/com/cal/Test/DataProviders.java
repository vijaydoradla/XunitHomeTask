package com.cal.Test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.tat.module4.Calculator;

public class DataProviders {
	
	Calculator objCal;
    @BeforeClass()
    public void setUp()
    {
    	objCal = new Calculator();
        System.out.println("BeforeClass");
    }
  
    @DataProvider(name = "addition")
    public Object[][] addition()
    {
        return new Object[][]{{2,3,5},
                {3,6,9},{3,7,10}
         };
    }
    @DataProvider(name = "multiplication")
    public Object[][] Multiplication()
    {
        return new Object[][]{{200,3,600},
                {300,10,3000},{7,6,42}
        };
    }
    @DataProvider(name = "Division")
    public Object[][] Division()
    {
        return new Object[][]{{5,0},
                {3,0},{6,0}
        };
    }
    @Test(dataProvider ="Division", expectedExceptions = NumberFormatException.class)
    public void DivisionTest(long firstValue,long secondValue)
    {
    	objCal.div(firstValue,secondValue);
    }

    @Test(dataProvider ="addition")
    public void Addition(long firstValue,long secondValue,long totalValue)
    {
        long iTotal;
        iTotal = objCal.sum(firstValue,secondValue);
        Assert.assertEquals(iTotal,totalValue);
    }
    @Test(dataProvider ="multiplication")
    public void MultiplicationTest(long firstValue,long secondValue,long totalValue)
    {
        long iResult;
        iResult = objCal.mult(firstValue,secondValue);
        Assert.assertEquals(iResult,totalValue);
    }
  
    @AfterClass
    public void afterClass()
    {
        System.out.println("AfterClass");
    }

	
	
	
	
	

}// Class

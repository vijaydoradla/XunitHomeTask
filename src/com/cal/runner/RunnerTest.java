package com.cal.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class RunnerTest {
	
	 public static void main(String args[])
	    {
	        TestListenerAdapter tstlistner = new TestListenerAdapter();
	        TestNG tstNg= new TestNG();
	        XmlSuite tstSuite = new XmlSuite();
	        tstSuite.setName("CustomSuite");

	        List<String> files = new ArrayList<String>();	        
	        files.add("./src/com/cal/Suite/DataProviderTest.xml");
	        
	        tstSuite.setSuiteFiles(files);

	        List<XmlSuite> suiteTests = new ArrayList<XmlSuite>();
	        suiteTests.add(tstSuite);

	        tstNg.setXmlSuites(suiteTests);
	        tstNg.run();


	    }
	
	 
	

}// Class

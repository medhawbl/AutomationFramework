package com.wbl.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.wbl.test.LoginPageTest;

public class LoggerListener extends TestListenerAdapter {


	
	Logger logger = LogManager.getLogger(LoggerListener.class);
	
		@Override
		public void onTestStart(ITestResult tr) {
			log("Test Started....");
		}

		@Override
		public void onTestSuccess(ITestResult tr) {

			log("Test '" + tr.getName() + "' PASSED");

			// This will print the class name in which the method is present
			log(tr.getTestClass());

			// This will print the priority of the method.
			// If the priority is not defined it will print the default priority as
			// 'o'
			log("Priority of this method is " + tr.getMethod().getPriority());

			System.out.println(".....");
		}

		@Override
		public void onTestFailure(ITestResult tr) {

			log("Test '" + tr.getName() + "' FAILED");
			log("Priority of this method is " + tr.getMethod().getPriority());
			System.out.println(".....");
		}

		@Override
		public void onTestSkipped(ITestResult tr) {
			log("Test '" + tr.getName() + "' SKIPPED");
			logger.info(".....");
		}

		private void log(String methodName) {
			logger.info(methodName);
		}

		private void log(IClass testClass) {
			logger.info(testClass);
		}
	}



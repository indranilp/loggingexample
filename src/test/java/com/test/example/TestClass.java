package com.test.example;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {

	public static org.apache.logging.log4j.Logger Log = LogManager.getLogger(TestClass.class);

	@BeforeMethod(alwaysRun = true)
	public void setThreadName(Method method) {
		try {

			ThreadContext.put("threadName", method.getName());

		} catch (Exception e) {
			ThreadContext.put("threadName", "LogsFile");
		}
	}

	@Test
	public void test1() {
		Log.info("test1");

	}

	@Test
	public void test2() {
		Log.info("test2");

	}
}

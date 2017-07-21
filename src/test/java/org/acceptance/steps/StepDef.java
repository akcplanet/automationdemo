package org.acceptance.steps;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.acceptance.utils.CustomerUtils;
import org.acceptance.utils.VerificationHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


@ContextConfiguration({ "classpath*:autocucumber.xml" })
public class StepDef {

	private static final Logger LOGGER = Logger.getLogger(StepDef.class.getName());
	public static final String genId = CustomerUtils.generatedId();

	@Autowired
	private VerificationHandler verificationhandler;
	
	@Given("^Pre Delete the record$")
	public void pre_Delete_the_record() {
		LOGGER.debug("ID generated :"+ genId);
		try {
			verificationhandler.deleteData(genId);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	@Given("^Process the Transaction$")
	public void insert_the_record() {
		try {
			verificationhandler.insertData(genId);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	@Then("^Perform Validation$")
	public void perform_validation()  {
		try {
			verificationhandler.verification(genId);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	@Then("^Post Delete the record$")
	public void post_Delete_the_record() {
		try {
			verificationhandler.deleteData(genId);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	


}
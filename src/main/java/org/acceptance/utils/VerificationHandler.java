package org.acceptance.utils;

import java.lang.reflect.InvocationTargetException;

import org.acceptance.database.TestDatabaseDAO;
import org.acceptance.handler.Validatorhandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class VerificationHandler {
	
	private static final Logger LOGGER = Logger.getLogger(VerificationHandler.class.getName());

	@Autowired
	private TestDatabaseDAO testdatabasedao;

	public void verification(String id) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		LOGGER.debug("Verification for data:");
		Validatorhandler.executeHandler(id, CustomerUtils.expectedCustomer(id), testdatabasedao);
	}
	
	public void insertData(String id) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		testdatabasedao.insertCustomer(CustomerUtils.createNewCustomer(CustomerUtils.inputCustomer(id),id));
	}
	
public void deleteData(String id) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	LOGGER.debug("Sterted deleting Data from table:");
		testdatabasedao.deleteCustomer(id);
	}


}

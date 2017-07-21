package org.acceptance.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.acceptance.database.TestDatabaseDAO;
import org.acceptance.utils.CustomerUtils;
import org.acceptance.utils.Validator;

public class Validatorhandler {
	
	public  static void executeHandler(String custId ,Map<String, Object> expetcedvalue ,TestDatabaseDAO testDao) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Validator.validate(testDao.getCustomer(custId), CustomerUtils.createNewCustomer(expetcedvalue,custId));
	}
}

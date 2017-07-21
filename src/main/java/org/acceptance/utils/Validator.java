package org.acceptance.utils;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.acceptance.comparator.FieldComparator;
import org.acceptance.dataobject.Customer;
import org.apache.log4j.Logger;

public class Validator {

	private static final Logger LOGGER = Logger.getLogger(Validator.class.getName());

	public static void validate(List<Customer> custList, Customer... expected) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		LOGGER.debug("validating values");
		Map<String, Map<String, Map<String, Object>>> allDiffrence = new HashMap<String, Map<String, Map<String, Object>>>();
		for (int i = 0; i < custList.size(); i++) {
			Customer cust = custList.get(i);
			Map<String, Map<String, Object>> difference = FieldComparator.compareCustomer(cust, expected[i]);
			if (!difference.isEmpty()) {
				allDiffrence.put("\nCutomer(" + cust.getCustId() + "," + i + ")", difference);
			}
		}
		assertTrue("actual mismatch with expected : \n" + allDiffrence, allDiffrence.isEmpty());
	}

}

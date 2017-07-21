package org.acceptance.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.acceptance.comparator.CustomerCompareFields;
import org.acceptance.dataobject.Customer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

public class CustomerUtils {

	private static final Logger LOGGER = Logger.getLogger(CustomerUtils.class.getName());

	public static String generatedId() {
		String retVal = "3" + new SimpleDateFormat("yyMMdd").format(new Date()) + getRandom(1, 9);
		return retVal;
	}

	private static String getRandom(int l, int h) {
		return String.format("%d", new Random().nextInt((int) 90 - 2));
	}

	public static Customer createCustomer() {
		Customer cust = new Customer();
		cust.setAge(28);
		cust.setCustId(101);
		cust.setName("Amit");
		return cust;
	}

	public static void setPropertyValuesTo(Object target, Map<String, Object> hashmap) throws IllegalAccessException, InvocationTargetException {
		for (String propertytomodify : hashmap.keySet()) {
			BeanUtils.setProperty(target, propertytomodify, hashmap.get(propertytomodify));
		}
	}

	public static Customer createNewCustomer(Map<String, Object> valueOverrides, String custId) throws IllegalAccessException, InvocationTargetException {
		Customer cust = createCustomer();
		if (valueOverrides != null) {
			setPropertyValuesTo(cust, valueOverrides);
		}
		return cust;
	}

	public static Map<String, Object> expectedCustomer(final String custid) {
		return new HashMap<String, Object>() {
			{
				put(CustomerCompareFields.custId.name(), custid);
				put(CustomerCompareFields.name.name(), "Amit");
				put(CustomerCompareFields.age.name(), 28);
			}

		};
	}

	public static Map<String, Object> inputCustomer(final String custid) {
		return new HashMap<String, Object>() {
			{
				put(CustomerCompareFields.custId.name(), custid);
				put(CustomerCompareFields.name.name(), "Amit");
				put(CustomerCompareFields.age.name(), 28);
			}

		};
	}
}

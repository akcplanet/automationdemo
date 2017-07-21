package org.acceptance.comparator;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.acceptance.dataobject.Customer;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

public class FieldComparator {

	private static final Logger LOGGER = Logger.getLogger(FieldComparator.class.getName());

	@SuppressWarnings("unchecked")
	public static Map<String, Map<String, Object>> compareCustomer(final Customer actual, final Customer expected) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Map<String, Map<String, Object>> differences = new HashMap<String, Map<String, Object>>();
		final Map<String, Object> expectedProps = BeanUtils.describe(expected);
		final Map<String, Object> actualProps = BeanUtils.describe(actual);
		for (final CustomerCompareFields propName : CustomerCompareFields.values()) {
			if (null != expectedProps.get(propName.name()) || null != actualProps.get(propName.name())) {
				if (null == expectedProps.get(propName.name()) || null == actualProps.get(propName.name()) || !expectedProps.get(propName.name()).equals(actualProps.get(propName.name()))) {
					differences.put("\n" + propName.name(), new HashMap<String, Object>() {
						private static final long serialVersionUID = 1L;
						{
							put("expected", expectedProps.get(propName.name()));
							put("got", actualProps.get(propName.name()));
						}
					});
				}
			}
		}
		LOGGER.debug("Fields with different values :" + differences);
		return differences;
	}

}

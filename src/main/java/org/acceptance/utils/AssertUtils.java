package org.acceptance.utils;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.acceptance.database.TestDatabaseDAO;
import org.apache.log4j.Logger;

public class AssertUtils {
	
	private static final Logger LOGGER = Logger.getLogger(AssertUtils.class.getName());

	public void assertCount(List<? extends Object> txnList, int expectedSize) {
		assertEquals(expectedSize, (txnList == null) ? 0 : txnList.size());
	}

}

package org.acceptance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.acceptance.dataobject.Customer;
import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rownum) throws SQLException {
		Customer cust = new Customer();
		cust.setName(rs.getString("NAME"));
		cust.setCustId(rs.getInt("CUST_ID"));
		cust.setAge(rs.getInt("AGE"));
		return cust;
	}

}

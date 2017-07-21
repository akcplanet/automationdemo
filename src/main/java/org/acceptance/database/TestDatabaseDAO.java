package org.acceptance.database;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.acceptance.dataobject.Customer;
import org.acceptance.mapper.CustomerMapper;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class TestDatabaseDAO {
	
	protected DataSource dataSource;
	protected NamedParameterJdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = Logger.getLogger(TestDatabaseDAO.class.getName());
	
	private static final String GET_CUSTOMER = "select * from customer where CUST_ID = :CUST_ID ";
	private static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (:CUSTID, :NAME, :AGE)";
	private static final String DELETE_CUSTOMER = " Delete from CUSTOMER where CUST_ID=:ID";

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Integer getCount(String query, Map<String, Object> params) {
		Integer queryForObject = jdbcTemplate.queryForObject(query, new MapSqlParameterSource(params), Integer.class);
		LOGGER.debug("Got count : " + queryForObject + "on executing query (" + query + ") with parms " + params);
		return queryForObject;
	}
	
	public List<Customer> getCustomer(String custid) {
		MapSqlParameterSource source= new MapSqlParameterSource();
		source.addValue("CUST_ID", custid);
		List<Customer> queryForObject = jdbcTemplate.query(GET_CUSTOMER, source, new CustomerMapper());
		LOGGER.debug("Got Value : " + queryForObject);
		return queryForObject;
	}

	public int insertCustomer(Customer cust) {
		MapSqlParameterSource source= new MapSqlParameterSource();
		source.addValue("CUSTID", cust.getCustId());
		source.addValue("NAME", cust.getName());
		source.addValue("AGE", cust.getAge());
		int recordcount= jdbcTemplate.update(INSERT_CUSTOMER, source);	
		LOGGER.debug("Total Record inserted in table:"+ recordcount);
		return recordcount;
	}

	public int deleteCustomer(String id) {
		MapSqlParameterSource source= new MapSqlParameterSource();
		source.addValue("ID", id);
		int recordcount= jdbcTemplate.update(DELETE_CUSTOMER, source);	
		LOGGER.debug("Total Record Deleted from table:"+ recordcount);
		return recordcount;
	}


}
